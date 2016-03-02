package dev.rapid.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import dev.rapid.util.HibernateUtil;

public class CommonDao<T> {
	private static Logger log = Logger.getLogger(CommonDao.class);

	private Class<T> clazz;

	// -----------------------BASE METHOD FOR QUERY-----------------------------
	// -------------------findAll, findById, first, last------------------------
	/**
	 * Lay ra toan bo ban ghi trong bang clazz
	 *
	 * @param clazz
	 * @return Tra ve danh sach rong neu khong co row nao trong bang
	 */
	public List<T> findAll() {
		return findAll(new String[] {});
	}// end findAll method

	/**
	 * Lay ra toan bo ban ghi trong bang clazz. Tuy nhien moi doi tuong chi gom
	 * cac thuoc tinh duoc liet ke trong columnNames
	 *
	 * @param clazz
	 * @param columnNames
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public List<T> findAll(String... columnNames) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				clazz);

		if (columnNames.length > 0) {
			setSpecifyCols(criteria, columnNames);
		}

		return (List<T>) criteria.list();
	}// end findAll method

	/**
	 * Tim row co ID = <code>id</code>
	 *
	 * @param clazz
	 * @param id
	 * @return Tra ve null neu khong co row nao thoa man
	 */
	public T findById(Integer id) {
		return findById(id, new String[] {});
	}

	/**
	 * Tim row co ID = <code>id</code>, chi select cac cot duoc chi ra trong
	 * columnNames
	 *
	 * @param clazz
	 * @param id
	 * @param columnNames
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T findById(Integer id, String... columnNames) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("id", id));

		if (columnNames.length > 0) {
			setSpecifyCols(criteria, columnNames);
		}

		List list = criteria.list();
		return (list != null && list.size() > 0) ? (T) list.get(0) : null;
	}// end findById method

	/**
	 * Lay ra row dau tien cua bang clazz
	 *
	 * @param clazz
	 * @return Tra ve null neu khong co row nao trong bang
	 */
	public T first() {
		return first(new String[] {});
	}// end first method

	/**
	 * Lay ra row dau tien cua bang clazz, chi select cac truong co trong
	 * columnNames
	 *
	 * @param clazz
	 * @param columnNames
	 * @return Tra ve null neu khong co row nao trong bang
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T first(String... columnNames) {
		Criteria criteria = getCriteria();

		criteria.addOrder(Order.asc("id"));
		criteria.setMaxResults(1);

		if (columnNames.length > 0) {
			setSpecifyCols(criteria, columnNames);
		}

		List list = criteria.list();
		return (list != null && list.size() == 1) ? (T) list.get(0) : null;
	}// end first method

	/**
	 * Lay ra row cuoi cung cua bang clazz
	 *
	 * @param clazz
	 * @return Tra ve null neu khong co row nao trong bang
	 */
	public T last() {
		return last(new String[] {});
	}// end last method

	/**
	 * Lay ra row cuoi cung cua bang clazz, chi select cac cot co trong
	 * columnNames
	 *
	 * @param clazz
	 * @return Tra ve null neu khong co row nao trong bang
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T last(String... columnNames) {
		Criteria criteria = getCriteria();

		if (columnNames.length > 0) {
			setSpecifyCols(criteria, columnNames);
		}

		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(1);
		List list = criteria.list();
		return (list != null && list.size() == 1) ? (T) list.get(0) : null;
	}// end last method

	/**
	 * Toi uu cau lenh sql INSERT. Truyen 1 list cac object vao, Method se thi
	 * hanh cau lenh INSERT INTO Tbl_Table(A,B,C) VALUES(1,2,3)(4,5,6);. Method
	 * se lay cac ten Table va Column dua tren cac Anotation Table, Column,
	 * JoinColumn cua thuoc tinh trong object.
	 *
	 * Method se xu ly theo Batch. -> cho vao List<String> -> execute
	 * List<String> batchSize la do lon cua Batch.
	 *
	 * @param objects
	 * @return
	 */
	public boolean save(List objects) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		int batchSize = 100;
		List<String> listBatch = new ArrayList<String>();
		StringBuilder builder = new StringBuilder("INSERT INTO ");
		builder.append(objects.get(0).getClass().getAnnotation(Table.class)
				.name()
				+ "(");
		Field[] fieldOfObj = objects.get(0).getClass().getDeclaredFields();
		for (int i = 0; i < fieldOfObj.length; i++) {
			fieldOfObj[i].setAccessible(true);
			if (fieldOfObj[i].getAnnotation(JoinColumn.class) != null) {
				builder.append(fieldOfObj[i].getAnnotation(JoinColumn.class)
						.name() + ",");
			} else if (fieldOfObj[i].getAnnotation(Column.class) != null) {
				builder.append(fieldOfObj[i].getAnnotation(Column.class).name()
						+ ",");
			}
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(" ) VALUES ");
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < objects.size(); i++) {
			Object obj = objects.get(i);
			temp.append("(");
			for (int k = 0; k < fieldOfObj.length; k++) {
				fieldOfObj[k].setAccessible(true);
				try {
					if (isPrimitive(fieldOfObj[k].getType().getName())) {
						temp.append(fieldOfObj[k].get(obj) + ",");
					} else {
						if (fieldOfObj[k].get(obj) != null) {
							temp.append("'" + fieldOfObj[k].get(obj) + "',");
						} else {
							temp.append(fieldOfObj[k].get(obj) + ",");
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
			temp.deleteCharAt(temp.length() - 1);
			temp.append("),");
			if (i % batchSize == 0) {
				temp.deleteCharAt(temp.length() - 1);
				listBatch.add(builder.toString() + temp.toString());
				temp = new StringBuilder();
			}
			if (i != 0 && i == objects.size() - 1) {
				temp.deleteCharAt(temp.length() - 1);
				listBatch.add(builder.toString() + temp.toString());
			}
		}
		for (String sql : listBatch) {
			sessionFactory.getCurrentSession().createSQLQuery(sql)
					.executeUpdate();
		}
		return true;
	}

	/**
	 * Method toi uu cau lenh Delete cua SQL khi delete nhieu ban ghi. Method se
	 * lay cac id cua nhieu object sau do execute.
	 *
	 * @param objects
	 * @return
	 */
	public boolean delete(List objects) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		int batchSize = 100;
		List<String> listBatch = new ArrayList<String>();
		StringBuilder builder = new StringBuilder("DELETE FROM ");
		builder.append(objects.get(0).getClass().getAnnotation(Table.class)
				.name()
				+ " WHERE ID IN (");
		Field[] fieldOfObj = objects.get(0).getClass().getDeclaredFields();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < objects.size(); i++) {
			Object obj = objects.get(i);
			for (int k = 0; k < fieldOfObj.length; k++) {
				fieldOfObj[k].setAccessible(true);
				try {
					if ("ID".equalsIgnoreCase(fieldOfObj[k].getName())) {
						temp.append(fieldOfObj[k].get(obj) + ",");
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (i % batchSize == 0) {
				temp.deleteCharAt(temp.length() - 1);
				temp.append(")");
				listBatch.add(builder.toString() + temp.toString());
				temp = new StringBuilder();
			}
			if (i != 0 && i == objects.size() - 1) {
				temp.deleteCharAt(temp.length() - 1);
				temp.append(")");
				listBatch.add(builder.toString() + temp.toString());
			}
		}
		for (String sql : listBatch) {
			System.out.println(sql);
			sessionFactory.openSession().createSQLQuery(sql).executeUpdate();
		}

		return true;
	}

	/**
	 *
	 *
	 * @param objectClass
	 * @param field
	 * @param values
	 * @param itemValue
	 * @param itemName
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	/*@SuppressWarnings("unchecked")
	public List<SelectItem> getListSelectItem(Class objectClass, String field,
			Object values, String itemValue, String itemName)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Method[] methods = objectClass.getMethods();
		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem(null, "Choose"));
		List<Object> listData = this.getListByFields(objectClass,
				new String[] { field }, new Object[] { values });
		String iValue = "get" + itemValue;
		String iName = "get" + itemName;
		if (listData != null && listData.size() > 0) {
			for (Object data : listData) {
				Object resultId = null;
				Object resultName = null;
				for (int i = 0; i < methods.length; i++) {
					Method aMethod = methods[i];
					String methodName = aMethod.getName();
					if ((iValue).endsWith(methodName)) {
						resultId = aMethod.invoke(data, new Object[] {});
					} else if ((iName).endsWith(methodName)) {
						resultName = aMethod.invoke(data, new Object[] {});
					}
				}
				if (resultId != null && resultName != null) {
					Field[] fieldOfObj = objectClass.getDeclaredFields();
					for (int k = 0; k < fieldOfObj.length; k++) {
						fieldOfObj[k].setAccessible(true);
						if (itemValue.equals(fieldOfObj[k].getName())
								&& isPrimitive(fieldOfObj[k].getType()
										.toString())) {
							list.add(new SelectItem(Integer.parseInt(resultId
									.toString()), resultName.toString()));
						} else {
							list.add(new SelectItem(resultId.toString(),
									resultName.toString()));
						}
					}
				}
			}
		}
		return list;
	}*/

	/**
	 * Phuong thuc Save voi moi doi tuong. Truyen mot doi tuong BO (Mapping voi
	 * csdl) can save vao de Insert vao csdl
	 *
	 * @param object
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	/*public boolean save(Object object) throws LiMsException {
		try {
			return true;
		} catch (HibernateException he) {
			// TODO: handle exception
			he.printStackTrace();
			throw new LiMsException("unknown.database.exception",
					"Internall Error in when processing database..", he);
		}
	}*/

	/**
	 * Save khi khong muon check duplicate o name
	 *
	 * @param object
	 * @return
	 * @throws LiMsException
	 */
	/*public boolean saveWithoutCheckingDuplicateName(Object object)
			throws LiMsException {
		try {
			getSessionFactory().getCurrentSession().save(object);
			return true;
		} catch (HibernateException he) {
			// TODO: handle exception
			he.printStackTrace();
			throw new LiMsException("unknown.database.exception",
					"Internall Error in when processing database..", he);
		}
	}*/

	/**
	 * Phuong thuc delete voi moi doi tuong. Truyen mot doi tuong BO can xoa vao
	 * delete trong csdl
	 *
	 * @param object
	 * @return
	 */
	public boolean delete(Object object) {
		try {

			log.info("Hey, dang delete object: " + object.getClass());

			getSessionFactory().getCurrentSession().delete(object);
			return true;
		} catch (HibernateException he) {
			// TODO: handle exception
			he.printStackTrace();
			return false;
		}
	}

	/**
	 * Phuong thuc update cho moi doi tuong BO
	 *
	 * @param object
	 * @return
	 */
	/*public boolean update(Object object) throws LiMsException {
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(object);
			return true;
		} catch (HibernateException he) {
			// TODO: handle exception
			he.printStackTrace();
			throw new LiMsException();
		}
	}*/

	/**
	 * Phuong thuc getList theo tieu chi cho moi doi tuong. Cach su dung:
	 * objClass la Class cua BO (Doi tuong mapping voi csdl) .Fields: La ten cac
	 * thuoc tinh can tim kiem cua doi tuong trong csdl .Values: La cac gia tri
	 * tuong ung voi cac thuoc tinh cua doi tuong can tim.
	 *
	 * Vi Du 1: List<User> listUser = getListByFields(User.class, new
	 * String[]{"name","pass"}, new String[]{"admin", "itfsoft2009"});.
	 *
	 * De tim ra cac doi tuong User theo Name = admin, Pass = itfsoft2009 va tra
	 * ve 1 list cac doi tuong User.
	 *
	 * Vi Du 2: List<User> listUser = getListByFields(User.class, null, null);
	 *
	 * De lay ra tat ca cac ban ghi cua bang tuong ung voi User.
	 *
	 * Chu y: List tra ve la list cua BO (mapping voi csdl).
	 *
	 */
	public List getListByFields(Class objclass, String[] fields, String[] values) {
		Criteria criteria = null;
		try {
			criteria = getSessionFactory().getCurrentSession().createCriteria(
					objclass);
			if (fields != null && values != null) {
				for (int i = 0; i < fields.length; i++) {
					criteria.add(Restrictions.eq(fields[i], values[i]));
				}
			}
			return criteria.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List getListByFields(Class objclass, String[] fields, Object[] values) {
		Criteria criteria = null;
		try {
			criteria = getSessionFactory().getCurrentSession().createCriteria(
					objclass);
			if (fields != null && values != null) {
				for (int i = 0; i < fields.length; i++) {
					criteria.add(Restrictions.eq(fields[i], values[i]));
				}
			}
			return criteria.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Phuong thuc searchListByObject de Tim kiem theo cac tieu chi cua Object.
	 *
	 * Vi Du: Object User muon tim kiem theo userName, Password. Ta chi can se 2
	 * thuoc tinh UserName, passWord vao trong doi tuong User. Va goi phuong
	 * thuc searchListByObject(User).
	 *
	 * Cac truong String se duoc tim kiem theo kieu gan dung (LIKE). Con cac
	 * truong khac String se tim kiem theo kieu chinh xac (=).
	 *
	 *
	 * Phuong thuc chi tim kiem tat ca cac thuoc tinh cua doi tuong truyen vao
	 * co gia tri khac NULL.
	 *
	 * Neu Doi tuong truyen vao co cac thuoc tinh NULL thi List se tra ve tat ca
	 * ban ghi cua bang thuoc doi tuong day.
	 *
	 * Chu y: Truoc khi dung ham phai chac chan la Object != null.
	 *
	 */
	public List searchListByObject(Object object) {
		Criteria criteria = null;
		try {
			criteria = getSessionFactory().getCurrentSession().createCriteria(
					object.getClass());
			Field[] fieldOfObj = object.getClass().getDeclaredFields();
			for (int i = 0; i < fieldOfObj.length; i++) {
				fieldOfObj[i].setAccessible(true);
				if (fieldOfObj[i].get(object) != null
						&& !fieldOfObj[i].getType().isPrimitive()) {
					if (isInteger(fieldOfObj[i].get(object).toString()) == true) {
						criteria.add(Restrictions.eq(fieldOfObj[i].getName(),
								"%" + fieldOfObj[i].get(object) + "%"));
					} else {
						criteria.add(Restrictions.like(fieldOfObj[i].getName(),
								fieldOfObj[i].get(object)));
					}
				}
			}
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List sortByFirstLetter(Class objclass, String[] fields, String letter) {
		Criteria criteria = null;
		Disjunction or = Restrictions.disjunction();
		try {
			criteria = getSessionFactory().getCurrentSession().createCriteria(
					objclass);
			if (fields != null && letter != null) {
				for (int i = 0; i < letter.length(); i++) {
					for (int j = 0; j < fields.length; j++) {

						or.add(Restrictions.like(fields[j],
								String.valueOf(letter.charAt(i)) + "%"));
					}
				}
			}
			criteria.add(or);
			return criteria.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List sortByFirstLetter(Class objclass, String[] fields,
			String letter, boolean active) {
		Criteria criteria = null;
		Field[] fieldObj = objclass.getDeclaredFields();
		Integer fieldActive = null;
		Disjunction or = Restrictions.disjunction();
		try {
			criteria = getSessionFactory().getCurrentSession().createCriteria(
					objclass);
			if (fields != null && letter != null) {
				for (int i = 0; i < letter.length(); i++) {
					for (int j = 0; j < fields.length; j++) {

						or.add(Restrictions.like(fields[j],
								String.valueOf(letter.charAt(i)) + "%"));
					}
				}
			}
			criteria.add(or);
			for (int i = 0; i < fieldObj.length; i++) {
				if (fieldObj[i].getName().equals("active")) {
					if (active == false) {
						fieldActive = 1;
					}
				}
			}
			if (fieldActive != null) {
				criteria.add(Restrictions.eq("active", fieldActive));
			}
			return criteria.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	/**
	 * Lay list theo page
	 * @param clazz
	 * @param start
	 * @param pageSize
	 * @param inActive Neu la true, tra ve danh sach tat ca ban ghi. Neu la false
	 * chi tra ve danh sach cac ban ghi co truong active = 1
	 * @return
	 */
	public List getListByPage(Class clazz, int start, int pageSize,
			boolean inActive) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		if (!inActive) {
			criteria.add(Restrictions.eq("active", 1));
		}
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(start);
		return criteria.list();
	}

	/**
	 * Dem so ban ghi ung voi dieu kien include
	 *
	 * @param inActive
	 *            Neu true thi dem toan bo ban ghi trong bang, neu false thi chi
	 *            dem nhung ban ghi co active = 1
	 * @return
	 */
	public int countRows(Class clazz, boolean inActive) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		if (!inActive) {
			criteria.add(Restrictions.eq("active", 1));
		}
		Number c = (Number) criteria.setProjection(Projections.rowCount())
				.uniqueResult();
		return c.intValue();
	}

	public boolean checkDuplicate(Class objclass, String[] fields,
			Object[] values) {
		boolean flag = false;
		Criteria criteria = null;
		try {
			criteria = getSessionFactory().getCurrentSession().createCriteria(
					objclass);
			if (fields != null && values != null) {
				for (int i = 0; i < fields.length; i++) {
					criteria.add(Restrictions.eq(fields[i], values[i]));
				}
			}
			if (criteria != null && criteria.list().size() > 0) {
				flag = true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Lay ra 1 doi tuong co kieu <code>clazz</code> theo <code>id</code>
	 *
	 * @param clazz
	 * @param id
	 * @return Tra ve <code>null</code> neu khong tim thay rown nao co ID =
	 *         <code>id</code>
	 */
	public Object getObject(Class clazz, Integer id) {
		return getSessionFactory().getCurrentSession().get(clazz, id);
	}

	public Object getObject(Class clazz, String id) {
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(clazz);
		criteria.add(Restrictions.eq("id", id));
		if (criteria != null && criteria.list() != null
				&& criteria.list().size() > 0) {
			return criteria.list().get(0);
		}
		return null;
	}

	public boolean isPrimitive(String string) {
		if (java.lang.Character.TYPE.equals(string)
				|| java.lang.Byte.TYPE.equals(string)
				|| java.lang.Short.TYPE.equals(string)
				|| java.lang.Integer.TYPE.equals(string)
				|| java.lang.Long.TYPE.equals(string)
				|| java.lang.Float.TYPE.equals(string)
				|| java.lang.Double.TYPE.equals(string)) {
			return true;
		}
		return false;
	}

	/**
	 * Map phuc vu cho viec hien thi du lieu trong referrence data len check
	 * list cua view. Key cua map dung de hien thi label cua check list, Value
	 * cua map dung de luu value cua check list. Khi chon 1 row thi se luu gia
	 * tri value cua map.
	 *
	 * @param clazz
	 * @param name
	 * @return Tra ve map ref data theo name. Neu khong co ten nao nhu vay thi
	 *         tra ve empty map. Map tra ve co key la VALUE trong bang ref data,
	 *         con value la ID cua VALUE do trong bang ref data
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map<String, Integer> getMapByName(Class clazz, String name) {
		// Map<String, Integer> map = new HashMap<String, Integer>();
		// Condition condition = new Condition();
		// condition.addCondition("name", name, Condition.EQUAL);
		// List list = getList(clazz, condition, null);
		//
		// for (Object obj : list) {
		// RefDataInterface refData = (RefDataInterface) obj;
		// if (refData.isName(name)) {
		// map.put(refData.getValue(), refData.getId());
		// }
		// }
		return null;

	}// end getMapByName method

	// ---------------------------PRIVATE METHOD--------------------------------
	private Criteria getCriteria() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		return sessionFactory.getCurrentSession().createCriteria(clazz);
	}

	/**
	 * Set cac cot can select vao criteria
	 *
	 * @param clazz
	 * @param criteria
	 * @param columnNames
	 */
	private void setSpecifyCols(Criteria criteria, String... columnNames) {
		ProjectionList projectionList = Projections.projectionList();
		for (String column : columnNames) {
			projectionList.add(Projections.property(column), column);
		}
		criteria.setProjection(projectionList).setResultTransformer(
				Transformers.aliasToBean(clazz));
	}

	// -------------------------------GETTER SETTER----------------------------

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}

	/**
	 * @return the clazz
	 */
	public Class<T> getClazz() {
		return clazz;
	}

	/**
	 * @param clazz
	 *            the clazz to set
	 */
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

}

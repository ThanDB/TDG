package dev.rapid.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.rapid.dao.BaseDao;
import dev.rapid.util.HibernateUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class<T> clazz;
	private Session session;
    private Transaction tx;

	public BaseDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
		HibernateUtil.buildIfNeeded();
	}

	@Override
	public boolean saveOrUpdate(T object) {
		boolean result = true;
		try {
            startOperation();
            session.saveOrUpdate(object);
            tx.commit();
        } catch (HibernateException e) {
        	result = false;
            handleException(e);
        } finally {
            HibernateUtil.close(session);
            HibernateUtil.closeFactory();
        }
		return result;
	}

	@Override
	public boolean saveOrUpdate(Collection<T> objects) {
		boolean result = true;
		int i = 0;
		try {
			for (T t : objects) {
				session.saveOrUpdate(t);
			    if ( i % 20 == 0 ) { //20, same as the JDBC batch size
			        //flush a batch of inserts and release memory:
			        session.flush();
			        session.clear();
			    }
			    i++;
			}

			tx.commit();
        } catch (HibernateException e) {
        	result = false;
            handleException(e);
        } finally {
            HibernateUtil.close(session);
            HibernateUtil.closeFactory();
        }
		return result;
	}

	@Override
	public boolean delete(Integer id) {
		try {
            startOperation();
            T t = find(id);

            session.delete(t);

            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close(session);
        }
		return false;
	}

	@Override
	public boolean delete(Collection<Integer> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(Integer id) {
		T obj = null;
        try {
            startOperation();
            obj = (T) session.load(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close(session);
        }
        return obj;
	}

	@Override
	public List<T> findAll() {
		List<T> objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateUtil.close(session);
        }
        return objects;
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

	protected void handleException(HibernateException e) throws HibernateException {
        HibernateUtil.rollback(tx);
        throw e;
    }

    protected void startOperation() throws HibernateException {
        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
    }
}

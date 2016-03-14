package dev.rapid.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {
	// file name constants
	public static final String MESSAGE_FILE_NAME = "messages.properties";

	// key constants
	public static final String KEY_FORM_CUSTOMER_NEW_TITLE = "form.customer.new.title";
	public static final String KEY_FORM_CUSTOMER_EDIT_TITLE = "form.customer.edit.title";

	// fxml file path
	public static final String FXML_FILE_PATH_CUSTOMER_EDIT = "/fxml/CustomerEdit.fxml";
	public static final String FXML_FILE_PATH_CUSTOMER_LIST = "/fxml/CustomerList.fxml";

	// Hop dong
	public static final String CHI_TIET_HOPDONG_FILE_PATH = "/fxml/chi_tiet_hop_dong.fxml";

	// Bao caco
	public static final String CHI_TIET_BAOCAO_FILE_PATH = "/fxml/chi_tiet_bao_cao.fxml";

	public static final int INSERT = 1;
	public static final int UPDATE = 2;

	public static final String STATUS_TEXT = "Trạng thái";
	public static final String CREATE_NEW_TEXT = "Tạo mới";
	public static final String UPDATE_TEXT = "Cập nhật";
	public static final String MODIFY_TEXT = "Sửa";
	public static final String DETAIL_TEXT = "Chi tiết";

	public static final String NEW_HOPDONG_TEXT = "Tạo mới hợp đồng";
	public static final String DETAIL_HOPDONG_TEXT = "Chi tiết hợp đồng";
	public static final String UPDATE_HOPDONG_TEXT = "Cập nhật hợp đồng";

	public static final String NEW_BAOCAO_TEXT = "Tạo mới báo cáo";
	public static final String DETAIL_BAOCAO_TEXT = "Chi tiết báo cáo";
	public static final String UPDATE_BAOCAO_TEXT = "Cập nhật báo cáo";

	public static Set<String> HOPDONG_STT_LIST = new HashSet<>(Arrays.asList(new String[] {"Chưa ký", "Đang thực hiện", "Đã hủy", "Tạm dừng", "Hoàn thiện"}));
	public static Set<String> THANHTOAN_STT_LIST = new HashSet<>(Arrays.asList(new String[] {"Chưa thanh toán hết", "Đã thanh toán hết"}));
}

package mockup.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private Label error_msg;

	@FXML
	private TextField ten_dang_nhap;

	@FXML
	private PasswordField mat_khau;

	private Mockup app;

	@FXML
	private void login() {
		String userName = ten_dang_nhap.getText();
		String password = mat_khau.getText();

		try {
			if("manager".equalsIgnoreCase(userName) && "manager".equalsIgnoreCase(password)) {
				app.initMainLayout();
			} else {
				error_msg.setText("Tên đăng nhập hoặc mật khẩu của bạn không đúng. Xin vui lòng nhập lại!");
			}
		} catch (Exception e) {
			error_msg.setText("Đã có lỗi xảy ra trên hệ thống. Xin vui lòng nhập lại!");
		}
	}

	public void setApp(Mockup obj) {
		this.app = obj;
	}

}

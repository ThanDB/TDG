/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.rapid.controller;

import java.net.URL;
import java.util.ResourceBundle;

import dev.rapid.dao.impl.KhachHangDaoImpl;
import dev.rapid.domain.KhachHang;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rapid
 */
public class CustomerEditController implements Initializable {

	@FXML
	private Label khTitle;
	@FXML
	private TextField tenKHField;
	@FXML
	private TextField mstField;
	@FXML
	private TextField diachiField;
	@FXML
	private TextField sdtField;
	@FXML
	private TextField nddField;
	@FXML
	private TextField faxField;

	private int actionType;

	public int getActionType() {
		return actionType;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}

	// Reference to the main application.
	private App app;

	private String title;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	@FXML
	private void initialize() {
		khTitle.setText(getTitle());
	}

	@FXML
	private void handleCreateCustomer(ActionEvent event) {
		KhachHangDaoImpl cusDao = new KhachHangDaoImpl();

		KhachHang kh = new KhachHang();
		kh.setTenKh(tenKHField.getText());
		kh.setMaSoThue(mstField.getText());
		kh.setDiaChi(diachiField.getText());
		kh.setSdt(sdtField.getText());
		kh.setDaiDien(nddField.getText());
		kh.setFax(faxField.getText());

		cusDao.saveOrUpdate(kh);
	}

	@FXML
	private void handleCancel(ActionEvent event) {
	}

	@FXML
	private void handleClear(ActionEvent event) {
		tenKHField.setText("");
		mstField.setText("");
		diachiField.setText("");
		sdtField.setText("");
		nddField.setText("");
		faxField.setText("");
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(App app) {
		this.app = app;

		// Add observable list data to the table
		// personTable.setItems(mainApp.getPersonData());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

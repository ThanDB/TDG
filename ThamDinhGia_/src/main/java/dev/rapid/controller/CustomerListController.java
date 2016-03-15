/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.rapid.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dev.rapid.dao.impl.KhachHangDaoImpl;
import dev.rapid.domain.KhachHang;
import dev.rapid.model.KhachHangDTO;
import dev.rapid.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rapid
 */
public class CustomerListController{
	@FXML
	private TableView<KhachHangDTO> customerListTable;

	/**
	 * The data as an observable list of Persons.
	 */
	private ObservableList<KhachHangDTO> customerListData = FXCollections.observableArrayList();

	private Label khTitle;
	private TextField tenKHField;
	private TextField mstField;
	private TextField diachiField;
	private TextField sdtField;
	private TextField nddField;
	private TextField faxField;

	private int actionType;
	@FXML
	private TableColumn<KhachHangDTO, String> tenKhachHangColumn;
	@FXML
	private TableColumn<KhachHangDTO, String> diaChiColumn;
	@FXML
	private TableColumn<KhachHangDTO, String> dienThoaiColumn;
	@FXML
	private TableColumn<KhachHangDTO, String> faxColumn;
	@FXML
	private TableColumn<KhachHangDTO, String> daiDienColumn;
	@FXML
	private TableColumn<KhachHangDTO, String> maSoThueColumn;

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
	/*@Override
	public void initialize(URL url, ResourceBundle rb) {
	}*/

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		tenKhachHangColumn.setCellValueFactory(cellData -> cellData.getValue().tenKhachHangProperty());
		diaChiColumn.setCellValueFactory(cellData -> cellData.getValue().diaChiProperty());
		dienThoaiColumn.setCellValueFactory(cellData -> cellData.getValue().dienThoaiProperty());
		faxColumn.setCellValueFactory(cellData -> cellData.getValue().faxProperty());
		daiDienColumn.setCellValueFactory(cellData -> cellData.getValue().daiDienProperty());
		maSoThueColumn.setCellValueFactory(cellData -> cellData.getValue().maSoThueProperty());
	}

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

		KhachHangDaoImpl khDao = new KhachHangDaoImpl();
		List<KhachHang> khs = khDao.findAll();
		domainToDTO(khs);
		// Add observable list data to the table
		customerListTable.setItems(customerListData);
	}

	public void domainToDTO(List<KhachHang> khs) {
		for (KhachHang khachHang : khs) {
			customerListData.add(new KhachHangDTO(khachHang.getTenKh(), khachHang.getDiaChi(), khachHang.getSdt(), khachHang.getFax(), khachHang.getDaiDien(), khachHang.getMaSoThue()));
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

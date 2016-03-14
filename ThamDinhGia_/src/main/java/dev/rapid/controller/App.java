package dev.rapid.controller;

import java.io.IOException;

import dev.rapid.util.Constants;
import dev.rapid.util.MessageHelper;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

	private Stage primaryStage;
	private static BorderPane mainLayout;

	public static void main(String[] args) {
		//System.out.println(Calendar.getInstance().getTime());
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Phần mềm thẩm định giá");

		initMainLayout();
	}

	/**
	 * Initializes the main layout.
	 */
	public void initMainLayout() {
		try {
			// Load main layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("/fxml/MainLayout.fxml"));
			mainLayout = (BorderPane) loader.load();

			// Show the scene containing the main layout.
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the customer edit inside the root layout.
	 */
	@FXML
	public void showCustomerEdit() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource(Constants.FXML_FILE_PATH_CUSTOMER_EDIT));
			AnchorPane customerEdit = (AnchorPane) loader.load();

			// Set customer edit into the center of main layout.
			mainLayout.setCenter(customerEdit);

			// Give the controller access to the main app.
			CustomerEditController controller = loader.getController();
			controller.setMainApp(this);
			controller.setTitle(MessageHelper.getInstance().getMessage(Constants.KEY_FORM_CUSTOMER_NEW_TITLE));
			controller.setActionType(Constants.INSERT);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the customer list inside the root layout.
	 */
	@FXML
	public void showCustomerList() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource(Constants.FXML_FILE_PATH_CUSTOMER_LIST));
			AnchorPane customerList = (AnchorPane) loader.load();

			// Set customer edit into the center of main layout.
			mainLayout.setCenter(customerList);

			// Give the controller access to the main app.
			CustomerListController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

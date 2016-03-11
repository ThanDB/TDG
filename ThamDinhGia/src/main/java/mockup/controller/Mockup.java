package mockup.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Mockup extends Application {

	public Stage primaryStage;
	public BorderPane mainLayout;

	private static AnchorPane loginBox;

	public static void main(String[] args) {
		//System.out.println(Calendar.getInstance().getTime());
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Phần mềm thẩm định giá");

		//initMainLayout();

		initLogin();
	}

	private void initLogin() {
		try {
			// Load main layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource("/fxml/dang_nhap.fxml"));
			loginBox = (AnchorPane) loader.load();

			// Show the scene containing the main layout.
			Scene scene = new Scene(loginBox);
			primaryStage.setScene(scene);
			primaryStage.show();

			LoginController controller = loader.getController();
			controller.setApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the main layout.
	 */
	public void initMainLayout() {
		try {
			// Load main layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource("/fxml/main_layout.fxml"));
			mainLayout = (BorderPane) loader.load();

			MainLayoutController controller = loader.getController();
			controller.setApp(this);


			FXMLLoader loaderContent = new FXMLLoader();
			loaderContent.setLocation(Mockup.class.getResource("/fxml/hop_dong_list.fxml"));
			AnchorPane content = (AnchorPane) loaderContent.load();

			HopDongListController hopDongController = loaderContent.getController();
			hopDongController.setApp(this);
			hopDongController.search();

			mainLayout.setRight(content);

			// Show the scene containing the main layout.
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			//primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the customer edit inside the root layout.
	 */
//	@FXML
//	public void showCustomerEdit() {
//		try {
//			// Load person overview.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Mockup.class.getResource(Constants.FXML_FILE_PATH_CUSTOMER_EDIT));
//			AnchorPane customerEdit = (AnchorPane) loader.load();
//
//			// Set customer edit into the center of main layout.
//			mainLayout.setCenter(customerEdit);
//
//			// Give the controller access to the main app.
//			CustomerEditController controller = loader.getController();
//			controller.setMainApp(this);
//			controller.setTitle(MessageHelper.getInstance().getMessage(Constants.KEY_FORM_CUSTOMER_NEW_TITLE));
//			controller.setActionType(Constants.INSERT);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Shows the customer list inside the root layout.
	 */
//	@FXML
//	public void showCustomerList() {
//		try {
//			// Load person overview.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Mockup.class.getResource(Constants.FXML_FILE_PATH_CUSTOMER_LIST));
//			AnchorPane customerList = (AnchorPane) loader.load();
//
//			// Set customer edit into the center of main layout.
//			mainLayout.setCenter(customerList);
//
//			// Give the controller access to the main app.
//			CustomerListController controller = loader.getController();
//			controller.setMainApp(this);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}

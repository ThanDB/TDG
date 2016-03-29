package dev.rapid.controller;

import java.io.IOException;

import dev.rapid.util.Constants;
import dev.rapid.util.FXMLConstants;
import dev.rapid.util.MessageHelper;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mockup.controller.HopDongListController;
import mockup.controller.LoginController;
import mockup.controller.MainLayoutController;
import mockup.controller.Mockup;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

	/*private Stage primaryStage;
	private static BorderPane mainLayout;

	private static AnchorPane loginBox;

	public static void main(String[] args) {
		//System.out.println(Calendar.getInstance().getTime());
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Phần mềm thẩm định giá");

		initMainLayout();

		//initLogin();
	}

	private void initLogin() {
		try {
			// Load main layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource(FXMLConstants.LOGIN));
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

	*//**
	 * Initializes the main layout.
	 *//*
	public void initMainLayout() {
		try {
			// Load main layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mockup.class.getResource(FXMLConstants.MAIN_LAYOUT));
			mainLayout = (BorderPane) loader.load();

//			MainLayoutController controller = loader.getController();
//			controller.setApp(this);
//			controller.setWelcomeLbl("Xin chào: Nguyễn Văn B");

//			FXMLLoader loaderContent = new FXMLLoader();
//			loaderContent.setLocation(Mockup.class.getResource(FXMLConstants.HD_LIST));
//			AnchorPane content = (AnchorPane) loaderContent.load();
//
//			HopDongListController hopDongController = loaderContent.getController();
//			hopDongController.setApp(this);
			//hopDongController.search();

			mainLayout.setCenter(content);

			// Show the scene containing the main layout.
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);

			//primaryStage.setFullScreen(true);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}

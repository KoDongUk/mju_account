package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import popupcontrollers.popup;
import popupcontrollers.accountPopupController;


import database.user_info;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class mainController implements Initializable 
{
	@FXML Label name;
	@FXML Button accountButton;
	private popup accountPopup;
	private user_info ui = null; 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		ui = new user_info();
		System.out.println(ui.getId());
		name.setText(ui.getName());
		
		accountButton.setOnAction(event->account());
	}
	
	public void account() {
		System.out.println("account 버튼 눌림");
		accountPopup = new popup("account");
		accountPopup.setLocation("/view/accountPopup.fxml");
		accountPopup.show();
	}
	
}

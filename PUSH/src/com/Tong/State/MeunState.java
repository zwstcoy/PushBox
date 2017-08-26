package com.Tong.State;

import com.Tong.Resource.Resources;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class MeunState extends Pane{
	
	public int width=1000;
	public int heigh=600;
	InputHandler inputhandler;
	Resources res;
	public boolean isClick=false;
	public MeunState(){
		res=new Resources();
		getChildren().add(res.welcomeBackground);
		Button startButton=new Button(null, new ImageView(res.buttonImage));
		startButton.setLayoutX(width/2-50);
		startButton.setLayoutY(heigh-200);
		getChildren().add(startButton);
		inputhandler=new InputHandler();
		startButton.setOnAction(inputhandler);

	}
	
	class InputHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {

			System.out.println("in click");
			isClick=true;
		}
		
	}

}


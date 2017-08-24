package com.Tong.State;

import com.Tong.Resource.Resources;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class EndGameState extends Pane{
	Resources res=new Resources();
	public int width=1000;
	public int heigh=600;
	public boolean isStartOver =false;
	public EndGameState(){
		Button startOver_button=new Button(null,new ImageView(res.startover));
		startOver_button.setLayoutX(350);
		startOver_button.setLayoutY(400);
		startOver_button.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				isStartOver=true;
			}
			
		});
		
		Button exit_button=new Button(null,new ImageView(res.exit));
		exit_button.setLayoutX(550);
		exit_button.setLayoutY(400);
		exit_button.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		getChildren().addAll(res.endgamebackground,startOver_button,exit_button);
		
	}
}

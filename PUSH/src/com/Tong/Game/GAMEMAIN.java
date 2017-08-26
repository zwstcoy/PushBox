package com.Tong.Game;

import com.Tong.Resource.Resources;
import com.Tong.State.EndGameState;
import com.Tong.State.MeunState;
import com.Tong.State.PlayState;
import com.Tong.State.RuleState;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GAMEMAIN extends Application{
	MeunState gamepane1;
	PlayState statepane;
	RuleState rulepane;
	EndGameState endgamepane;
	Scene scene2,scene1,scene3,sceneRule;
    MediaPlayer mediaPlayer; 
	Resources res=new Resources();

	
	public static void main(String args[]){
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		endgamepane=new EndGameState();
		gamepane1=new MeunState();
		statepane=new PlayState();
		rulepane=new RuleState();

		mediaPlayer = new MediaPlayer(res.media);
		mediaPlayer.setVolume(1);
		mediaPlayer.play();
		
		scene1=new Scene(gamepane1,gamepane1.width,gamepane1.heigh);
		scene2=new Scene(statepane,statepane.width,statepane.heigh);
		scene3=new Scene(endgamepane,endgamepane.width,endgamepane.heigh);
		primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				System.out.println("click");
				if(gamepane1.isClick||endgamepane.isStartOver){
					gamepane1.isClick=false;
					sceneRule=new Scene(rulepane,rulepane.width,rulepane.heigh);

					primaryStage.setScene(sceneRule);
					primaryStage.show();
					try {
				         Thread.sleep(500);
				     } catch (InterruptedException ie)
				     {
				         System.out.println("warning...");
				     }
					
					statepane.init();
					primaryStage.setScene(scene2);
					primaryStage.show();
				}
			
			}});
		primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(statepane.isEndGame){
					primaryStage.setScene(scene3);
					primaryStage.show();
				}
			}
			
		});
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("PUSH");
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		}
}

package com.Tong.State;

import com.Tong.FrameWork.Map;
import com.Tong.FrameWork.Map1;
import com.Tong.FrameWork.Map2;
import com.Tong.FrameWork.Monster;
import com.Tong.Game.Stage;
import com.Tong.Resource.Resources;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;

public class PlayState extends Pane {
	Resources res=new Resources();
	public int width=1000;
	public int heigh=600;
	Stage stage=new Stage();
	Monster monster=new Monster(),monster2=new Monster();
	InputHandler1 inputHandler1;
	Button reStart,exit;
	Map map=new Map1();
	Thread tMonster1,tMonster2;

	public boolean isEndGame=false;
	public boolean isStage2=false;

	public void init(){
		System.out.println("Playstage");
		reStart=new Button(null,new ImageView(res.restart));		
		reStart.setLayoutX(width-120);
		reStart.setLayoutY(0);
		reStart.setOnMouseClicked(e->{
			stage.reset();
		});	
		monster.init();
		monster2.init();
		tMonster1=new Thread(monster);
		tMonster2=new Thread(monster2);
		
		inputHandler1=new InputHandler1();	

		stage.init();
		
		getChildren().addAll(stage.image,stage.rectBox1,
				stage.rectPlayer,stage.winPlace,
				stage.time,stage.life,stage.scoreLabel,stage.wallUp,
				stage.wallDown,stage.wallLeft,stage.wallRight,reStart,monster.monster1);
		getChildren().addAll(map.box1,map.box2,map.box3,map.box4,
							 map.box5,map.box6);
		addEventFilter(KeyEvent.KEY_PRESSED, new InputHandler1());
		
		tMonster1.start();


		new Thread(new Runnable(){ 
			public void run(){ 
				while (true){
					try {
						Platform.runLater(new Runnable() {
						public void run(){
							stage.updateTime();
							isEndGame=(stage.endTime>=60&&stage.score<5)||stage.liftNum==0?true:false;
							if(monster.isTouch( monster.monster1,stage.rectPlayer)||monster2.isTouch(monster2.monster1, stage.rectPlayer)){
								System.out.println("Touch Monster");
								stage.life.setText("Life: "+--stage.liftNum);
								stage.reset();
							}
							if(stage.score==1){
								getChildren().add(monster2.monster1);
								tMonster2.start();
							}
						} });
					Thread.sleep(1000);
				
					} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						e.printStackTrace();
						}
				}}}).start();
		
		
		

			
	}
		
	public class InputHandler1 implements EventHandler<KeyEvent>{
		
		@SuppressWarnings("incomplete-switch")
		public void handle(KeyEvent event) {
			setOnKeyReleased(e->{
				stage.rectPlayer.setFill(new ImagePattern(res.player));
			
			});
			
			System.out.println("on keybord");
			setOnKeyPressed(e->{
				stage.rectPlayer.setFill(new ImagePattern(res.walk1));
				double x=stage.rectPlayer.getLayoutX();
				double y=stage.rectPlayer.getLayoutY();
				double x2=stage.rectBox1.getLayoutX();
				double y2=stage.rectBox1.getLayoutY();
				switch(e.getCode()){
				case DOWN: 
					y=(y+50)>heigh-100?heigh-100:y+50;
					stage.update(x, y);
					if(map.isTouch(stage.rectPlayer)){
						y-=50;
					}
					if(stage.isTouch(stage.rectPlayer, stage.rectBox1)){
						System.out.println("Touch down");
						y2=(y2+50)>stage.heigh-100?stage.heigh-100:y2+50;
						y=y2==y?y-50:y;
						stage.update(x, y,x2, y2);
						if(map.isTouch(stage.rectBox1)){
							y2-=50;
							y=y2==y?y-50:y;
						}
					}
					break;
				case UP:
					y=(y-50)<=50?50:y-50;
				
					stage.update(x, y);
					if(map.isTouch(stage.rectPlayer)){
						y+=50;
					}
					if(stage.isTouch(stage.rectPlayer, stage.rectBox1)){
						System.out.println("Touch up");
						y2=(y2-50)<=50?50:y2-50;
						y=y2==y?y+50:y;
						stage.update(x, y,x2, y2);
						if(map.isTouch(stage.rectBox1)){
							y2+=50;
							y=y2==y?y+50:y;
						}
					}
					break;
				case RIGHT:
					x=(x+50)>=width-100?stage.width-100:x+50;
					
					stage.update(x, y);
					if(map.isTouch(stage.rectPlayer)){
						x-=50;
					}
					if(stage.isTouch(stage.rectPlayer,stage. rectBox1)){
						System.out.println("Touch RIGHT");
						x2=(x2+50)>stage.width-100?stage.width-100:x2+50;
						x=x2==x?x-50:x;
						stage.update(x, y,x2, y2);
						if(map.isTouch(stage.rectBox1)){
							x2-=50;
							x=x2==x?x-50:x;
						}
					}
					break;
				case LEFT:
					x=(x-50)<=50?50:x-50;
					
					stage.update(x, y);
					
					if(map.isTouch(stage.rectPlayer)){
						x+=50;
					}
					if(stage.isTouch(stage.rectPlayer,stage. rectBox1)){
						System.out.println("Touch LEFT");
						x2=(x2-50)<=50?50:x2-50;
						x=x==x2?x+50:x;
						stage.update(x, y,x2, y2);
						if(map.isTouch(stage.rectBox1)){
							x2+=50;
							x=x==x2?x+50:x;
						}
					}
					break;
				} 
				
				stage.update(x, y,x2, y2);
				stage.isWin();
				
				isStage2=stage.score==5?true:false;
				
				if(isStage2){
					getChildren().removeAll(stage.image,stage.rectBox1,
							stage.rectPlayer,stage.winPlace,
							stage.time,stage.life,stage.scoreLabel,stage.wallUp,
							stage.wallDown,stage.wallLeft,stage.wallRight,reStart,monster.monster1,map.box1,map.box2,map.box3,map.box4,
							 map.box5,map.box6,reStart);
					
					map=new Map2();
					stage.init();
					getChildren().addAll(stage.image2,stage.rectBox1,
							stage.rectPlayer,stage.winPlace,
							stage.time,stage.life,stage.scoreLabel,stage.wallUp,
							stage.wallDown,stage.wallLeft,stage.wallRight,reStart,monster.monster1,map.box1,map.box2,map.box3,map.box4,
							 map.box5,map.box6);
					isStage2=false;
				}
				
				
			} );	
	}
	}

}

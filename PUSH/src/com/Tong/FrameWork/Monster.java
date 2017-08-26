package com.Tong.FrameWork;

import java.util.Random;

import com.Tong.Resource.Resources;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Monster implements Runnable{
	public Rectangle monster1,monster2,monster3,monster4;
	RandonLocation location=new RandonLocation();
	Resources res=new Resources();
	public void init() {
		monster1=new Rectangle(50,50);
		monster1.setFill(new ImagePattern(res.m1));
		monster1.setLayoutX(100);
		monster1.setLayoutY(50);
		
		monster2=new Rectangle(50,50);
		monster2.setFill(new ImagePattern(res.m1));
		monster2.setLayoutX(50);
		monster2.setLayoutY(100);
		
		
		monster3=new Rectangle(50,50);
		monster3.setFill(new ImagePattern(res.m1));
		monster3.setLayoutX(300);
		monster3.setLayoutY(50);
		
		monster4=new Rectangle(50,50);
		monster4.setFill(new ImagePattern(res.m1));
		monster4.setLayoutX(100);
		monster4.setLayoutY(400);
	}
	public boolean isTouch(Rectangle r1, Rectangle r2){
		return r1.getBoundsInParent().intersects(r2.getBoundsInParent());
	}
	
	
	public  void run() {
		int x=50;
		int xSpeed=location.monsterSpeed;
		int y=50;
		int ySpeed=location.monsterSpeed;
		Random ran=new Random();
		while(true){
			monster1.setLayoutX(x);
			monster1.setLayoutY(y);
			if(x>=900){
				xSpeed=-location.monsterLocation[ran.nextInt(location.monsterLocation.length)];
			}
			else if(x<=50){
				xSpeed=location.monsterLocation[ran.nextInt(location.monsterLocation.length)];
			}
			if(y>=500){
				ySpeed=-location.monsterLocation[ran.nextInt(location.monsterLocation.length)];
			}
			else if(y<=50){
				ySpeed=location.monsterLocation[ran.nextInt(location.monsterLocation.length)];
			}
			x+=xSpeed;
			y+=ySpeed;
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}

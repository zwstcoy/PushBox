package com.Tong.FrameWork;

import com.Tong.Resource.Resources;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Map2 extends Map {
	Resources res=new Resources();
	public Map2(){
		box1=new Rectangle(50,300);
		box1.setLayoutX(150);
		box1.setLayoutY(250);
		box1.setFill(new ImagePattern(res.Bbox2));

		
		box2=new Rectangle(300,50);
		box2.setFill(new ImagePattern(res.Bbox3));
		box2.setLayoutX(200);
		box2.setLayoutY(350);
		
		
		box3=new Rectangle(50,200);
		box3.setLayoutX(350);
		box3.setLayoutY(50);
		box3.setFill(new ImagePattern(res.Bbox5));
		
		
		box4=new Rectangle(50,200);
		box4.setLayoutX(500);
		box4.setLayoutY(200);
		box4.setFill(new ImagePattern(res.Bbox5));
		
		box5=new Rectangle(200,50);
		box5.setLayoutX(550);
		box5.setLayoutY(200);
		box5.setFill(new ImagePattern(res.Bbox4));
		
		box6=new Rectangle(200,50);
		box6.setLayoutX(750);
		box6.setLayoutY(350);
		box6.setFill(new ImagePattern(res.Bbox3));

	}
	
	public boolean isTouch(Rectangle re1){
		if(isTouchWidth(re1,box2))
			return true;
		if(isTouchWidth(re1,box5))
			return true;
		if(isTouchWidth(re1,box6))
			return true;
		if(isTouchHeigh(re1,box1))
			return true;
		if(isTouchHeigh(re1,box3))
			return true;
		if(isTouchHeigh(re1,box4))
			return true;
		
		return false;
	}

}

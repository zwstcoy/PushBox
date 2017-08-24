package com.Tong.FrameWork;

import com.Tong.Resource.Resources;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Map1 extends Map {
	Resources res=new Resources();
	
	public Map1(){
		
		
		box2=new Rectangle(50,300);
		box2.setLayoutX(450);
		box2.setLayoutY(250);
		box2.setFill(new ImagePattern(res.Bbox2));
	
		
		box3=new Rectangle(300,50);
		box3.setFill(new ImagePattern(res.Bbox3));
		box3.setLayoutX(50);
		box3.setLayoutY(400);
		
		
		
		box4=new Rectangle(200,50);
		box4.setLayoutX(650);
		box4.setLayoutY(350);
		box4.setFill(new ImagePattern(res.Bbox4));
		
		box5=new Rectangle(50,200);
		box5.setLayoutX(300);
		box5.setLayoutY(50);
		box5.setFill(new ImagePattern(res.Bbox5));
		
		box6=new Rectangle(50,300);
		box6.setLayoutX(750);
		box6.setLayoutY(50);
		box6.setFill(new ImagePattern(res.Bbox2));

	}
	
	public boolean isTouch(Rectangle re1){
		if(isTouchWidth(re1,box3))
			return true;
		if(isTouchWidth(re1,box4))
			return true;
		if(isTouchHeigh(re1,box2))
			return true;
		if(isTouchHeigh(re1,box5))
			return true;
		if(isTouchHeigh(re1,box6))
			return true;
		
		return false;
	}
	public boolean isTouchWidth(Rectangle re1,Rectangle re2){
		if(re1.getLayoutY()==re2.getLayoutY()&&(re1.getLayoutX()>=re2.getLayoutX()&&
					re1.getLayoutX()<=re2.getLayoutX()+re2.getWidth()-50)){
					return true;
			}
		return false;
	}
	public boolean isTouchHeigh(Rectangle re1,Rectangle re2){
		if(re1.getLayoutX()==re2.getLayoutX()&&
				(re1.getLayoutY()>=re2.getLayoutY()&&
				re1.getLayoutY()<=re2.getLayoutY()+re2.getHeight()-50)){
			return true;
		}
		return false;
	}
	
}

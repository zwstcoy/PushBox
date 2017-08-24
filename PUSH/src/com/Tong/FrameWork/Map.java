package com.Tong.FrameWork;

import com.Tong.Resource.Resources;
import javafx.scene.shape.Rectangle;

public class Map {
	Resources res=new Resources();
	public Rectangle box1,box2,box3,box4,box5,box6;
	public Map(){
		box1=new Rectangle();
		
		box2=new Rectangle(50,300);
	
		box3=new Rectangle(300,50);

		box4=new Rectangle(200,50);
		
		box5=new Rectangle(50,200);
		
		box6=new Rectangle(50,300);
	}
	
	public boolean isTouch(Rectangle re1){
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

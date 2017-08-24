package com.Tong.Resource;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

public class Resources {
	public Image welcome,stage1,stage2,key,winPlace,player,buttonImage,wall,
	box2,rule,wall2,walk1,walk2,Bbox1,Bbox2,Bbox3,Bbox4,Bbox5,
	restart,startover,exit,endgame,m1,m2;
	public ImageView welcomeBackground,ruleBackground,endgamebackground;
	public Media media;
	public Resources(){
		welcome=new Image("com\\Tong\\Resource\\welcome2.jpg");
		
		rule=new Image("com\\Tong\\Resource\\rule.jpg");
		ruleBackground=new ImageView();
		ruleBackground.setImage(rule );
		
		stage1=new Image("com\\Tong\\Resource\\stage1.jpg");
		stage2=new Image("com\\Tong\\Resource\\stage2.jpg");

		key=new Image("com\\Tong\\Resource\\key.png");
		winPlace=new Image("com\\Tong\\Resource\\winplace.png");
		player=new Image("com\\Tong\\Resource\\spikeMan_stand.png");
		m1=new Image("com\\Tong\\Resource\\e1.png");
		m2=new Image("com\\Tong\\Resource\\e2.png");
		
		welcomeBackground=new ImageView();
		welcomeBackground.setImage(welcome);
		buttonImage=new Image("com\\Tong\\Resource\\button.png");
		restart=new Image("com\\Tong\\Resource\\restart.png");
		wall=new Image("com\\Tong\\Resource\\wall.png");
		box2=new Image("com\\Tong\\Resource\\box2.png");
		wall2=new Image("com\\Tong\\Resource\\wall2.png");
		walk1=new Image("com\\Tong\\Resource\\spikeMan_walk1.png");
		walk2=new Image("com\\Tong\\Resource\\spikeMan_walk2.png");
	    media =new Media(new File("bgmusic.mp3").toURI().toString());
	    
	    Bbox1=new Image("com\\Tong\\Resource\\box1_50x50.png");
	    Bbox2=new Image("com\\Tong\\Resource\\box2_50x300.png");
	    Bbox3=new Image("com\\Tong\\Resource\\box3_300x50.png");
	    Bbox4=new Image("com\\Tong\\Resource\\box3_200x50.png");
	    Bbox5=new Image("com\\Tong\\Resource\\box2_50x200.png");

	    startover=new Image("com\\Tong\\Resource\\startover.png");
	    exit=new Image("com\\Tong\\Resource\\exit.png");
	    endgame=new Image("com\\Tong\\Resource\\GAMEOVER.jpg");
	    endgamebackground=new ImageView(endgame);

	}
}

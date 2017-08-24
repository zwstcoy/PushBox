package com.Tong.Game;
import java.util.Random;
import com.Tong.FrameWork.RandonLocation;
import com.Tong.Resource.Resources;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public  class Stage implements Runnable{
	public ImageView image,image2,imageRule;
	public Label scoreLabel;
	public Label life,time;
	public int liftNum=3;
	public long beginTime,endTime=0;
	public int score;	RandonLocation location=new RandonLocation(); 
	public int width=1000,heigh=600,
				playerX=50,playerY=heigh-100,
				keyX=location.kx,
				keyY=location.ky,
				winPlaceX=location.wx,
				winPlaceY=location.wy;
	Resources res=new Resources();
	public Rectangle rectPlayer,rectBox1,rectBox2,rectBox3,rectBox4,winPlace,
	wallUp,wallDown,wallLeft,wallRight;
	public  void init(){
		score=0;
		endTime=0;
		beginTime=System.currentTimeMillis()/1000;
		time=new Label("Time: "+endTime);
		time.setFont(new Font("Times New Roman",25));
		time.setLayoutX(50);
		time.setLayoutY(75);
		
		life=new Label("Life: "+liftNum);
		life.setFont(new Font("Times New Roman",25));
		life.setLayoutX(50);
		life.setLayoutY(100);
		
		scoreLabel=new Label("Score: "+score);
		scoreLabel.setFont(new Font("Times New Roman",25));
		scoreLabel.setLayoutX(50);
		scoreLabel.setLayoutY(50);
		
		
		image=new ImageView();
		image.setImage(res.stage1);
		
		image2=new ImageView();
		image2.setImage(res.stage2);
		imageRule=new ImageView();
		imageRule.setImage(res.rule);
		
		rectPlayer=new Rectangle(50,50);
		rectPlayer.setFill(new ImagePattern(res.player));
		rectPlayer.setLayoutX(playerX);
		rectPlayer.setLayoutY(playerY);
		
		
		winPlace=new Rectangle(50,50);
		winPlace.setFill(new ImagePattern(res.winPlace));
		winPlace.setLayoutX(winPlaceX);
		winPlace.setLayoutY(winPlaceY);
		System.out.println("Stage1");
		
		rectBox1=new Rectangle(50,50);
		rectBox1.setFill(new ImagePattern(res.key));
		rectBox1.setLayoutX(keyX);
		rectBox1.setLayoutY(keyY);
		
		wallUp=new Rectangle(width,50);
		wallUp.setLayoutX(0);
		wallUp.setLayoutY(heigh-50);
		wallUp.setFill(new ImagePattern(res.wall));
		wallDown=new Rectangle(width,50);
		wallDown.setLayoutX(0);
		wallDown.setLayoutY(0);
		wallDown.setFill(new ImagePattern(res.wall));
		wallLeft=new Rectangle(50,heigh);
		wallLeft.setLayoutX(0);
		wallLeft.setLayoutY(0);
		wallLeft.setFill(new ImagePattern(res.wall2));
		wallRight=new Rectangle(50,heigh);
		wallRight.setLayoutX(width-50);
		wallRight.setLayoutY(0);
		wallRight.setFill(new ImagePattern(res.wall2));	

	}

	
	public void update(double x,double y){
		
		rectPlayer.setLayoutX(x);
		rectPlayer.setLayoutY(y);
	}
	public void update(double x,double y,double x2,double y2){
		rectPlayer.setLayoutX(x);
		rectPlayer.setLayoutY(y);
		rectBox1.setLayoutX(x2);
		rectBox1.setLayoutY(y2);
		
	}
	
	public boolean isTouch(Rectangle re1,Rectangle re2){
		
		if(re1.getLayoutX()==re2.getLayoutX()&&re1.getLayoutY()==re2.getLayoutY()){
			return true;
		}
		return false;
	}
	public void isWin(){
		if(rectBox1.getLayoutX()==winPlace.getLayoutX()&&rectBox1.getLayoutY()==winPlace.getLayoutY()){
			score++;
			 try {
		            Thread.sleep(500);
		        } catch (InterruptedException ie)
		        {
		            System.out.println("warning...");
		        }
			reset();
		
		}		
		
	}
	public void reset(){
		Random ran=new Random();
		rectBox1.setLayoutX(location.key_locationX[ran.nextInt(location.key_locationX.length)]);
		rectBox1.setLayoutY(location.key_locationY[ran.nextInt(location.key_locationY.length)]);
		winPlace.setLayoutX(location.winPlace_locationX[ran.nextInt(location.winPlace_locationX.length)]);
		winPlace.setLayoutY(location.winPlace_locationY[ran.nextInt(location.winPlace_locationY.length)]);
		rectPlayer.setLayoutX(playerX);
		rectPlayer.setLayoutY(playerY);
		scoreLabel.setText("Score: "+score);
	}


	@Override
	public void run(){		
		
			try {
				for(endTime=0;endTime<61;endTime++){
					time.setText("Time: "+endTime);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
}

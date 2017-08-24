package com.Tong.FrameWork;

import java.util.Random;

public class RandonLocation {
	public int 
	 key_locationX[]={100,150,200,250}
	,key_locationY[]={100,150,200}
	,winPlace_locationX[]={650,700,800,850,900}
	,winPlace_locationY[]={50,100,150,250,300,400},
	kx,ky,wx,wy,monsterSpeed;
	int[] monsterLocation={20,30,40,50,60};
	public RandonLocation(){
		Random ran=new Random();
		monsterSpeed=monsterLocation[ran.nextInt(monsterLocation.length)];
		kx=key_locationX[ran.nextInt(key_locationX.length)];
		ky=key_locationY[ran.nextInt(key_locationY.length)];
		wx=winPlace_locationX[ran.nextInt(winPlace_locationX.length)];
		wy=winPlace_locationY[ran.nextInt(winPlace_locationY.length)];
	}
}

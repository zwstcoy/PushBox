package com.Tong.State;

import com.Tong.Resource.Resources;
import javafx.scene.layout.Pane;

public class RuleState extends Pane {
	public int width=1000;
	public int heigh=600;
	Resources res;

	public RuleState(){
		res=new Resources();
		System.out.println("Rulestage");

		getChildren().add(res.ruleBackground);
	
	}
}

package com.space.main;

import com.space.global.AppFuncs;
import com.space.global.AppUI;

public class TravelMain {
	
	public static void main(String[] args) {	
	
		
		
		AppController controller = new AppController();
		
		while(true) {
			AppUI.startScreen(); 
			int inputNumber = AppFuncs.inputInteger();
			controller.chooseSystem(inputNumber);
		}
	}

}

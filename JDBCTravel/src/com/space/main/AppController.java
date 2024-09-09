package com.space.main;

import com.space.global.*;

public class AppController {
	
	public void chooseSystem(int inputNum) {		
		switch(inputNum) {  	
	    	//현재 열차의 운행정보
	    	case GlobalParams.infoNum: 
	    		System.out.println("열차정보 모드로 돌입합니다.");
	    		//tCancel.start();
	    		break;
	    		
	    	//예매되어있는 좌석정보확인 	
	    	case GlobalParams.situationNum:     
	    		System.out.println("예매되어있는 좌석정보확인모드로 돌입합니다."); 
	    		//tCancel.start();
	    		break;
	    		
	    	//예매한 좌석확인 및 좌석예매 	
	    	case GlobalParams.chkNRsvNum:     
	    		System.out.println("예매한 좌석확인 및 좌석예매모드로 돌입합니다."); 
	    		//tCancel.start();
	    		break;
	    		
	    	//예매좌석 취소
	    	case GlobalParams.cancelNum:
	    		System.out.println("예약 취소 모드로 돌입합니다.");
	    		//tCancel.start();
	    		break;
	    		
	    	//고객제안 	
	    	case GlobalParams.suggestNum:
	    		System.out.println("고객 제안 모드로 돌입합니다.");
	    		//tSuggest.start();
	    		break;
	    	
	    	//프로그램 종료
	    	case GlobalParams.terminateNum:
	    		AppFuncs.shutdown();
	    		break;
	    		
	    	default:
	    		AppUI.DefaultMessages();
	    		break;
		}
	}

}

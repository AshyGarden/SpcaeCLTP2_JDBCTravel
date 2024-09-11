package com.space.main;

import com.space.global.*;
import com.space.service.*;
import com.space.service.search.TravelSearchService;

public class AppController {

	TravelInsertService travelInsertService = new TravelInsertService();;
	TravelSearchService travelSearchService = new TravelSearchService();
	TravelUpdateService	travelUpdateService = new TravelUpdateService();
	TravelDeleteService	travelDeleteService = new TravelDeleteService();

	public void chooseSystem(int inputNum) {		
		switch(inputNum) {  	
	    	//여행 및 패키지 추가 - 성진
	    	case GlobalParams.travelInsertNo:
	    		System.out.println("여행 및 패키지 추가 모드로 돌입합니다.");
	    		travelInsertService.start();
	    		break;
	    		
	    	//여행 및 패키지 조회 - 용준
	    	case GlobalParams.travelSearchNo:
	    		System.out.println("여행 및 패키지 조회 모드로 돌입합니다.");
	    		travelSearchService.start();
	    		break;
	    		
	    	//여행 및 패키지 수정 - 재연
	    	case GlobalParams.travelUpdateNo:
	    		System.out.println("여행 및 패키지 수정 모드로 돌입합니다.");
	    		travelUpdateService.start();
	    		break;
	    		
	    	//여행 및 패키지 취소 - 영훈
	    	case GlobalParams.travelDeleteNo:
	    		System.out.println("여행 및 패키지 취소 모드로 돌입합니다.");
	    		travelDeleteService.start();
	    		break;
	    		
	    	//여행 및 패키지 기록 (예정)
	    	case GlobalParams.travelHistoryNo:
	    		System.out.println("여행 및 패키지 기록 모드로 돌입합니다.");
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

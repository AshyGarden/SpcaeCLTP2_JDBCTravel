package com.space.global;

public interface GlobalParams {

	//시작화면 출력(Main)
	int travelInsertNo = 1; 		//여행 및 패키지 추가 - 성진
	int travelSearchNo = 2;		  	//여행 및 패키지 조회 - 용준
	int travelUpdateNo = 3; 		//여행 및 패키지 수정 - 재연
	int travelDeleteNo = 4;		    //여행 및 패키지 삭제 - 영훈
	int travelHistoryNo = 7;		//여행 및 패키지 기록

	int returnNum = 9;            	//상위 메뉴로 돌아가기

	// 1. 여행패키지 추가
	int insertTravelPackage = 11; 	//여행패키지 추가
	int insertTravelPlace = 12; 	//여행지 추가
	int insertTravelLodging = 13;	//숙박시설 추가
	int insertTravelFood = 14;		//음식 추가

	// 2. 여행패키지 조회
	int searchRsv = 20;       		//예약 조회
	int searchTravelPackage = 21;  	//여행패키지 조회
	int searchTravelPlace = 22;     //여행지 조회
	int searchTravelLodging = 23;   //숙박시설 조회
	int searchTravelFood = 24;      //음식 조회

	// 3. 여행패키지 수정
	int updateTravelPackage = 31;   //여행패키지 수정
	int updateTravelPlace = 32;   	//여행지 수정
	int updateTravelLodging = 33; 	//숙박시설 수정
	int updateTravelFood = 34;    	//음식 수정

	// 4. 여행패키지 삭제
	int deleteReservation = 40;   	//예약 삭제
	int deleteTravelPackage = 41;   //여행패키지 삭제
	int deleteTravelPlace = 42;   	//여행지 삭제
	int deleteTravelLodging = 43; 	//숙박시설 삭제
	int deleteTravelFood = 44;    	//음식 삭제
	int deleteTravelCustomer = 45; //고객 정보 삭제

	// 7. 여행패키지 기록
	int searchTravelHistory = 71;   //여행패키지 기록 조회
	int deleteTravelHistory = 72;  	//여행패키지기록 삭제

	//terminate Program(프로그램 종료)
	int terminateNum = 99999;
}

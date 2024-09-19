package com.space.global;

public interface GlobalParams {

	//시작화면 출력(Main)
	int travelInsertNo = 1; 		//여행 및 패키지 추가 - 성진
	int travelSearchNo = 2;		  	//여행 및 패키지 조회 - 용준
	int travelUpdateNo = 3; 		//여행 및 패키지 수정 - 재연
	int travelDeleteNo = 4;		    //여행 및 패키지 삭제 - 영훈
//	int travelHistoryNo = 7;		//여행 및 패키지 기록

	int returnNum = 9;            	//상위 메뉴로 돌아가기

	// 1. 여행패키지 추가
	int insertTravelPackage = 11; 	//여행패키지 추가
	int insertTravelPlace = 12; 	//여행지 추가
	int insertTravelLodging = 13;	//숙박시설 추가
	int insertTravelFood = 14;		//음식 추가
//	int insertTravelCustomer = 15;	//고객 추가(구현예정)

	// 2. 여행패키지 조회
	int searchRsv = 21;       		//예약 조회
	int searchTravelPackage = 22;  	//여행패키지 조회
	int searchTravelPlace = 23;     //여행지 조회
	int searchTravelLodging = 24;   //숙박시설 조회
	int searchTravelFood = 25;      //음식 조회
	int searchTravelCustomers = 26;      //음식 조회

	// 2-1. 예약 조회
	int searchTravelRsvAll = 211; 			//여행예약 전체 조회
	int searchTravelRsvByID = 212;			//여행예약 ID로 조회
	int searchTravelRsvByRsvName = 213;		//여행예약 예약자명으로 조회

	// 2-2. 여행패키지 조회
	int searchTravelPackageAll = 221; 		//여행패키지 전체 조회
	int searchTravelPackageByID = 222;		//여행패키지 ID로 조회
	int searchTravelPackageByName = 223;	//여행패키지 이름 조회
	int searchTravelPackageByPrice = 224;	//여행패키지 가격 조회
	int searchTravelPackageByDate = 225;	//여행패키지 날짜 조회

	// 2-3. 여행지 조회
	int searchTravelPlaceAll = 231; 		//여행지 전체 조회
	int searchTravelPlaceByID = 232;		//여행지 ID로 조회
	int searchTravelPlaceByName = 233;		//여행지 이름 조회
//	int searchTravelPlaceByDate = 234;		//여행지 날짜 조회

	// 2-4. 숙박시설 조회
	int searchTravelLodgingAll = 241; 		//숙박시설 전체 조회
	int searchTravelLodgingByID = 242;		//숙박시설 ID로 조회
	int searchTravelLodgingByName = 243;	//숙박시설 이름 조회

	// 2-5. 음식 조회
	int searchTravelFoodAll = 251; 			//음식 전체 조회
	int searchTravelFoodByID = 252;			//음식 ID로 조회
	int searchTravelFoodByName = 253;		//음식 이름 조회

	// 2-6. 고객 조회
	int searchTravelCustomersAll = 261; 	//고객 전체 조회
	int searchTravelCustomersByID = 262;	//고객 ID로 조회
	int searchTravelCustomersByName = 263;	//고객 이름 조회

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
	int deleteTravelCustomer = 45; 	//고객 정보 삭제

	// 7. 여행패키지 기록 (구현예정)
//	int searchTravelHistory = 71;   //여행패키지 기록 조회
//	int deleteTravelHistory = 72;  	//여행패키지기록 삭제

	//terminate Program(프로그램 종료)
	int terminateNum = 99999;
}

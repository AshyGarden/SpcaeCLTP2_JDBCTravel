package com.space.global;

public interface GlobalParams {

	//Main Menu
	int infoNum = 1; 		      //현재 열차의 운행정보
	int situationNum = 2;		  //예매되어있는 좌석정보확인
	int chkNRsvNum = 3; 		  //예매한 좌석 확인 및 좌석 예매
	int cancelNum = 4;		      //예매좌석 취소
	int suggestNum = 7;		      //고객제안	
	int returnNum = 9;            //상위 메뉴로 돌아가기
	
	//Search 
	int searchAll = 1000;       //전체검색
	int saemaeulCode = 2;       //새마을호
	int mugunghwaCode = 4;     	//무궁화호
	int itxCode = 6;           	//ITX
	int ktxCode = 8;           	//KTX
	
	//예약넘버
	int reserveNum = 2;
	
	//좌석예약
	int findById = 1;
	int findByName = 2;
	int rsvId = 1;
	int rsvName =2;
	
	//좌석취소
	//int cancelNum =1;
	
	//열차 좌석수
	int seats8 = 8;
	int seats10 = 10;
	
	//메인 화면으로 돌아가기
	int returnMainNum = 999;
	
	//terminate Program
	int terminateNum = 99999; 

}

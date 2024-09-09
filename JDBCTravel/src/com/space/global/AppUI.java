package com.space.global;

public class AppUI {
	
	//Messages
	public static void DefaultMessages() {
		System.out.println("# 메뉴를 다시 입력해주세요.");
	}
	
	public static void TerminateProgramMessages() {
		System.out.println("### 99999. 예매 프로그램 종료하기 ");
	}
	
	public static void PressEnter() {
		System.out.println("\n======계속 진행하시려면 ENTER를 누르세요======");
	}	
		
	//UIs
	// 0. 시작화면 출력(Main)
	public static void startScreen() {
		System.out.println("\n========== 열차 예매 관리 시스템 ==========");
		System.out.println("### 1. 현재열차정보 ");
		System.out.println("### 2. 예매되어있는 좌석정보확인");
		System.out.println("### 3. 예매한 좌석 확인 및 좌석 예매");		
		System.out.println("### 4. 예매된 좌석취소 ");		
		System.out.println("### 7. 예매 프로그램 건의사항 작성");		 
		TerminateProgramMessages();
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}
	
	// 1. 현재운행정보 화면 출력
	public static void TrainSituationScreen() {
		System.out.println("\n========== 현재열차운행정보 ==========");
		System.out.println("### 1000. 모든 열차의 정보");
		System.out.println("### 2. 새마을호"); 
		System.out.println("### 4. 무궁화호");	  
		System.out.println("### 6. ITX"); 
		System.out.println("### 8. KTX");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("--------------------------------------");
		System.out.print(">>>"); 
	}
	
	// 2. 현재좌석예약정보 화면 출력
	public static void TrainSeatsSituationScreen() {
		System.out.println("\n========== 예매된 좌석정보 ==========");
		System.out.println("### 1000. 모든 열차의 예매정보");
		System.out.println("### 2. 새마을호"); 
		System.out.println("### 4. 무궁화호");
		System.out.println("### 6. ITX"); 
		System.out.println("### 8. KTX");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("--------------------------------------");
		System.out.print(">>>"); 
	}
	
	// 3. 좌석확인&좌석예매하기 
	public static void TrainSeatsChkNRsvScreen() {
		System.out.println("\n========= 좌석확인&예매하기 =========");
		System.out.println("### 1. 좌석 확인하기");
		System.out.println("### 2. 좌석 예매하기"); 
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("----------------------------------------");
		System.out.print(">>> "); 
	}
	
	// 3-1. 예매한 좌석 확인하기 
	public static void SeatsCheckScreen() {
		System.out.println("\n========= 좌석 확인하기 =========");
		System.out.println("### 1. ID로 예매좌석로 확인하기");
		System.out.println("### 2. 이름으로 예매좌석 확인하기");
		System.out.println("### 9. 좌석확인&예매하기 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("----------------------------------------");
		System.out.print(">>> "); 
	}

	// 3-2. 좌석 예매하기 
	public static void SeatsReservationScreen() {
		System.out.println("\n========= 좌석 예매하기 =========");
		System.out.println("### 1. 열차좌석 예약하기");
		System.out.println("### 9. 좌석확인&예매하기 페이지로 돌아가기");
		System.out.println("----------------------------------------");
		System.out.print(">>> "); 
	}
			
	// 4. 좌석 취소하기
	public static void SeatsCancelationScreen() {
		System.out.println("### 1. 예매 취소하기");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		System.out.println("----------------------------------------");
		System.out.print(">>> "); 
	}
		
	// 7. 건의사항
	public static void SuggestionScreen() {
		System.out.println("\n========= 예매 프로그램 건의사항 조회&작성 =========");
		System.out.println("### 1. 건의사항 조회하기");
		System.out.println("### 2. 건의사항 작성하기");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("----------------------------------------");
		System.out.print(">>> "); 
	}
	
	// 7-1.건의사항 조회
	public static void SearchingSuggestionScreen() {
		System.out.println("\n========= 건의사항 조회하기 =========");
		System.out.println("### 1. 전체 조회하기");
		System.out.println("### 2. ID로 조회하기");
		System.out.println("### 3. 건의게시판 번호로 조회하기");
		System.out.println("### 9. 건의사항 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("----------------------------------------");
		System.out.print(">>> "); 
	}
	
	// 240805. 관리자모드
	public static void ManagementScreen() {
		System.out.println("\n========= 예매 프로그램 관리자 모드 =========");
		System.out.println("### 1. 열차정보 추가하기");
		System.out.println("### 2. 열차정보 수정하기");
		System.out.println("### 3. 열차정보 삭제하기");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("----------------------------------------");
		System.out.print(">>> "); 
	}
	
}

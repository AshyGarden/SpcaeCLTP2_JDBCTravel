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
		System.out.println("\n========== 여행 및 패키지 관리 시스템 ==========");
		System.out.println("### 1. 여행패키지 추가");
		System.out.println("### 2. 여행패키지 조회");
		System.out.println("### 3. 여행패키지 수정");
		System.out.println("### 4. 여행패키지 삭제");
//		System.out.println("### 7. 여행패키지 기록");
		TerminateProgramMessages();
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}
	
	// 1. 여행패키지 추가
	public static void TravelInsertScreen() {
		System.out.println("\n========== 여행패키지 추가 ==========");
		System.out.println("### 11. 여행패키지 추가");
		System.out.println("### 12. 여행지 추가");
		System.out.println("### 13. 숙박시설 추가");
		System.out.println("### 14. 음식 추가");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("--------------------------------------");
		System.out.print(">>>"); 
	}
	
	// 2. 여행패키지 조회
	public static void TravelSearchScreen() {
		System.out.println("\n========== 여행패키지 조회 ==========");
		System.out.println("### 21. 예약 조회");
		System.out.println("### 22. 여행패키지 조회");
		System.out.println("### 23. 여행지 조회");
		System.out.println("### 24. 숙박시설 조회");
		System.out.println("### 25. 음식 조회");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		System.out.println("--------------------------------------");
		System.out.print(">>>"); 
	}

	// 2-1. 예약 조회
	public static void TravelSearchRsvScreen() {
		System.out.println("\n========== 예약 상세 조회 ==========");
		System.out.println("### 211. 전체 예약 조회");
		System.out.println("### 212. ID로 예약 조회");
		System.out.println("### 213. 이름으로 예약 조회");
		System.out.println("### 9. 이전 페이지로 돌아가기");
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}

	// 2-2. 여행 패키지 조회
	public static void TravelSearchPackageScreen() {
		System.out.println("\n========== 여행패키지 상세 조회 ==========");
		System.out.println("### 221. 전체 여행패키지 조회");
		System.out.println("### 222. ID로 여행패키지 조회");
		System.out.println("### 223. 이름으로 여행패키지 조회");
		System.out.println("### 224. 가격으로 여행패키지 조회");
		System.out.println("### 225. 날짜로 여행패키지 조회");
		System.out.println("### 9. 이전 페이지로 돌아가기");
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}

	// 2-3. 여행지 조회
	public static void TravelSearchPlaceScreen() {
		System.out.println("\n========== 여행지 상세 조회 ==========");
		System.out.println("### 231. 전체 여행지 조회");
		System.out.println("### 232. ID로 여행지 조회");
		System.out.println("### 233. 이름으로 여행지 조회");
		System.out.println("### 9. 이전 페이지로 돌아가기");
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}

	// 2-4. 숙박시설 조회
	public static void TravelSearchLodgingScreen() {
		System.out.println("\n========== 숙박시설 상세 조회 ==========");
		System.out.println("### 241. 전체 숙박시설 조회");
		System.out.println("### 242. ID로 숙박시설 조회");
		System.out.println("### 243. 이름으로 숙박시설 조회");
		System.out.println("### 9. 이전 페이지로 돌아가기");
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}

	// 2-5. 음식 조회
	public static void TravelSearchFoodScreen() {
		System.out.println("\n========== 음식 상세 조회 ==========");
		System.out.println("### 251. 전체 음식 조회");
		System.out.println("### 252. ID로 음식 조회");
		System.out.println("### 253. 이름으로 음식 조회");
		System.out.println("### 9. 이전 페이지로 돌아가기");
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}
	
	// 3. 여행패키지 수정
	public static void TravelUpdateScreen() {
		System.out.println("\n========== 여행패키지 수정 ==========");
		System.out.println("### 31. 여행패키지 수정");
		System.out.println("### 32. 여행지 수정");
		System.out.println("### 33. 숙박시설 수정");
		System.out.println("### 34. 음식 수정");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}
	
	// 4. 여행패키지 취소
	public static void TravelDeleteScreen() {
		System.out.println("\n========== 여행패키지 삭제 ==========");
		System.out.println("### 40. 예약 삭제");
		System.out.println("### 41. 여행패키지 삭제");
		System.out.println("### 42. 여행지 삭제");
		System.out.println("### 43. 숙박시설 삭제");
		System.out.println("### 44. 음식 삭제");
		System.out.println("### 45. 고객 정보 삭제");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("--------------------------------------");
		System.out.print(">>>");
	}
	
	// 7. 여행패키지 기록(구현예정)
	public static void TravelHistoryScreen() {
		System.out.println("\n========= 여행패키지 기록 =========");
		System.out.println("### 71. 여행패키지기록 조회");
		System.out.println("### 72. 여행패키지기록 삭제");
		System.out.println("### 9. 메인 페이지로 돌아가기");
		TerminateProgramMessages();
		System.out.println("----------------------------------------");
		System.out.print(">>> ");
	}

	// 8. ID 번호 요청
	public static void SelectID(){
		System.out.println("삭제하실 번호를 입력해주세요");
	}
	// 9. 삭제 완료 기록
	public static void DeleteCompleteMessage(){
		System.out.println("삭제를 완료했습니다.");
	}

	// 10. Insert 요청 구문
	public static void TypeSelection(String tableName){
		System.out.println(tableName + "을(를) 입력해주세요");
	}
}

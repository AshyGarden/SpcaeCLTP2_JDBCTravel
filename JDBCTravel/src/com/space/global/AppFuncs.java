package com.space.global;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppFuncs {

	private static Scanner sc = new Scanner(System.in);
	
	public static String inputString() { //문자를 입력받는 곳에서 사용
		return sc.nextLine();  
	}

	public static int inputInteger() { //숫자를 입력받는 곳에서 사용
		int inputNum = 0;
		String input = sc.nextLine(); // 먼저 한 줄을 입력받기

		// 빈 줄(엔터만 입력)일 경우 0을 반환하거나 원하는 다른 값을 반환할 수 있습니다.
		if (input.isEmpty()) {
			return GlobalParams.avoidNo; // 또는 원하는 값으로 반환
		}

		try {
			inputNum = Integer.parseInt(input); // 입력된 문자열을 숫자로 변환
		} catch (NumberFormatException e) {
			System.out.println("정수로 입력해 주세요.");
		}

		return inputNum;
	}
	
	//DATE
	public static Date inputDate() {
		Date sqlDate = null;
		
		System.out.println("Enter a date in 'YY/MM/DD' format: ");
		String inputDate = sc.nextLine();

		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		try {
            LocalDate date = LocalDate.parse(inputDate, inputFormatter);
            sqlDate = Date.valueOf(date);
     
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use 'yy/MM/dd'.");
        }
		
		return sqlDate;
    }

	
	
	//시간 간격 함수
	public static String BlockTime(LocalDateTime depart,LocalDateTime arrive) {	
		Duration duration = Duration.between(depart, arrive);
		
		// 차이를 시간, 분, 초로 출력
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
		
        return "[시간 간격: " + hours + "시간 " + minutes + "분]";
	}

	public static String SortingLogic(){

		System.out.println("조회 규칙을 설정해주세요");
		System.out.println("[1. 오름차순 / 2. 내림차순]");
		while(true){
			System.out.print(">>>");
			int inputNum = AppFuncs.inputInteger();

			if(inputNum ==1) return "ASC";
			else if(inputNum == 2) return "DESC";
			else System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
	}

	//강제종료
	public static void shutdown() {
		System.out.println("프로그램을 종료합니다.");				
		sc.close();
		System.exit(0);
	}
	
}

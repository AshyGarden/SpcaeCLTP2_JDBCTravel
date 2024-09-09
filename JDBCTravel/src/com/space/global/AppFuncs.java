package com.space.global;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppFuncs {

	private static Scanner sc = new Scanner(System.in);
	
	public static String inputString() { //문자를 입력받는 곳에서 사용
		return sc.nextLine();
	}

	public static int inputInteger() { //숫자를 입력받는 곳에서 사용
		int inputNum = 0;
		try {
			inputNum = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("정수로 입력해 주세요.");				
		} finally {
			sc.nextLine();
		}

		return inputNum;
	}
	
	//시간 간격 함수
	public static String BlockTime(LocalDateTime depart,LocalDateTime arrive) {	
		Duration duration = Duration.between(depart, arrive);
		
		// 차이를 시간, 분, 초로 출력
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
		
        return "[시간 간격: " + hours + "시간 " + minutes + "분]";
	}

	//강제종료
	public static void shutdown() {
		System.out.println("프로그램을 종료합니다.");				
		sc.close();
		System.exit(0);
	}
	
}

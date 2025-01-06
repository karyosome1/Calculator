// 제출

package com.example.calculator2;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            // 첫 번째 숫자 입력
            int num1 = getPositiveInteger(sc, "첫 번째 숫자를 입력하세요 : ");

            // 사칙연산 기호 입력
            char op = getValidOperator(sc, "사칙연산 기호를 입력하세요 (+, -, *, /) : ");

            int num2;
            while (true) {
                // 두 번째 숫자 입력
                num2 = getPositiveInteger(sc, "두 번째 숫자를 입력하세요 : ");

                if (op == '/' && num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다. 다시 입력해주세요.");
                } else {
                    break; // 적합한 값 입력 시 반복 종료
                }
            }

            // 연산 수행 및 결과 저장
            calculator.calculate(num1, num2, op);

            // 현재 결과 목록 출력
            System.out.println("현재 결과 목록: " + calculator.getResults());
            System.out.println("===================================================");

            // 반복 여부 확인
            while (true) {
                System.out.println("계속하시겠습니까? yes를 입력하면 계속, exit을 입력하면 종료, remove를 입력하면 첫 번째 값 삭제");
                String input = sc.next();

                if (input.equalsIgnoreCase("yes")) {
                    break; // 계산 반복
                } else if (input.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    return; // 프로그램 종료
                } else if (input.equalsIgnoreCase("remove")) {
                    if (!calculator.removeFirstResult()) {
                        System.out.println("데이터가 없습니다");
                        System.out.println("계속하시겠습니까? yes를 입력하면 계속, exit을 입력하면 종료합니다.");
                    } else {
                        System.out.println("첫 번째 결과가 삭제되었습니다.");
                        System.out.println("현재 결과 목록: " + calculator.getResults());
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 'yes', 'exit', 'remove' 중 하나를 입력해주세요.");
                }
            }
        }
    }

    public static int getPositiveInteger(Scanner sc, String prompt) {
        int num;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num >= 0) { // 양의 정수 확인
                    return num;
                } else {
                    System.out.println("양의 정수 또는 0을 입력해주세요.");
                }
            } else {
                System.out.println("양의 정수 또는 0을 입력해주세요.");
                sc.next(); // 잘못된 입력 제거
            }
        }
    }

    public static char getValidOperator(Scanner sc, String prompt) {
        char op;
        while (true) {
            System.out.print(prompt);
            String input = sc.next();
            if (input.length() == 1) {
                op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("유효하지 않은 연산자입니다. +, -, *, / 중 하나를 입력해주세요.");
        }
    }
}

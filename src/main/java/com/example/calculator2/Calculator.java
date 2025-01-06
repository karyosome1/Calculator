// 제출

package com.example.calculator2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private Queue<Integer> results;

    public Calculator() {
        results = new LinkedList<>();
    }

    // 연산 수행 및 결과 저장
    public void calculate(int num1, int num2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        results.add(result);
    }

    // 결과 목록 가져오기 (Getter)
    public Queue<Integer> getResults() {
        return new LinkedList<>(results); // 복사본 반환
    }

    // 결과 목록 수정 (Setter)
    public void setResults(Queue<Integer> newResults) {
        if (newResults != null) {
            this.results = new LinkedList<>(newResults);
        }
    }

    // 가장 먼저 저장된 결과 삭제
    public boolean removeFirstResult() {
        if (results.isEmpty()) {
            return false;
        }
        results.poll();
        return true;
    }
}

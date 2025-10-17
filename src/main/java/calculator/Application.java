package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        printInputNotice();
        String input = Console.readLine();
        Calculator calculator = new Calculator(input);
        // TODO: 출력 안내문 구현
    }

    private static void printInputNotice(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}

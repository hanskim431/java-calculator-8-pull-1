package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        printInputNotice();
        String input = Console.readLine();
        Calculator calculator = new Calculator(input);
        printOutputNotice(calculator);
    }

    private static void printInputNotice(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private static void printOutputNotice(Calculator calculator){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("결과 : ");
        // TODO: 계산 결과 붙이기
        System.out.println(stringBuilder.toString());
    }
}

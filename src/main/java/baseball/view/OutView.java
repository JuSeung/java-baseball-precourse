package baseball.view;

public class OutView {
    private static final String END_MASSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public void printResult(String message, boolean success) {
        System.out.println(message);
        if (success) {
            System.out.println(END_MASSAGE);
        }
    }
}

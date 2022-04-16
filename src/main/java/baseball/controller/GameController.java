package baseball.controller;

import baseball.domain.BallGenerator;
import baseball.domain.Referee;
import baseball.domain.State;
import baseball.view.InputView;
import baseball.view.OutView;
import java.util.List;

public class GameController {
    private final BallGenerator ballGenerator;
    private final InputView inputView;
    private final Referee referee;
    private final State state;
    private final OutView outView;

    public GameController() {
        this.ballGenerator = new BallGenerator();
        this.inputView = new InputView();
        this.referee = new Referee();
        this.state = new State();
        this.outView = new OutView();
    }

    public void run() {
        List<Integer> ballGeneratorList = ballGenerator.createNonDuplicateNumbers();
        while (referee.isPlayBall()) {
            String inputNumbers = inputView.askInputNumbers();
            List<Integer> inputNumberList = inputView.getInputNumberList(inputNumbers);
            referee.judgment(ballGeneratorList, inputNumberList);
            state.setBallAndStrike(referee.getBallCount(), referee.getStrikeCount());
            outView.printResult(state.getMessage(), state.isSuccess());
            referee.setPlayBall(!state.isSuccess());
        }
        askRestartAndEnd();
    }

    public void askRestartAndEnd() {
        String command = inputView.askRestartAndEnd();
        boolean isRestart = inputView.isRestart(command);
        if (isRestart) {
            referee.setPlayBall(isRestart);
            run();
        }
    }


}

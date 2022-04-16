package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @DisplayName("같은 수가 같은 자리에 있으면")
    @Test
    void same_number_same_index() {
        List<Integer> ballgeneratorList = new ArrayList<>();
        ballgeneratorList.add(1);
        ballgeneratorList.add(2);
        ballgeneratorList.add(3);

        List<Integer> inputNumberList = new ArrayList<>();
        inputNumberList.add(1);
        inputNumberList.add(2);
        inputNumberList.add(3);

        assertTrue(ballgeneratorList.get(0).equals(inputNumberList.get(0)));
        assertTrue(ballgeneratorList.get(1).equals(inputNumberList.get(1)));
        assertTrue(ballgeneratorList.get(2).equals(inputNumberList.get(2)));
    }


    @DisplayName("리스트에 담기 값에 위치 값")
    @Test
    void value_indexOf() {
        List<Integer> ballgeneratorList = new ArrayList<>();
        ballgeneratorList.add(1);
        ballgeneratorList.add(2);
        ballgeneratorList.add(3);

        assertThat(ballgeneratorList.indexOf(1)).isEqualTo(0);
        assertThat(ballgeneratorList.indexOf(2)).isEqualTo(1);
        assertThat(ballgeneratorList.indexOf(3)).isEqualTo(2);
    }

    @DisplayName("리스트에 값이 담겨 있는지 확인")
    @Test
    void value_contains() {
        List<Integer> ballgeneratorList = new ArrayList<>();
        ballgeneratorList.add(1);
        ballgeneratorList.add(2);
        ballgeneratorList.add(3);

        assertTrue(ballgeneratorList.contains(3));
        assertTrue(ballgeneratorList.contains(1));
        assertTrue(ballgeneratorList.contains(2));

    }

    @DisplayName("같은 수가 있지만 위치가 다른 경우")
    @Test
    void same_number_diffrent_index() {
        List<Integer> ballgeneratorList = new ArrayList<>();
        ballgeneratorList.add(1);
        ballgeneratorList.add(2);
        ballgeneratorList.add(3);

        List<Integer> inputNumberList = new ArrayList<>();
        inputNumberList.add(2);
        inputNumberList.add(3);
        inputNumberList.add(1);

        assertTrue(ballgeneratorList.contains(inputNumberList.get(0)) && ballgeneratorList.indexOf(inputNumberList.get(0)) != 0);
        assertTrue(ballgeneratorList.contains(inputNumberList.get(1)) && ballgeneratorList.indexOf(inputNumberList.get(1)) != 1);
        assertTrue(ballgeneratorList.contains(inputNumberList.get(2)) && ballgeneratorList.indexOf(inputNumberList.get(2)) != 2);
    }
}
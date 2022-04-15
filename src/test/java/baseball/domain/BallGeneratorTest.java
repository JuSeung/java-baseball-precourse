package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallGeneratorTest {

    @DisplayName("3자리로 생성이 되나?")
    @Test
    void isSize_Three_digits() {
        // given
        BallGenerator ballGenerator = new BallGenerator();

        // when
        int size = ballGenerator.createNonDuplicateNumbers().size();

        // then
        assertThat(size).isEqualTo(3);
    }


    @DisplayName("서로다른 수로 3자리가 생성이되나?")
    @Test
    void different_numbers() {
        // given
        BallGenerator ballGenerator = new BallGenerator();

        // when
        Set<Integer> nonduplicateNumbers = new HashSet<>(ballGenerator.createNonDuplicateNumbers());
        int size = nonduplicateNumbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

}
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz {

    @Test
    public void JUitQuiz1() {
        String name1 = "홍길도";
        String name2 = "홍길도";
        String name3 = "밥버가";

        // null이 아닌지 확인
        assertThat(name1).isNotNull();

        // name1 과 name2가 같은지 확인
        assertThat(name1).isEqualTo(name2);
        // name1 과 name3가 다른지 확인
        assertThat(name2).isNotEqualTo(name3);
    }
    @Test
    public void junitQuiz2() {
        int n1 = 15;
        int n2 = 0;
        int n3 = -5;

        //n1이 양수인지 확인
        assertThat(n1).isPositive();
        //n3가 음수인지 확인
        assertThat(n3).isNegative();
        //m1이 m2보다 큰지 화인
        assertThat(n1).isGreaterThan(n2);
    }

}


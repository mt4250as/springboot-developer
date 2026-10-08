import org.junit.jupiter.api.*;

public class JUnitTest {
    @DisplayName("성공 예정자")
    @Test
    public void junitTest(){
        int a = 1;
        int b = 2;
        int sum = 3;

        int result = a + b;
        System.out.println("성공 예정자");
        Assertions.assertEquals(sum, result);
    }
    @DisplayName("실패 예정자")
    @Test
    public void JUnitTest2(){
        int a = 1;
        int b = 3;
        int result = a+b;
        System.out.println("실패 예정자");
        Assertions.assertEquals(3, result);
    }
    @BeforeEach
    public void prepare() {
        System.out.println("준비");
    }
    @AfterEach
    public void cleanup() {
        System.out.println("완료");
    }
    @BeforeAll
    public static void prepareAll() {
        System.out.println("첫 시작을 알림");
    }
    @AfterAll
    public static void cleanupAll() {
        System.out.println("시스템 종료를 알림");
    }
    public static void main(String[] args) {}
}

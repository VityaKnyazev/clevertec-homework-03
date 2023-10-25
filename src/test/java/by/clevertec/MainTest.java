package by.clevertec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MainTest {
    private  MockedStatic<Main> mainMockStatic;

    @BeforeEach
    public void setUp() {
        mainMockStatic = Mockito.mockStatic(Main.class);
    }

    @Test
    public void checkTask19ShouldBeCalledOnce() {

        mainMockStatic.when(Main::task19).thenAnswer(invocation -> {
            System.out.println("Testing call to method task19");

            return invocation.callRealMethod();
        });

        Main.task19();

        mainMockStatic.verify(Main::task19);
    }
}

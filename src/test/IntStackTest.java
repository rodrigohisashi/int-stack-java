import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe IntStack")
public class IntStackTest {

    private IntStack stack;

    @BeforeEach
    public void setUp() {
        stack = new IntStack(5);
    }

    @Test
    public void testEmptyExceptionOnPop() {
        Assertions.assertThrows(StackEmptyException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void testFullStackOnPush() {
        Assertions.assertThrows(StackFullException.class, () -> {
            for (int i = 1; i <= 6; i++) {
                stack.push(i);
             }
        });
    }

    @Test
    public void testIsEmpty() {

        Assertions.assertTrue(stack.isEmpty());
        stack.push(4);
        Assertions.assertFalse(stack.isEmpty());
    }


    @Test
    public void testIsFull() {

        for (int i = 1; i <= 5; i++) {
            Assertions.assertFalse(stack.isFull());
            stack.push(i);
        }
        Assertions.assertTrue(stack.isFull());
    }

    @Test
    public void testClear() {

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush() {

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            Assertions.assertEquals(i + 1, stack.size());
        }

    }

    @Test
    public void testPop() {

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        for (int i = 5; i >= 1; i--) {
            Assertions.assertEquals(i, stack.size());
            Assertions.assertEquals(i, stack.pop());
        }
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    public void testPeek() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            Assertions.assertEquals(i, stack.peek());
        }
        Assertions.assertEquals(5, stack.peek());
        stack.pop();
        Assertions.assertEquals(4, stack.peek());

    }

    @Test
    public void emptyStackOnPeek() {
        Assertions.assertThrows(StackEmptyException.class, () -> {
            stack.peek();
        });
    }


    @Test
    public void testToString() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        Assertions.assertEquals("[1, 2, 3, 4, 5]", stack.toString());
        stack.pop();
        Assertions.assertEquals("[1, 2, 3, 4]", stack.toString());
    }
}

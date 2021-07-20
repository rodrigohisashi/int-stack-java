public class IntStack {
    private final int[] elements;
    private int top;


    public IntStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Tamanho deve ser positivo");
        }
        this.elements = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackFullException(String.format("A pilha está cheia com %d elementos", size()));
        }
        elements[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new StackEmptyException("A pilha está vazia, não é possível remover!");
        }
        return elements[top--];
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return elements[top];
        }
        throw new StackEmptyException("A pilha está vazia, não é possível achar o topo!");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i <= top; i++ ) {
            sb.append(elements[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO: Demonstration;
        IntStack stack = new IntStack(4);

        System.out.println(stack);
        stack.push(5);
        System.out.println(stack.peek());
        stack.push(2);

        System.out.println(stack.peek());
        stack.push(9);
        System.out.println(stack.isFull());
        stack.push(9);


        System.out.println(stack.isFull());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}

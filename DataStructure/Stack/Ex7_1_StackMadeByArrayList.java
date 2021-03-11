package Stack;

public class Ex7_1_StackMadeByArrayList {
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(5);

        s.printStack();

        System.out.println("push >>> ");
        s.push("1");
        s.push("3");
        s.push("5");
        s.printStack();
        System.out.println("peek >>> " + s.peek());

        System.out.println("pop >>> ");
        s.pop();
        s.printStack();

        System.out.println("delete >>> ");
        s.delete();
        s.printStack();
    }
}

interface StackForEx7_1 {
    boolean isEmpty();
    boolean isFull();
    void push(String item);
    String pop();
    void delete();
    String peek();
}

class ArrayStack implements StackForEx7_1 {

    private int top;
    private int stackSize;
    private String itemArray[];

    public ArrayStack(int stackSize) {
        top = -1;
        this.stackSize = stackSize;
        itemArray = new String[this.stackSize];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == stackSize-1;
    }

    @Override
    public void push(String item) {
        if(isFull()) {
            System.out.println("Stack is full");
        } else {
            itemArray[++top] = item;
            System.out.println("new pushed item = " + item);
        }
    }

    @Override
    public String pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return itemArray[top--];
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
        }
    }

    @Override
    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return itemArray[top];
        }
    }

    public void printStack() {
        System.out.printf("Stack.ArrayStack >>>  ( ");
        for (int i = 0; i <= top; i++) {
            System.out.printf(itemArray[i] + ", ");
        }
        System.out.println(" )");
    }
}
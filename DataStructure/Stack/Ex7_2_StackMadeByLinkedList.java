package Stack;

public class Ex7_2_StackMadeByLinkedList {
    public static void main(String[] args) {
        LinkedStack l = new LinkedStack();
        l.printStack();

        System.out.println("push >>> ");
        l.push("1");
        l.push("3");
        l.push("5");
        l.printStack();

        System.out.println("peek >>> ");
        System.out.println(l.peek());

        System.out.println("pop >>> ");
        l.pop();
        l.printStack();

        System.out.println("pop >>> ");
        l.pop();
        l.printStack();
    }
}

interface StackForEx7_2 {
    boolean isEmpty();
    void push(String item);
    String pop();
    String peek();
}

class StackNode {
    String data;
    StackNode link;
}

class LinkedStack implements StackForEx7_2 {
    StackNode top;

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(String item) {
        StackNode newNode = new StackNode();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
        System.out.println("pushed item >>> " + item);
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else {
            String item = top.data;
            top = top.link;
            return item;
        }
    }

    @Override
    public String peek() {
        return top.data;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            StackNode temp = top;
            System.out.printf("printStack >>>");
            while (temp != null) {
                System.out.println("\n" + temp.data);
                temp = temp.link;
            }
        }
    }
}
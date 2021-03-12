package Queue;
// Deque= Double-ended Queue
// 양쪽 끝(front, rear)에 삽입과 삭제 가능한 큐
public class Ex8_4_Deque {
    public static void main(String[] args) {
        Deque d = new Deque();
        d.insertAtFront(5);

        d.deleteAtFront();
        d.printDeque();

        d.insertAtFront(3);
        d.insertAtRear(7);
        d.insertAtRear(9);
        d.insertAtFront(1);
        d.printDeque();

        d.deleteAtFront();
        d.printDeque();

        d.deleteAtRear();
        d.printDeque();
    }
}

class DNode {
    int data;
    DNode leftLink;
    DNode rightLink;

    public DNode(int data) {
        this.data = data;
    }
}

class Deque {
    DNode front;
    DNode rear;

    public Deque() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void insertAtFront(int data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            front.leftLink = null;
            rear.rightLink = null;
        } else {
            newNode.leftLink = null;
            newNode.rightLink = front;
            front.leftLink = newNode;
            front = newNode;
        }
        System.out.println("Insert at Front: " + data);
    }

    public void insertAtRear(int data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            front.leftLink = null;
            rear.rightLink = null;
        } else {
            newNode.rightLink = null;
            newNode.leftLink = rear;
            rear.rightLink = newNode;
            rear = newNode;
        }
        System.out.println("Insert at Rear: " + data);

    }

    public int deleteAtFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return 0;
        } else {
            int deletedValue = front.data;
            if (front.rightLink == null) {
                front = null;
                rear = null;
            } else {
                front = front.rightLink;
                front.leftLink = null;
            }
            System.out.println("Delete at Front: " + deletedValue);
            return deletedValue;
        }
    }

    public int deleteAtRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return 0;
        } else {
            int deletedValue = rear.data;
            if (rear.leftLink == null) {
                front = null;
                rear = null;
            } else {
                rear = rear.leftLink;
                rear.rightLink = null;
            }
            System.out.println("Delete at Rear: " + deletedValue);
            return deletedValue;
        }
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
        } else {
            System.out.printf("Print Deque >>> ");
            DNode temp = front;
            while (temp != null) {
                System.out.printf(Integer.toString(temp.data) + " ");
                temp = temp.rightLink;
            }
            System.out.println();
        }
    }
}

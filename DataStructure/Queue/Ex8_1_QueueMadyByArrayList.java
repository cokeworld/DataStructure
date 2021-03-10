public class Ex8_1_QueueMadyByArrayList {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        q.enQueue("1");
        q.enQueue("3");
        q.enQueue("4");
        q.printQueue();

        System.out.println("Dequeue Item: " + q.deQueue());
        System.out.println("Dequeue Item: " + q.deQueue());

        System.out.printf("peek >>> ");
        System.out.println(q.peek());

        q.printQueue();
    }
}

interface QueueForEx8_1 {
    boolean isEmpty();
    void enQueue(String item);
    String deQueue();
    String peek();
}

class ArrayQueue implements QueueForEx8_1 {
    private int front;
    private int rear;
    private int queueSize;
    private String queueArray[];

    public ArrayQueue(int queueSize) {
        this.front = -1;
        this.rear = -1;
        this.queueSize = queueSize;
        queueArray = new String[this.queueSize];
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == this.queueSize-1;
    }


    @Override
    public void enQueue(String item) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
           queueArray[++rear] = item;
           System.out.println("Inserted Item: " + item);
        }
    }

    @Override
    public String deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return queueArray[++front];
        }
    }

    @Override
    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return queueArray[front + 1];
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.printf("PrintQueue >>> ");

            for (int i = front+1; i <= this.rear; i++) {
                System.out.printf(queueArray[i] + " ");
            }
            System.out.println();
        }
    }
}
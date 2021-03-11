package Queue;

public class Ex8_2_QueueMadyByLinkedList {
    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        System.out.println("Enqueue Test >>> ");
        q.enQueue("1");
        q.enQueue("3");
        q.printQueue();
        q.enQueue("5");
        q.printQueue();

        System.out.println("Dequeue Test >>> ");
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.printQueue();
    }
}

class QNode {
    String data;
    QNode link;

    public QNode(String data) {
        this.data = data;
        this.link = null;
    }
}

interface QueueForEx8_2 {
    boolean isEmpty();
    void enQueue(String item);
    String deQueue();
}

class LinkedQueue implements QueueForEx8_2{
    QNode front;
    QNode rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void enQueue(String item) {
        System.out.println("Inserted Item: " + item);
        QNode newNode = new QNode(item);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
    }

    @Override
    public String deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            String deQueueData = front.data;
            front = front.link;
            if(front == null) {
                rear = null;
            }
            return deQueueData;
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            QNode temp = front;
            System.out.printf("printQueue >>> ");
            while (temp != null) {
                System.out.printf(temp.data + " ");
                temp = temp.link;
            }
            System.out.println();
        }
    }
}

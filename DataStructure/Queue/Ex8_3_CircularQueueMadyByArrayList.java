public class Ex8_3_CircularQueueMadyByArrayList {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(4);
        cq.printQueue();
        System.out.println("Queue >>> ");
        cq.enQueue(1);
        cq.printQueue();

        System.out.println("Queue >>> ");
        cq.enQueue(3);
        cq.enQueue(6);
        // Queue will be full.
        cq.enQueue(8);
        cq.printQueue();

        System.out.println("Dequeue >>> ");
        cq.deQueue();
        cq.printQueue();

    }
}

interface QueueFor8_3 {
    boolean isEmpty();
    void enQueue(int data);
    int deQueue();
}

class CircularQueue implements QueueFor8_3{
    private int front;
    private int rear;
    private int array[];
    private int queueSize;

    public CircularQueue(int queueSize) {
        this.front = 0;
        this.rear = 0;
        this.queueSize = queueSize;
        this.array = new int[queueSize];
    }

    /*     큐가 empty인 경우
     1. CircularQueue 객체를 초기화해서 front, rear 값이 둘다 0으로 같은 경우.
     2. 마지막으로 삽입된 rear를 삭제해서 front, rear 값이 같은 경우.*/
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /*     큐가 full인 경우
     1. rear가 큐를 한 바퀴 돌면서 큐를 모두 채우고 rear의 다음 위치((rear + 1) % queueSize)가 front 위치가 되는 경우.
     편의상 배열 한자리는 비워둠.*/
    public boolean isFull() {
        return ((rear+1) % this.queueSize) == front;
    }

    /*    (rear+1) % this.queueSize 를 인덱스에 대입하여 원형 큐 구현.*/
    @Override
    public void enQueue(int data) {
        if(isFull()) {
            System.out.println("Queue is full");
        } else {
            rear = (rear + 1) % this.queueSize;
            array[rear] = data;
            System.out.println("Inserted Data: " + data);
        }
    }

    @Override
    public int deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
        } else {
            front = ((front + 1) % this.queueSize);
            return array[front];
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.printf("PrintQueue >>> [ ");
            for (int i = ((front + 1) % this.queueSize); i != ((rear + 1) % this.queueSize); i = ++i % this.queueSize) {
                System.out.printf(array[i] + " ");
            }
            System.out.printf(" ]");
            System.out.println();
        }
    }
}

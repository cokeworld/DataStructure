package Graph;
// 인접 리스트로 표현한 그래프의 깊이 우선 탐색과 너비 우선 탐색
public class DFS_BFS {
    public static void main(String[] args) {
        AdjListForFs G = new AdjListForFs();
        for (int i = 0; i < 6; i++) {
            G.insertVertex(i);
        }
        G.insertEdge(0,3);
        G.insertEdge(0,1);
        G.insertEdge(1,5);
        G.insertEdge(1,3);
        G.insertEdge(2,1);
        G.insertEdge(3,4);
        G.insertEdge(3,1);
        G.insertEdge(4,3);
        G.insertEdge(4,0);
        G.insertEdge(5,4);
        G.insertEdge(5,2);
        G.insertEdge(5,1);
        G.insertEdge(5,0);

        G.printAdjList();

        G.BFS(0);
    }
}

class StackNode{
    int data;
    StackNode link;

}

class LinkedStack {
    StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        StackNode newNode = new StackNode();
        newNode.data = data;
        newNode.link = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("LinkedStack is empty");
            return 0;
        } else {
            int popNode = top.data;
            top = top.link;
            return popNode;
        }
    }
}

class QNode {
    int data;
    QNode link;
}

class LinkedQueue {
    QNode front;
    QNode rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(int data) {
        QNode newNode = new QNode();
        newNode.data = data;
        newNode.link = null;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
        } else {
            int deQueuedData = front.data;
            front = front.link;
            if (front == null) {
                rear = null;
            }
            return deQueuedData;
        }
    }
}

class GraphNodeForFS {
    int vertex;
    GraphNodeForFS link;
}

class AdjListForFs {
    GraphNodeForFS head[] = new GraphNodeForFS[10];
    int totalVertex = 0;

    // vertex 값 삽입 발생x, totalVertex 카운트 용 메소드
    public void insertVertex(int data) {
        totalVertex++;
    }

    public void insertEdge(int vertex1, int vertex2) {
        if (vertex1 >= totalVertex || vertex2 >= totalVertex) {
            System.out.println("There is no vertex");
        } else {
            GraphNodeForFS newNode = new GraphNodeForFS();
            newNode.vertex = vertex2;
            newNode.link = head[vertex1];
            head[vertex1] = newNode;
        }
    }

    public void printAdjList() {
        for (int i = 0; i < totalVertex; i++) {
            System.out.printf("\n정점 "+ i +"의 인접리스트 ");
            GraphNodeForFS temp = head[i];

            while (temp != null) {
                System.out.printf("-> " + temp.vertex);
                temp = temp.link;
            }
        }
    }

    public void DFS(int vertex) {
        GraphNodeForFS gNode = new GraphNodeForFS();
        LinkedStack stack = new LinkedStack();
        boolean visited[] = new boolean[10];

        stack.push(vertex);
        visited[vertex] = true;
        System.out.printf(vertex + " ");
        while (stack != null) {
            gNode = head[vertex];
            while (gNode != null) {
                int nowVertex = gNode.vertex;
                if (!visited[nowVertex]) {
                    visited[nowVertex] = true;
                    System.out.printf(nowVertex + " ");
                    stack.push(nowVertex);
                    gNode = head[nowVertex];
                } else {
                    gNode = gNode.link;
                }
            }
            vertex = stack.pop();
        }
    }

    public void BFS(int vertex) {
        GraphNodeForFS gNode = new GraphNodeForFS();
        LinkedQueue queue = new LinkedQueue();
        boolean visited[] = new boolean[10];

        visited[vertex] = true;
        queue.enQueue(vertex);
        System.out.printf(vertex + " ");

        while (!queue.isEmpty()) {
            vertex = queue.deQueue();
            for (gNode = head[vertex]; gNode != null; gNode = gNode.link) {
                if (!visited[gNode.vertex]) {
                    visited[gNode.vertex] = true;
                    System.out.printf(gNode.vertex + " ");
                    queue.enQueue(gNode.vertex);
                }
            }
        }
    }

}





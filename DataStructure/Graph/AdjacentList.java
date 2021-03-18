package Graph;
// 연결 자료구조 방식을 이용한 그래프의 구현: 인접 리스트
public class AdjacentList {
    public static void main(String[] args) {
        AdjList al = new AdjList();
        for (int i = 0; i < 4; i++) {
            al.insertVertex(i);
        }

        al.insertEdge(0, 3);
        al.insertEdge(0, 2);
        al.insertEdge(0, 1);
        al.insertEdge(1, 3);
        al.insertEdge(1, 0);
        al.insertEdge(2, 1);
        al.insertEdge(2, 0);
        al.insertEdge(3, 1);
        al.insertEdge(3, 1);
        al.insertEdge(4, 3);

        al.printAdjList();
    }
}

class GraphNode {
    int vertex;
    GraphNode link;
}

class AdjList {
    private GraphNode head[] = new GraphNode[10];
    private int totalVertex = 0;

    // vertex 값을 입력하지 않는다.
    // vertex 갯수 카운트용 메소드
    public void insertVertex(int vertex) {
        totalVertex++;
    }

    // vertex2 값을 내림차순으로 입력해야 함.
    public void insertEdge(int vertex1, int vertex2) {
        if (vertex1 >= totalVertex || vertex2 >= totalVertex) {
            System.out.println("Vertex is out of range");
        } else {
            GraphNode gNode = new GraphNode();
            gNode.vertex = vertex2;
            gNode.link = head[vertex1];
            head[vertex1] = gNode;
        }
    }

    public void printAdjList() {
        for (int i = 0; i <= totalVertex; i++) {
            System.out.printf("\n정점 "+ i +"의 인접리스트 ");
            GraphNode gNode = head[i];

            while (gNode != null) {
                System.out.printf("-> " + gNode.vertex);
                gNode = gNode.link;
            }
        }
    }
}
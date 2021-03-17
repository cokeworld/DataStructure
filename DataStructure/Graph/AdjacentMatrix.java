package Graph;
//순차 자료구조 방식을 이용한 그래프의 구현: 2차원 배열의 인접 행렬
public class AdjacentMatrix {
    public static void main(String[] args) {
        AdjMatrix am = new AdjMatrix();
        for (int i = 0; i < 5; i++) {
            am.insertVertex(i);
        }
        am.insertEdge(0,2);
        am.insertEdge(0,4);
        am.insertEdge(0,1);
        am.insertEdge(1,2);
        am.insertEdge(1,4);
        am.insertEdge(2,4);
        am.insertEdge(3,2);
        am.insertEdge(3,1);
        am.insertEdge(4,0);
        am.insertEdge(4,1);
        am.printAdjMatrix();
    }
}

class AdjMatrix {
    int matrix[][] = new int[10][10];
    int totalVertex = 0;

    public void insertVertex(int vertex) {
        totalVertex++;
    }

    public void insertEdge(int vertex1, int vertex2) {
        if (vertex1 >= totalVertex || vertex2 >= totalVertex) {
            System.out.println("There is no vertex");
        } else {
            matrix[vertex1][vertex2] = 1;
        }
    }

    public void printAdjMatrix() {
        for (int i = 0; i < totalVertex; i++) {
            System.out.printf("\n\t\t");
            for (int j = 0; j < totalVertex; j++) {
                System.out.printf("%2d", matrix[i][j]);
            }
        }
    }
}

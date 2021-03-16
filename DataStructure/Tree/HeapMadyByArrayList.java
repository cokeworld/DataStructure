package Tree;

public class HeapMadyByArrayList {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insertHeap(6);
        heap.insertHeap(4);
        heap.insertHeap(2);
        heap.insertHeap(10);
        heap.insertHeap(7);
        heap.insertHeap(3);
        heap.printHeap();

        int heapSize = heap.getHeapSize();
        for (int i = 1; i <= heapSize; i++) {
            int deletedItem = heap.deleteHeap();
            System.out.printf("\nDeleted Item: [%d] ", deletedItem);
        }
    }
}

class Heap {
    private int heapSize;
    private int itemHeap[];

    public Heap() {
        heapSize = 0;
        itemHeap = new int[50];
    }

    public void insertHeap(int item) {
        int i = ++heapSize;
        while ((i != 1) && (item >= itemHeap[i/2])) {
            itemHeap[i] = itemHeap[i/2];
            i = i/2;
        }
        itemHeap[i] = item;
    }

    public int deleteHeap() {
        int item = itemHeap[1];
        int temp = itemHeap[heapSize--];
        int parent = 1;
        int child = 2;

        while (child <= heapSize) {
            if ((child < heapSize) && (itemHeap[child] < itemHeap[child+1])) {
                child++;
            }
            if (temp >= itemHeap[child]) break;

            itemHeap[parent] = itemHeap[child];
            parent = child;
            child = child * 2;
        }
        itemHeap[parent] = temp;
        return item;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public void printHeap() {
        System.out.println("PrintHeap >>>");
        for (int i = 1; i <= heapSize; i++) {
            System.out.printf("[%d] ", itemHeap[i]);
        }
    }
}

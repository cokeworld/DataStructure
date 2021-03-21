package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {23, 5, 35, 66, 11, 77, 24, 34, 54};
        BubSort bs = new BubSort();
        bs.bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d", arr[i]);
        }
        System.out.println();
    }
}

class BubSort {

    public void bubbleSort(int arr[]) {
        int arrSize = arr.length;
        for (int i = arrSize; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
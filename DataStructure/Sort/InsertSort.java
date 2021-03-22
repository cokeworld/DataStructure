package Sort;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3, 6, 4, 87, 54, 23, 44, 65, 21, 95};
        InsertionSort is = new InsertionSort();
        is.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d", arr[i]);
        }
        System.out.println();
    }
}

class InsertionSort {
    public void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int position = i;
            int tempValue = arr[i];

            while (position > 0 && arr[position - 1] > tempValue) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = tempValue;

            System.out.printf("\n삽입정렬 %d 단계 : ", i);
            for (int t = 0; t < arr.length; t++) {
                System.out.printf("%3d ", arr[t]);
            }
        }
        System.out.println();
    }
}

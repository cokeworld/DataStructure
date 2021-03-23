package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {32, 41, 64, 24, 76, 94, 23, 54, 20, 11};
        QSort qs = new QSort();
        qs.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %3d", arr[i]);
        }
        System.out.println();
    }
}

class QSort {
    public int partition(int arr[], int begin, int end) {

        int temp;
        int left = begin;
        int right= end;
        int pivot = (begin + end) / 2;
        System.out.printf("\npivot=%d", arr[pivot]);

        while (left < right) {
            while ((arr[left] <= arr[pivot]) && (left <= right)) {
                left++;
            }
            while ((arr[right] > arr[pivot]) && (left <= right)) {
                right--;
            }
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                if (left == pivot) {
                    return right;
                }
            }
        }
        // left > right 인 경우
        temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
        return right;
    }

    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int p = partition(arr, begin, end);
            quickSort(arr, begin, p - 1);
            quickSort(arr, p + 1, end);
        }
    }
}
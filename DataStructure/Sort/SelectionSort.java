package Sort;
//선택정렬
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {2,1,4,5,3,7,6,8};
        SelectSort ss = new SelectSort();
        ss.selectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d", arr[i]);
        }
        System.out.println();
    }
}

class SelectSort {
    public void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int lowestValueIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[lowestValueIndex] > arr[j]) {
                    lowestValueIndex = j;
                }
            }
            if (lowestValueIndex != i) {
                int tempValue = arr[i];
                arr[i] = arr[lowestValueIndex];
                arr[lowestValueIndex] = tempValue;
            }
        }
    }
}


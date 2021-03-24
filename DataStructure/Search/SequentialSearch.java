package Search;

public class SequentialSearch {
    public static void main(String[] args) {
        int unorderedArr[] = {26, 35, 88, 44, 34, 12, 96, 31, 64};
        int orderedArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SequentSearch ss = new SequentSearch();
        ss.searchUnorderedList(unorderedArr, 12);
        ss.searchOrderedList(orderedArr, 9);
    }
}

class SequentSearch {
    public void searchUnorderedList(int arr[], int key) {
        int i = 0;
        while (i < arr.length && key != arr[i]) {
            i++;
        }
        if (i < arr.length) {
            System.out.printf("검색성공! 찾은 인덱스 %d", i);
        } else {
            System.out.printf("검색실패!");
        }
        System.out.println();
    }

    public void searchOrderedList(int arr[], int key) {
        int i = 0;
        while (arr[i] < key) {
            i++;
        }
        if (arr[i] == key) {
            System.out.printf("검색성공! 찾은 인덱스 %d", i);
        } else {
            System.out.printf("검색실패!");
        }
        System.out.println();
    }
}
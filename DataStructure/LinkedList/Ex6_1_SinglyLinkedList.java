package LinkedList;

public class Ex6_1_SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        System.out.println("1. 공백 리스트에 노드 3개 삽입하기");
        l.insertLastNode("1");
        l.insertLastNode("3");
        l.insertLastNode("6");
        l.printList();

        System.out.println("2. 3월 노드 뒤에 4월 노드 삽입하기");
        ListNode pre = l.searchNode("3");
        if(pre == null) {
            System.out.println("검색실패: 찾는 데이터가 없습니다.");
        } else {
            l.insertMiddleNode(pre, "4");
            l.printList();
        }

        System.out.println("3. 리스트의 노드를 역순으로 바꾸기");

        System.out.println("4. 리스트의 마지막 노드 삭제하기");
        l.deleteLastNode();
        l.printList();
    }
}


//LinkedList.LinkedList
class LinkedList {
    private ListNode head;

    public LinkedList() {
        head = null;
    }

    public void insertMiddleNode(ListNode pre, String data) {
        ListNode newNode = new ListNode(data);
        newNode.link = pre.link;
        pre.link = newNode;
    }

    public void insertLastNode(String data) {
        ListNode newNode = new ListNode(data);

        if(head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while(temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void deleteLastNode() {
        ListNode pre, temp;

        if(head == null) {
            System.out.println("삭제실패: 값이 없습니다.");
            return;
        } else {
            pre = head;
            temp = head.link;
            while (temp.link != null) {
                pre = temp;
                temp = temp.link;
            }
            pre.link = null;
        }
    }

    public ListNode searchNode(String data) {
        ListNode temp = this.head;
        while (temp != null) {
            if(data == temp.getData()) {
                return temp;
            } else {
                temp = temp.link;
            }
        }
        System.out.println("검색실패: " + data + "은(는) 없습니다.");
        return temp;
    }

    public void reverseList() {

    }

    public void printList() {
        ListNode temp = this.head;
        System.out.printf("l = ( ");
        while (temp != null) {
            System.out.printf(temp.getData());
            temp = temp.link;

            if(temp != null) {
                System.out.printf(", ");
            }
        }
        System.out.println(" )");
    }

}

//LinkedList.ListNode
class ListNode {
    private String data;
    public ListNode link;

    public ListNode(String data) {
        this.data = data;
        link = null;
    }

    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return data;
    }
}

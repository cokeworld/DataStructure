package Tree;

public class BinaryTreeMadyByLinkedList {
    public static void main(String[] args) {
        LinkedNode ln = new LinkedNode();
        TreeNode n7 = new TreeNode(null, "D", null);
        TreeNode n6 = new TreeNode(null, "C", null);
        TreeNode n5 = new TreeNode(null, "B", null);
        TreeNode n4 = new TreeNode(null, "A", null);
        TreeNode n3 = new TreeNode(n6, "/", n7);
        TreeNode n2 = new TreeNode(n4, "*", n5);
        TreeNode n1 = new TreeNode(n2, "-", n3);

        System.out.println("\nPreorder");
        ln.preorder(n1);

        System.out.println("\nInorder");
        ln.inorder(n1);

        System.out.println("\nPostorder");
        ln.postorder(n1);
    }
}

class TreeNode {
    TreeNode left;
    String data;
    TreeNode right;

    public TreeNode(TreeNode left, String data, TreeNode right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }
}

class LinkedNode {
    private TreeNode root;

    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.printf(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf(root.data + " ");
            inorder(root.right);
        }
    }

    public void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf(root.data + " ");
        }
    }
}
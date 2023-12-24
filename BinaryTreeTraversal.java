import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class BinaryTreeTraversal {
     public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode root = constructRootOfTree();

        System.out.println("== Preorder Traversal ==");
        preorderTraversal(root);
        System.out.println();

        System.out.println("== Inorder Traversal ==");
        inorderTraversal(root);
        System.out.println();

        System.out.println("== Postorder Traversal ==");
        postorderTraversal(root);
        System.out.println();
    }

    private static void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    private static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    private static void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    private static TreeNode constructRootOfTree() {
        System.out.print("Enter the value of the root node: ");
        TreeNode root = new TreeNode(scanner.nextInt());
        addNodesOfTree(root);
        return root;
    }

    private static void addNodesOfTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            System.out.print("Enter left child value of " + current.data + " (or -1 to skip):");
            int leftData = scanner.nextInt();
            if (leftData != -1) {
                current.left = new TreeNode(leftData);
                queue.add(current.left);
            }

            System.out.print("Enter right child value of " + current.data + " (or -1 to skip):");
            int rightData = scanner.nextInt();
            if (rightData != -1) {
                current.right = new TreeNode(rightData);
                queue.add(current.right);
            }
        }
    }
}
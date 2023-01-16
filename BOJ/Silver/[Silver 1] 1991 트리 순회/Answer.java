import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N =  Integer.parseInt(br.readLine());

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());
            insertNode(head, st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        // 전위 순회
        preOrder(head);
        System.out.println();

        // 중위 순회
        inOrder(head);
        System.out.println();

        // 후위 순회
        postOrder(head);
        System.out.println();
    }

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node temp, char root, char left, char right) {
        if (temp.value == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (temp.left != null) insertNode(temp.left, root, left, right);
            if (temp.right != null) insertNode(temp.right, root, left, right);
        }
    }

    public static void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.value);  // (루트)
        preOrder(node.left);  // (왼쪽 자식)
        preOrder(node.right);  // (오른쪽 자식)
    }

    public static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);  // (왼쪽 자식)
        System.out.print(node.value);  // (루트)
        inOrder(node.right);  // (오른쪽 자식)
    }

    public static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);  // (왼쪽 자식)
        postOrder(node.right);  // (오른쪽 자식)
        System.out.print(node.value);  // (루트)
    }
}
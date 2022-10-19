import java.util.*;

public class TreeBuilder {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int[] inorder = new int[n];
        for(int i=0;i<n;i++)
            inorder[i]=in.nextInt();
        int[] preorder = new int[n];
        for(int i=0;i<n;i++)
            preorder[i]=in.nextInt();
        Node root = buildTree(inorder, preorder, n);
        postOrder(root);
    }
    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static Node buildTree(int inorder[], int preorder[], int n) {
    // code here 
        HashMap < Integer, Integer > map = new HashMap < > ();
        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);
        Node root = build(preorder, 0, n - 1, inorder, 0, n - 1, map);
        return root;
    }
    public static Node build(int[] preorder, int sp, int ep, int[] inorder, int si, int ei, HashMap < Integer, Integer > map) {
        if (sp > ep || si > ei)
            return null;
        Node root = new Node(preorder[sp]);
        int n = map.get(root.data);
        int left = n - si;
        root.left = build(preorder, sp + 1, sp + left, inorder, si, n - 1, map);
        root.right = build(preorder, sp + left + 1, ep, inorder, n + 1, ei, map);
        return root;
    }
}
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}
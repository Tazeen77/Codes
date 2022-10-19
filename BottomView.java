import java.util.*;

public class BottomView {

  static Node root;

  public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
    int numberOfNodes= in.nextInt();
    Queue<Node> q = new LinkedList<Node>();
    Node root=null;
    for(int i=0;i<numberOfNodes;i++){
        int item = in.nextInt();
        Node tmp = new Node(item);
        if(root==null)
            root=tmp;
        else{
            Node tmp1= q.peek();
            if(tmp1.left==null)
                tmp1.left= tmp;
            else{
                tmp1.right = tmp;
                q.remove();
            }
        }
        q.add(tmp);
    }
    
    ArrayList < Integer > ans = bottomView(root);
    for (Integer tmp: ans)
      System.out.println(tmp);
  }


  static public ArrayList < Integer > bottomView(Node root) {
    ArrayList < Integer > result = new ArrayList < > ();

    if (root == null) return result;

    int hd = 0;

    Map < Integer, Integer > map = new TreeMap < > ();

    Queue < Node > queue = new LinkedList < > ();

    root.hd = hd;
    queue.add(root);

    while (!queue.isEmpty()) {
      Node current = queue.remove();

      hd = current.hd;

      map.put(hd, current.data);

      if (current.left != null) {
        current.left.hd = hd - 1;
        queue.add(current.left);
      }

      if (current.right != null) {
        current.right.hd = hd + 1;
        queue.add(current.right);
      }
    }

    for (Map.Entry < Integer, Integer > entry: map.entrySet()) {
      result.add(entry.getValue());
    }

    return result;
  }

}
class Node {
  int data, hd;
  Node left, right;
  Node(int data) {
    this.data = data;
    hd = Integer.MAX_VALUE;
  }
}

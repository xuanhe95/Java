import java.util.*;
import java.io.*;

public class is_bst_hard {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            // Implement correct algorithm here
          
            Stack<Node> stack = new Stack<Node>();
            
            Node preNode = null;
            if(tree.length == 0 ){
                return true;
            }
            stack.add(tree[0]);
            while(!stack.empty()){
                Node curNode = stack.peek();
                if(curNode.left != -1){ //压入所有当前子节点
                    stack.add(tree[curNode.left]);
                    continue;
                }
                if(preNode == null){
                    preNode = curNode;
                }
                curNode = stack.pop();
                if(preNode.key > curNode.key){  //此处无需修改，上一个node是上一个根节点
                        return false;
                }
           
                while(curNode.right == -1 && !stack.empty()){
                    
                    preNode = curNode;
                    curNode = stack.pop();

                    if(preNode.key >= curNode.key){ //此处改为严格大于，因为上一个node并非根节点
                        return false;
                    }
                    preNode = curNode;
                }
                if(curNode.right != -1){
                    preNode = curNode;
                    stack.add(tree[curNode.right]);
                }
            }
            return true;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}

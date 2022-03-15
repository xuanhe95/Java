import java.util.*;
import java.io.*;

public class tree_orders {
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

    public class TreeOrders {
        int n;
        int[] key, left, right;
        
        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) { 
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Finish the implementation
            // You may need to add a new recursive method to do that
            Stack<Integer> stack = new Stack();
            stack.add(0);
            int pre = -1;
            while(!stack.empty()){
                int cur = stack.peek();
         
                if(left[cur] != -1){
                    stack.add(left[cur]);
                }
                else{
                    cur = stack.pop();
                    result.add(key[cur]);
                    while(right[cur] == - 1 && !stack.empty()){
                        cur = stack.pop();
                        result.add(key[cur]);
                    }
                    if(right[cur]!=-1){
                        stack.add(right[cur]);
                    }
                    
                }
            }
            return result;
        }
                

        List<Integer> preOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
                        
            Stack<Integer> stack = new Stack();
            stack.add(0);
            int pre = -1;
            while(!stack.empty()){
                int cur = stack.pop(), leftChild = left[cur], rightChild = right[cur];  //追踪当前节点
                result.add(key[cur]);
                if(pre != -1 && (pre == left[cur] || pre == right[cur])){
                    cur = stack.pop();
                    result.add(key[cur]);
                    pre = cur;
                }
                
                if(rightChild != -1){
                    stack.add(rightChild);
                }
                if(leftChild != -1){
                    stack.add(leftChild);
                }

                
            }
            return result;
        }
        
        

        List<Integer> postOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Finish the implementation
            // You may need to add a new recursive method to do that
            Stack<Integer> stack = new Stack();
            stack.add(0);
            int pre = -1;
            while(!stack.empty()){
                int cur = stack.peek(), leftChild = left[cur], rightChild = right[cur];  //追踪当前节点
                if(leftChild == -1 && rightChild == -1 || pre != -1 && (pre == left[cur] || pre == right[cur])){
                    cur = stack.pop();
                    result.add(key[cur]);
                    pre = cur;
                } else{
                    if(rightChild != -1){
                        stack.add(rightChild);
                    }
                    if(leftChild != -1){
                        stack.add(leftChild);
                    }
                }
            }
            return result;
        }
    }
    
    public void test(){
            TreeOrders tree = new TreeOrders();
            int[] k = {0,10,20,30,40,50,60,70,80,90};
            int[] l = {7,-1,-1,8,3,-1,1,5,-1,-1};
            int[] r = {2,-1,6,9,-1,-1,-1,4,-1,-1};
            tree.n = 10;
            tree.key = k;
            tree.left = l;
            tree.right = r;
            print(tree.inOrder());
            print(tree.preOrder());
            print(tree.postOrder());
        }

    static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x) {
        for (Integer a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read();
        print(tree.inOrder());
        print(tree.preOrder());
        print(tree.postOrder());
    }
}

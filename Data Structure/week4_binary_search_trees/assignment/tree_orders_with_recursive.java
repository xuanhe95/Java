import java.util.*;
import java.io.*;

public class tree_orders_with_recursive {
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
            List<Integer> result = new ArrayList<Integer>();
            // Finish the implementation
            // You may need to add a new recursive method to do that
            result = inOrderRecursive(0);
            return result;
        }
        
        List<Integer> inOrderRecursive(int i){
            if(i == -1){
                List<Integer> result = new ArrayList<Integer>();
                return result;
            }
            int data = key[i];
            int leftChild = left[i];
            int rightChild = right[i];
            List<Integer> result = new ArrayList<Integer>();
            if(leftChild == -1 && rightChild == -1){
                result.add(data);
                return result;
            }
            // Finish the implementation
            // You may need to add a new recursive method to do that
            List<Integer> leftResult = inOrderRecursive(leftChild);
            List<Integer> rightResult = inOrderRecursive(rightChild);
            if(leftChild != -1){
                result = leftResult;
                result.add(data);
                if(rightChild != -1){
                    result.addAll(rightResult);
                }
                return result;
            } else{
                result.add(data);
                result.addAll(rightResult);
                return result;
            }
        }

        List<Integer> preOrder() {
            List<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            result = preOrderRecursive(0);            
            return result;
        }
        
        List<Integer> preOrderRecursive(int i){
            if(i == -1){
                List<Integer> result = new ArrayList<Integer>();
                return result;
            }
            int data = key[i];
            int leftChild = left[i];
            int rightChild = right[i];
            ArrayList<Integer> result = new ArrayList<Integer>();
            if(leftChild == -1 && rightChild == -1){
                result.add(data);
                return result;
            }
            // Finish the implementation
            // You may need to add a new recursive method to do that
            List<Integer> leftResult = preOrderRecursive(leftChild);
            List<Integer> rightResult = preOrderRecursive(rightChild);
            
            if(leftChild != -1){
                result.add(data);
                result.addAll(leftResult);
                if(rightChild != -1){
                    result.addAll(rightResult);
                }
                return result;
            } else{
                result.add(data);
                result.addAll(rightResult);
                return result;
            }
        }
        
        

        List<Integer> postOrder() {
            List<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            result = postOrderRecursive(0);            
            return result;
        }
        
        List<Integer> postOrderRecursive(int i){
            if(i == -1){
                List<Integer> result = new ArrayList<Integer>();
                return result;
            }
            int data = key[i];
            int leftChild = left[i];
            int rightChild = right[i];
            List<Integer> result = new ArrayList<Integer>();
            if(leftChild == -1 && rightChild == -1){
                result.add(data);
                return result;
            }
            // Finish the implementation
            // You may need to add a new recursive method to do that
            List<Integer> leftResult = postOrderRecursive(leftChild);
            List<Integer> rightResult = postOrderRecursive(rightChild);
            
            if(leftChild != -1){
                result = leftResult;
                if(rightChild != -1){
                    result.addAll(rightResult);
                }
                result.add(data);
                return result;
            } else{
                result.addAll(rightResult);
                result.add(data);
                return result;
            }
        }
    }

    static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders_with_recursive().run();
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

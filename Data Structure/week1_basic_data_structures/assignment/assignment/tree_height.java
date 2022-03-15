import java.util.*;
import java.io.*;

public class tree_height {
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

    public class TreeHeight {
        int n;
        int parent[];
        Node[] nodes;
        int root;
        
        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
           
        }

        int computeHeight() {
                        // Replace this code with a faster implementation
            int maxHeight = 0;
            for (int vertex = 0; vertex < n; vertex++) {
                int height = 0;
                for (int i = vertex; i != -1; i = parent[i])
                    height++;
                maxHeight = Math.max(maxHeight, height);
            }
            return maxHeight;
        }
        
        void buildTree(){   //根据输入数值创建树
            nodes = new Node[n];
            root = 0;
            
            for(int i=0;i<n;i++){
                nodes[i] = new Node(parent[i]);
            }
            
            for(int i=0;i<n;i++){
                int parentIndex = parent[i];
                if(parentIndex == -1){
                    root = i;
                }
                else{
                    nodes[parentIndex].addChild(nodes[i]);
                }
            }

        }
        
        
        
        int computeHeightFast(){
            Queue<Node> q = new LinkedList<Node>();

            int count = 0;
            int countDown = 0;  //计数器，为0时队伍里的变为下一层
            int nextCountDown = 0;      
            q.add(nodes[root]);
            while(q.size()!=0){
                Node curNode = q.poll();

                if(curNode.degree !=0){
                    for(int i=0;i<curNode.degree;i++){
                        q.add(curNode.children.get(i));
                    }
                    nextCountDown += curNode.degree;    //记录该层的所有子项目的数量
                }
                 if(countDown==0){   //当这一层都被挤出时，树深度+1
                    countDown = nextCountDown; //被挤入队列的数量
                    nextCountDown = 0;
                    count++;

                }
                countDown--;
            }
            return count;
        }
     
    }
    
    
    
    class Node{
        int data;
        ArrayList<Node> children;
        int degree;

        Node(int item){
            data = item;
            children = new ArrayList<Node>();
            degree = 0;
        }
        
        void addChild(Node child){
            children.add(child);
            degree++;
        }
    }

    static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        tree.buildTree();
        System.out.println(tree.computeHeightFast());
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<Swap>();
        // The following naive implementation just sorts 
        // the given sequence using selection sort algorithm
        // and saves the resulting sequence of swaps.
        // This turns the given array into a heap, 
        // but in the worst case gives a quadratic number of swaps.
        //
        // TODO: replace by a more efficient implementation
        for (int i = 0; i < data.length; ++i) {
            for (int j = i + 1; j < data.length; ++j) {
                if (data[i] > data[j]) {
                swaps.add(new Swap(i, j));
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                }
            }
        }
    }
 
    
    private void generateSwapsFast(){
        swaps = new ArrayList<Swap>();
        for(int cur=data.length/2-1;cur>=0;cur--){ //最后的非叶子节点开始遍历
            int parent = cur;
            while(parent <= data.length/2-1){
                int left = 2*parent+1;
                int right = 2*parent+2;
                if(right > data.length-1){
                    right = left;
                }
                
                if(data[parent]>data[right] && data[right] < data[left]){
                    swaps.add(new Swap(right,parent));
                    int temp = data[parent];
                    data[parent] = data[right];
                    data[right] = temp;
                    parent = right;
                }
                else if(data[parent]>data[left]){
                    swaps.add(new Swap(left,parent));
                    int temp = data[parent];
                    data[parent] = data[left];
                    data[left] = temp;
                    parent = left;
                }
                else{
                    break;
                }
            }
        }
        
    }
    
    public void test(){
        int[] k = {75,57,48,40,19,34,38,11,6,13,9,7};
        //data = k;
        //generateSwapsFast();
        //System.out.println(swaps.size());
        for (Swap swap : swaps) {
          System.out.println(swap.index1 + " " + swap.index2);
        }
        System.out.println(Arrays.toString(data));
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwapsFast();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

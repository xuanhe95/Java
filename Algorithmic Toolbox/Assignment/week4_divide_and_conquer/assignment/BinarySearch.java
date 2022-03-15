import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length;
        //write your code here
        int mid = 0;
        if(a.length == 0){
            return -1;
        }
        else{
            mid = a.length / 2;
        }
        if(a[mid] == x){
            int[] m = Arrays.copyOfRange(a,left,mid);
            return mid;
        }
        else if(a[mid] > x){
            int[] m = Arrays.copyOfRange(a,left,mid);
            return binarySearch(m,x);
        }
        else if(a[mid] < x){
            int[] m = Arrays.copyOfRange(a,mid+1,right);
            int result = binarySearch(m,x);
            if(result == -1){
                return -1;
            }
            else{
                return result+mid+1;
            }
        }

        return -1;
    }
    
    public void test(){
        int[] a = {1,3,4,8,6,7,8,9,10,99,100};
        int x = 99;
        System.out.println(binarySearch(a,x));
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(linearSearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

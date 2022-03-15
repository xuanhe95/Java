import java.io.*;
import java.util.*;

public class BinarySearchWithDuplicates {

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
            if(binarySearch(m,x)!=-1){  //如果左侧还存在key则继续搜索左侧
                return binarySearch(m,x);
            }
            return mid;
        }
        else if(a[mid] > x){
            int[] m = Arrays.copyOfRange(a,left,mid);
            return binarySearch(m,x);
        }
        else if(a[mid] < x){
            int[] m = Arrays.copyOfRange(a,mid+1,right);
            if(binarySearch(m,x)==-1){
                return -1;
            }
            else{
                return binarySearch(m,x)+mid+1;
            }
        }

        return -1;
    }
    
    public void test(){
        int[] a = {2,4,4,4,7,7,9};
        int x = 7;
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

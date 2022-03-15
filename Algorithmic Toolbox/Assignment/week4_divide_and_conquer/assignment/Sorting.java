import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        //write your code here
        int pivot = a[l];
        int m1 = l;

        for(int i = l+1;i<=r;i++){
            if(a[i] < pivot){
                m1++; //先移动指针
                int temp = a[i];  //后交换指针元素
                a[i] = a[m1];
                a[m1] = temp;
            }
        }
        int m2 = m1;    //创建新的指针，区分等于和大于的界限
        for(int i = m1+1;i<=r;i++){
            if(a[i] == pivot){
                m2++;
                int temp = a[i];
                a[i] = a[m2];
                a[m2] = temp;
            }
        }
      
        m2++;

        int temp = a[l];  //交换指针元素
        a[l] = a[m1];
        a[m1] = temp;
       


        int[] m = {m1, m2};   //m1指向不等于pivot的最大元素，m2指向不等于pivot的最小元素
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        int m1 = m[0];
        int m2 = m[1];
        randomizedQuickSort(a, l, m1);
        randomizedQuickSort(a, m2, r);
    }
    
    public void test(){
        int[] a = {2,9,2,3,9};
        randomizedQuickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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


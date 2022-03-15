import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        int mid = (left + right - 1) / 2;
        int majorL = getMajorityElement(a,left,mid+1);
        int majorR = getMajorityElement(a,mid+1,right);
        return merge(a,majorL,majorR,left,right);
    }
    
    private static int merge(int[] a,int majorL,int majorR,int left,int right){
        int countL=0;
        int countR=0;
        for(int i=left;i<right;i++){    //计算major总数
            if(a[i] == majorL){
                countL+=1;
            }
            else if(a[i] == majorR){
                countR+=1;
            }
        }
        if(countL*2 > right-left){
            return majorL;
        }
        else if(countR*2 > right-left){
            return majorR;
        }
        else{
            return -1;
        }
    }
    
    public void test(){
        int[] a = {21,5,5,13,5,22,5,5,5,25};
        System.out.println(getMajorityElement(a,0,a.length));
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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


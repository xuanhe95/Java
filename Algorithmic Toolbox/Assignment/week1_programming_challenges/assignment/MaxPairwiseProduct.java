import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;
        int maxIndex1 = 0;
        int maxIndex2 = 0;

        for(int i = 1; i < n; i++) {
            if (numbers[maxIndex1] < numbers[i]) {
                maxIndex1 = i;
            }
        }
        if(maxIndex1 == 0){
            maxIndex2 = 1;
        }
        for(int i = 0; i < n; i++) {
            if(numbers[maxIndex2] <= numbers[i] && i != maxIndex1){
                maxIndex2 = i;
            } 
        }
        
        long num1 = numbers[maxIndex1];
        long num2 = numbers[maxIndex2];
        max_product = num1 * num2;
        return max_product;
    }
    
    public void test(){
        int[] numbers = {100000,900000,3,5,12,900000};
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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

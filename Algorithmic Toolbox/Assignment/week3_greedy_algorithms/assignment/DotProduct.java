import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        long result = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = a.length-1; i >= 0; i--) {
            result += (long)a[i] * (long)b[i];
        }
        return result;
    }
    
    public void test(){
        int[] a = {1,3,-5};
        int[] b = {-2,4,1};
        System.out.println(maxDotProduct(a,b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}


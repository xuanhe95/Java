import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int m[][] = new int[a.length+1][b.length+1];
        for(int i=0;i<=a.length;i++){
            m[i][0]=0;
        }
        for(int i=0;i<=b.length;i++){
            m[0][i]=0;
        }
        
        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                if(a[i-1]==b[j-1]){
                    int u = m[i-1][j-1]+1;
                    int v = m[i-1][j];
                    int w = m[i][j-1];
                    int z = Math.max(u,Math.max(v,w));
                    m[i][j] = z;

                }
                else{
                    int u = m[i-1][j-1];
                    int v = m[i-1][j];
                    int w = m[i][j-1];
                    
                    int z = Math.max(u,Math.max(v,w));
                    m[i][j] = z;
                }

            }
        
        }        
        return m[a.length][b.length];
    }
    public void test(){
        int[] a = {2,7,8,3};
        int[] b = {5,2,8,7};
        System.out.println(lcs2(a, b));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(lcs2(a, b));
    }
}


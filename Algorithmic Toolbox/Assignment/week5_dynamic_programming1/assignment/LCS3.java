import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int m[][][] = new int[a.length+1][b.length+1][c.length+1];
        for(int i=0;i<=a.length;i++){
            m[i][0][0]=0;
        }
        for(int i=0;i<=b.length;i++){
            m[0][i][0]=0;
        }
        for(int i=0;i<=c.length;i++){
            m[0][0][i]=0;
        }
        
        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                for(int k=1;k<=c.length;k++){
                    if(a[i-1]==b[j-1] && a[i-1]==c[k-1]){
                        int m1 = m[i-1][j-1][k-1]+1;
                        int m2 = m[i][j-1][k-1];
                        int m3 = m[i-1][j][k-1];
                        int m4 = m[i-1][j-1][k-1];
                        int m5 = m[i][j][k-1];
                        int m6 = m[i][j-1][k];
                        int m7 = m[i-1][j][k];
                        int z1 = Math.max(m1,Math.max(m2,m3));
                        int z2 = Math.max(m4,Math.max(m5,Math.max(m6,m7)));
                        int z3 = Math.max(z1,z2);
                        m[i][j][k] = z3;
                    }
                    else{
                        int m1 = m[i-1][j-1][k-1];
                        int m2 = m[i][j-1][k-1];
                        int m3 = m[i-1][j][k-1];
                        int m4 = m[i-1][j-1][k-1];
                        int m5 = m[i][j][k-1];
                        int m6 = m[i][j-1][k];
                        int m7 = m[i-1][j][k];
                        int z1 = Math.max(m1,Math.max(m2,m3));
                        int z2 = Math.max(m4,Math.max(m5,Math.max(m6,m7)));
                        int z3 = Math.max(z1,z2);
                        m[i][j][k] = z3;
                    }
                }
            }
        }        
        return m[a.length][b.length][c.length];
    }
    
    public void test(){
        int[] a = {8,3,7};
        int[] b = {8,2,1,3,8,10,7};
        int[] c = {6,8,3,1,4,7};
        System.out.println(lcs3(a,b,c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}


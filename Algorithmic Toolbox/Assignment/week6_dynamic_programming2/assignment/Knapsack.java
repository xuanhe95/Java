import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here

        int[][] m = new int[W+1][w.length+1];
        for(int i=0;i<W+1;i++){
            m[i][0]=0;
        }
        for(int j=0;j<w.length;j++){
            m[0][j]=0;
        }


        for(int i=1;i<=W;i++){
            for(int j=1;j<=w.length;j++){
                int bar = w[j-1];
                m[i][j]= m[i][j-1];
                if(bar<=i){
                    int val = m[i-bar][j-1]+bar;
                    if(m[i][j] < val){
                        m[i][j]=val;
                    }
                }
            }
        }
        //print(m);
        return m[W][w.length];
    }
    
    private static void print(int[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+"    ");
            }
            System.out.println("  ");
        }
    }
    
    public void test(){
        int W = 20;
        int[] w = {5,7,12,18};
        System.out.println(optimalWeight(W,w));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}


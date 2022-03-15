import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        if(sum % 3!=0){ //和不能整除3则返回0
            return 0;
        }
        int partition = sum / 3;
        
        int[][][] m = new int[A.length+1][partition+1][partition+1];
        //创建矩阵，高度为两组数选择的元素，宽度和长度为两组数加和
        //高度n是所取的数字，因此最少取2，最多取到n-1!!!
        //如果n取到1，由于早计算一层，结果会错误。
        
        for(int n=2;n<=A.length;n++){
            for(int i=1;i<=partition;i++){
                for(int j=1;j<=partition;j++){
                    int k = A[n-1];
                    m[n][i][j] = m[n-1][i][j];
                    if(k<=i && k<=j){   //从i-k,j-k转移而来
                        int a = m[n][i-k][j-k];
                        int b = m[n-1][i-k][j-k]+k;
                        //当n-1,i-k,j-k同时成立时，可以取k
                        
                        int result = Math.max(a,b);
                        if(result > m[n][i][j]){
                            m[n][i][j] = result;
                        }
                    }
                    else if(k<=i){
                        int a = m[n][i-k][j];
                        int b = m[n-1][i-k][j];

                        int result = Math.max(a,b);
                        if(result > m[n][i][j]){
                            m[n][i][j] = result;
                        }
                    }
                    else if(k<=j){
                        int a = m[n][i][j-k];
                        int b = m[n-1][i][j-k];
                        
                        int result = Math.max(a,b);
                        if(result > m[n][i][j]){
                            m[n][i][j] = result;
                        }
                    }
                    
                }
            
            }
        
        }
        
        print(m,A.length-1);
        
        if(m[A.length-1][partition][partition] == partition){
            return 1;
        }
        return 0;
    }
    
        
    private static void print(int[][][] m,int n){
        for(int i=0;i<m[0].length;i++){
            for(int j=0;j<m[0][0].length;j++){
                System.out.print(m[n][i][j]+"    ");
            }
            System.out.println("  ");
        }
    }
    
    public void test(){
        int[] A = {3,4,5,9};
        System.out.println(partition3(A));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}


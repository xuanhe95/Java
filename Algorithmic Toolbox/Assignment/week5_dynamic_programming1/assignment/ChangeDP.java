import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        int[] coins = {1,3,4};
        int[] minNumCoins = new int[m+1];
        minNumCoins[0] = 0;
        for(int i=1;i<=m;i++){
            minNumCoins[i] = m+100;
            for(int coin:coins){
                if(coin <= i){
                    int numCoins = minNumCoins[i-coin]+1;
                    if(numCoins<minNumCoins[i]){
                        minNumCoins[i] = numCoins;
                    }
                }
            }
        }
        return minNumCoins[m];
    }
    
    
    public void test(){
        int m = 125;
        System.out.println(getChange(m));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


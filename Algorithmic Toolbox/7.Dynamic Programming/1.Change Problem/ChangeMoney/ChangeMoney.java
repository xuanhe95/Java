
/**
 * 在这里给出对类 ChangeMoney 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class ChangeMoney {
    public int changeMoney(int money,int[] coins){
        if(money == 0){ //剩余金钱等于零时需要0个硬币
            return 0;
        }
        int best = -1;
        for(int coin:coins){    //逐一取出每个硬币进行递归
            int nextTry = 0;
            if(coin <= money){  //只有在硬币小于剩余金钱时执行递归
                nextTry = changeMoney(money - coin,coins);  //暂存子递归中的best
            }
            if(best < 0 || best > nextTry+1){  //当当前递归中的best大于子递归的best+1时，子递归此数+1更新为新的best
                best = nextTry + 1;
            }
        }
        return best;
    }
    
    public void test(){
        int[] coins = new int[]{1,8,10};
        int money = 53;
        System.out.println(changeMoney(money,coins));
    }
}


/**
 * 在这里给出对类 KnapsackRepetition 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class KnapsackWithoutRepetition {
    public int knapsack(int capacity,int[][] items){
        int[][] value = new int[capacity+1][items.length];
        for(int i=0;i<capacity+1;i++){
            value[i][0] = 0;
        }
        for(int j=0;j<items.length;j++){
            value[0][j] = 0;
        }
        for(int w=1;w <= capacity;w++){
            for(int k=1;k < items.length;k++){
                if(items[k][0] <= w){
                    int val = value[w - items[k][0]][k-1];
                    int val2 = value[w - items[k][0]][k-1] + items[k][1];
                    if(val2 > val){
                        val = val2;
                    }
                    if(val > value[w][k]){
                        value[w][k] = val;
                    }
                }
            }
        }
        return value[capacity][items.length-1];
    }
    
    public void test(){
        int[][] items = new int[][] {{6,30},{3,14},{4,16},{2,9}};   //数组前项为物品占用的空间，后项为价值
        int value = knapsack(10,items);
        System.out.println(value);
    }
}


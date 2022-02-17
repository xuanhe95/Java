
/**
 * 在这里给出对类 KnapsackRecursive 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class KnapsackRecursive {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int knapsack(int capacity,int[][] items){
        if(map.containsKey(capacity)){
           return map.get(capacity); 
        }
        if(capacity == 0){
            return 0;
        }
        int valMax = 0;
        for(int[] item:items){
            if(item[0] <= capacity){
                int val = knapsack(capacity - item[0],items) + item[1];
                if(val > valMax){
                    valMax = val;
                }
            }
        }
        map.put(capacity,valMax);
        return map.get(capacity);
    }
    
    
    public void test(){
        int[][] items = new int[][] {{6,30},{3,14},{4,16},{2,9}};   //数组前项为物品占用的空间，后项为价值
        int value = knapsack(10,items);
        System.out.println(value);
    }
}

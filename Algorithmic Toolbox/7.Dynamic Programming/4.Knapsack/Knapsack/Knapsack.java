
/**
 * 在这里给出对类 Knapsack 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class Knapsack {
    public int[] value;
    public Knapsack(int capacity){
        value = new int[capacity+1];    //创建一个背包内各个空间最大价值的列表
    }
    public int knapsack(int capacity,int[][] items){
        value[0] = 0;   //背包的第0个空间的最大价值为0
        for(int w=1;w<=capacity;w++){   //遍历背包的每一个空间
            value[w] = 0;   //初始化背包的每一个空间，最大价值为0
            for(int[] item : items){    //遍历每个物品
                if(item[0] <= w){   //如果物品的占用空间小于当前背包的空间
                    int val = value[w - item[0]] + item[1]; //则当前价值等于（当前空间-物品占用空间）+物品价值
                    if(val > value[w]){ //当当前价值大于现有该空间的最大价值时，更新该空间的最大价值
                        value[w] = val;
                    }
                }
            }
        }
        return value[capacity];
    }
    public void test(){
        int[][] items = new int[][] {{6,30},{3,14},{4,16},{2,9}};   //数组前项为物品占用的空间，后项为价值
        int value = knapsack(10,items);
        System.out.println(value);
    }
}

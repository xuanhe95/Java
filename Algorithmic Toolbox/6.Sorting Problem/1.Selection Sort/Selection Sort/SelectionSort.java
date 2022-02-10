
/**
 * 在这里给出对类 SelectionSort 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class SelectionSort {
    private ArrayList<Integer> array;
    public SelectionSort(String s){
        array = new ArrayList<Integer>();
        String[] list = s.split(",");
        for(int i=0;i<list.length;i++){ //添加数字入组
            Integer num = Integer.parseInt(list[i]);
            array.add(i,num);
        }
    }
    
    public ArrayList<Integer> sort(){
        for(int i=0;i<array.size();i++){    //将最小值与左界i交换
            int minNum = array.get(i);
            int minIndex = i;   //初始化最小左界
            for(int k=i+1;k<array.size();k++){    //找到最小值，从左界开始查询
                int curNum = array.get(k);
                if (curNum < minNum){
                    minNum = curNum;
                    minIndex = k;
                }
            }
            int temp = array.get(i);
            array.set(i,minNum);
            array.set(minIndex,temp);
        }
        return array;
    }
    
}

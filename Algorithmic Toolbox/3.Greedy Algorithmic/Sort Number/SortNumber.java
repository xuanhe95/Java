
/**
 * 在这里给出对类 LargestNumer 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */

import java.util.*;

public class SortNumber {
    private ArrayList<Integer> array;
    
    public SortNumber(String s){
        array = new ArrayList<Integer>();
        
        String[] list = s.split(",");
        for(int i=0;i<list.length;i++){
            Integer num = Integer.parseInt(list[i]);
            array.add(i,num);
        }
    }

    private int getMaxIndex(ArrayList<Integer> array){
        int max = array.get(0);
        int maxIndex = 0;
        for(int i=0;i<array.size();i++){
            if(array.get(i) > max){
                max = array.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public ArrayList<Integer> sortArray(){
        ArrayList<Integer> sortedArray = new ArrayList<Integer>();
        int length = array.size();
        
        for(int i=0;i<length;i++){
            int maxIndex = getMaxIndex(array);
            sortedArray.add(array.get(maxIndex));
            array.remove(maxIndex);
        }
        return sortedArray;
    }
    
}

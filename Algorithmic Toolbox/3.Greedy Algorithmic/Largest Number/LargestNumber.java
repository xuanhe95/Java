
/**
 * 在这里给出对类 LargestNumber 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class LargestNumber {
    private ArrayList<Integer> array;
    public LargestNumber(String s){
        array = new ArrayList<Integer>();
        String[] list = s.split(",");
        for(int i=0;i<list.length;i++){ //添加数字入组
            Integer num = Integer.parseInt(list[i]);
            array.add(i,num);
        }
    }
    
    private int getMaxIndex(ArrayList<Integer> array){
        String maxString = array.get(0).toString();
        int index = 0;
        for(int i=0;i<array.size();i++){
            String curInt = array.get(i).toString();
            int length = Math.min(maxString.length(),curInt.length());
            for(int k=0;k<length;k++){
                if(maxString.charAt(k) > curInt.charAt(k)){ //同位数字大于无需替换
                    break;
                }
                else if(maxString.charAt(k) < curInt.charAt(k)){    //同位数字小于则替换最大值
                    maxString = curInt;
                    index = i;
                    continue;
                }
                if(curInt.length() > maxString.length()){ //计算数字头部与尾部的大小
                    int startDigit = curInt.charAt(0);
                    int endDigit = curInt.charAt(curInt.length()-1);
                    if(startDigit <endDigit){
                        maxString = curInt;
                        index = i;
                    }
                }
            }
        }
        return index;
    }
    
    public ArrayList<Integer> sortArray(){
        ArrayList<Integer> sortedArray = new ArrayList<Integer>();
        int length = array.size();
        for(int i=0;i<length;i++){  //添加最大数字，并在原列表删除原有数字
            int maxIndex = getMaxIndex(array);
            sortedArray.add(array.get(maxIndex));
            array.remove(maxIndex);
        }
        return sortedArray;
    }
  
    
    
}

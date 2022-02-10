
/**
 * 在这里给出对类 BinarySearch 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class BinarySearch {
    private ArrayList<Integer> array;
    public BinarySearch(String s){
        array = new ArrayList<Integer>();
        String[] list = s.split(",");
        for(int i=0;i<list.length;i++){ //添加数字入组
            Integer num = Integer.parseInt(list[i]);
            array.add(i,num);
        }
        Collections.sort(array);   //排序
        System.out.println(array);
    }
    
    public int searchKey(int key,int left,int right){
        if(right < left){
            return -1;
        }
        int mid = left + (right - left)/2;
        if(array.get(mid).equals(key)){
            return mid;
        }
        else if(array.get(mid) > key){
            return searchKey(key,left,mid-1);   //在小边查找
        }
        else{
            return searchKey(key,mid+1,right);    //在大边查找
        }
    }
    
    public int searchKey(int key){
        int left = 0;
        int right = array.size();
        if(right < left){
            return -1;
        }
        int mid = left + (right - left)/2;
        if(array.get(mid).equals(key)){
            return mid;
        }
        else if(array.get(mid) > key){
            return searchKey(key,left,mid-1);   //在小边查找
        }
        else{
            return searchKey(key,mid+1,right);    //在大边查找
        }
    }
   
}

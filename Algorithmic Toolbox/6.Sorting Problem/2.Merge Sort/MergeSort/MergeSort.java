
/**
 * 在这里给出对类 MergeSort 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class MergeSort {
    public ArrayList<Integer> mergeSort(String s){
        ArrayList<Integer> array = new ArrayList<Integer>();
        String[] list = s.split(",");
        for(int i=0;i<list.length;i++){ //添加数字入组
            Integer num = Integer.parseInt(list[i]);
            array.add(i,num);
        }
        return array;
    }
    
    public ArrayList<Integer> merge(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> sorted = new ArrayList<Integer>(); 
        while(a.size()!=0 && b.size()!=0){  //比较两个列表内的元素并排序，原本两个列表是有序的
            int curA = a.get(0);
            int curB = b.get(0);
            if(curA < curB){
                sorted.add(curA);
                a.remove(0);
            }
            else{
                sorted.add(curB);
                b.remove(0);
            }
        }
        if(a.size()==0){
            sorted.addAll(b);
        }
        else{
            sorted.addAll(a);
        }
        return sorted;
    }
    
    public ArrayList<Integer> mergeSort(ArrayList<Integer> array){
        if(array.size()==1){    //分为独立个体后直接返回
            return array;
        }
        int mid = array.size()/2;   //将列表一分为二
        ArrayList<Integer> a = new ArrayList(array.subList(0,mid));
        ArrayList<Integer> b = new ArrayList<Integer>(array.subList(mid,array.size()));
        ArrayList<Integer> sortedA = mergeSort(a);  //递归子问题
        ArrayList<Integer> sortedB = mergeSort(b);
        return merge(sortedA,sortedB);  //返回子问题的合并项
    }
}

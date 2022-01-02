
/**
 * 在这里给出对类 QuickSort 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class QuickSort {
    public static List<Integer> sort(List<Integer> lst,int left,int right){
         if(left>=right){return lst;}//递归出口
         int pivot=lst.get(left);//左界限作为pivot
         int i=left;
         int j=right;
         while(i<j){
             while(lst.get(j)>=pivot && i<j){j--;}//j从右指左
             while(lst.get(i)<=pivot && i<j){i++;}//i从左至右
             if(i<j){
                swap(lst,lst.get(i),lst.get(j),i,j);}//交换符合要求的lst[i]和lst[j]
            }
            swap(lst,lst.get(left),lst.get(i),left,i);//交换pivot和i
            sort(lst,left,i);//向左侧递归
            sort(lst,i+1,right);//向右侧递归
            return lst;
   
    }
    
        public static List<Integer> swap(List<Integer> lst,int item1,int item2,int idx1,int idx2){
        lst.set(idx1,item2);
        lst.set(idx2,item1);
        return lst;
    }
    
    public void test(){
        List<Integer> lst1=new ArrayList();
        List<Integer> lst2=new ArrayList();
        List<Integer> lst3=new ArrayList();
        lst1.addAll(Arrays.asList(2,6,5,4,78,49,95,1,3,150,8,9,10,32,220));
        lst2.addAll(Arrays.asList(54,2144,312,42,78,23,11,1,3,230,8,42,13,22,120));
        lst3.addAll(Arrays.asList(132,323,501,1,8,12,95,378,45449,595,11,23,1450,85,95,10,32,220));
        System.out.println(sort(lst1,0,lst1.size()-1));
        System.out.println(sort(lst2,0,lst2.size()-1));
        System.out.println(sort(lst3,0,lst3.size()-1));

    
    }
    
    public void testSwap(){
        List<Integer> lst=new ArrayList();
        lst.addAll(Arrays.asList(6,5,4,1,3,8,9,10));   
        System.out.println(swap(lst,6,5,0,1));
    }
    
}

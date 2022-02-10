
/**
 * 在这里给出对类 QuickSort 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class QuickSort {
    public int partition(int[] array,int left,int right){
        int pivot = array[left];
        int j = left;
        for(int i=left+1;i<array.length;i++){
            if(array[i] < pivot){
                j+=1;   //移动指针，增加前排数列的空间
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;    //将小于pivot的array[i]移动到前排数列里
            }
        }
        int temp = array[j];
        array[j] = pivot;
        array[left] = temp;
        return j;   //返回最终位置
    }
    public int[] quickSort(int[] array,int left,int right){
        if(left >= right){
            return array;
        }
        int finalPosition = partition(array,left,right);
        quickSort(array,left,finalPosition-1);
        quickSort(array,finalPosition+1,right);
        return array;
    }
    public void test(){
        int[] array = new int[]{7,5,8,4,921,1,5,3,4,5,2,5,65,34,92,35};
        System.out.println(Arrays.toString(quickSort(array,0,array.length-1)));
    }
}

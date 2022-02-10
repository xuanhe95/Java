
/**
 * 在这里给出对类 QuickSortArray 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class QuickSortArray {
    private int[] array;
    public QuickSortArray(int[] arrayInput){
        array = arrayInput;
    }
    public int partition(int left,int right){
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
    public void quickSort(int left,int right){
        if(left >= right){
            return;
        }
        int finalPosition = partition(left,right);
        quickSort(left,finalPosition-1);
        quickSort(finalPosition+1,right);
    }
    public int[] out(){
        return array;
    }
}

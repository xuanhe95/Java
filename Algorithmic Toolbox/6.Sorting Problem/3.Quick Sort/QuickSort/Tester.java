
/**
 * 在这里给出对类 Tester 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class Tester {
    public void test(){
        int[] array = new int[]{73,55,8,4,9231,1,5,3,4,5,2,5,65,34,92,35};
        QuickSortArray qs = new QuickSortArray(array);
        qs.quickSort(0,array.length);
        System.out.println(Arrays.toString(qs.out()));
    }
}

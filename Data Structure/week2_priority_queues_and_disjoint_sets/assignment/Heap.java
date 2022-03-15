
/**
 * 在这里给出对类 Heap 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class Heap {
    private long[] data;
    
    Heap(long[] items){
        data = items;
        heapify();
    }
    
    private int leftChild(int i){
        return 2 * i + 1;
    }
    private int rightChild(int i){
        return 2 * i + 2;
    }
    private int parentOf(int i){
        return (i + 1) / 2 - 1;
    }
    
    private int siftDown(int i){
        long parent = data[i];
        int position = i;

        while(leftChild(position) < data.length){
            int left = leftChild(position);
            int min = left;
            if(rightChild(position) < data.length){
                int right = rightChild(position);
                if(data[right] < data[left]){
                    min = right;
                }
            }
 
            if(data[position] > data[min]){
                data[position] = data[min];
                data[min] = parent;
                position = min;
            }
            else{
                break;
            }
        }
        return position;
    }
    
    public long pop(){
        long root = data[0];
        remove(0);
        return root;
    }
    
    public long getPeak(){
        return data[0];
    }
    
    public int remove(int i){
        if(i < data.length){
            int last = data.length - 1;
            long target = data[i];
            data[i] = data[last];
            data[last] = target;
            int position = siftDown(i);
            cutDown();
            return position;
        }
        else{
            return -1;
        }
    }
    
    private int siftUp(int i){
        int position = i;
        while(position > 0){
            long child = data[position];
            long parent = data[parentOf(position)];
            if(parent > child){
                data[position] = parent;
                data[parentOf(position)] = child;
                position = parentOf(position);
            }
            else{
                break;
            }
        }
        return position;
    }

    private int add(int item){
        buildUp(item);
        int position = siftUp(data.length-1);
        return position;
    }
    
    public long replace(long item){
        long root = data[0];
        data[0] = item;
        siftDown(0);
        return root;
    }
    
    
    private void cutDown(){
        long[] newData = new long[data.length-1];
        for(int i=0;i<data.length-1;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    
    private void buildUp(int item){
        long[] newData = new long[data.length+1];
        for(int i=0;i<data.length;i++){
            newData[i] = data[i];
        }
        newData[data.length] = item;
        data = newData;
    }
    
    private void heapify(){
        for(int i = parentOf(data.length-1); i >= 0;i--){
            siftDown(i);
        }
    }
    
    public void test(){
        long[] k = {5,4,3,2,1,4,6,7};
        data = k;
        heapify();
        System.out.println(Arrays.toString(data));

    }
    
}

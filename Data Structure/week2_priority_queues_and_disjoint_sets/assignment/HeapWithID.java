
/**
 * 在这里给出对类 Heap 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class HeapWithID {
    private long[] data;
    private int[] id;
    
    HeapWithID(long[] items){
        data = items;
        id = new int[items.length];
        for(int i = 0;i< items.length;i++){
            id[i] = i;
        }
        heapify();
    }
    
    HeapWithID(int size){
        data = new long[size];
        for(int i=0;i<size;i++){
            data[i] = 0;
        }
        id = new int[size];
        for(int i = 0;i< size;i++){
            id[i] = i;
        }
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
                if(data[right] == data[left]){
                    if(id[right] < id[left]){
                        min = right;
                    }
                    else{
                        min = left;
                    }
                    
                }
                else if(data[right] < data[left]){
                    min = right;
                }
            }
 
            if(data[position] >= data[min]){
                data[position] = data[min];
                data[min] = parent;
                int temp = id[position];
                id[position] = id[min];
                id[min] = temp;
                
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
    
    public int getPeakID(){
        return id[0];
    }
    
    public long replace(long item){
        long root = data[0];
        data[0] = item;
        siftDown(0);
        return root;
    }
    
    
    public int remove(int i){
        if(i < data.length){
            int last = data.length - 1;
            long target = data[i];
            data[i] = data[last];
            data[last] = target;
            
            int temp = id[i];
            id[i] = id[last];
            id[last] = id[i];
            
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
                int temp = id[position];
                id[position] = id[parentOf(position)];
                id[parentOf(position)] = temp;
                
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
    
    private void cutDown(){
        long[] newData = new long[data.length-1];
        for(int i=0;i<data.length-1;i++){
            newData[i] = data[i];
        }
        data = newData;
        
        int[] newID = new int[data.length-1];
        for(int i=0;i<data.length-1;i++){
            newID[i] = id[i];
        }
        id = newID;
    }
    
    private void buildUp(int item){
        long[] newData = new long[data.length+1];
        for(int i=0;i<data.length;i++){
            newData[i] = data[i];
        }
        newData[data.length] = item;
        data = newData;
        
        int[] newID = new int[data.length+1];
        for(int i=0;i<data.length;i++){
            newID[i] = id[i];
        }
        newID[data.length] = item; //Wrong
        id = newID;
        
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
        System.out.println("Data  " + Arrays.toString(data));
        System.out.println("ID    " + Arrays.toString(id));

    }
    
}


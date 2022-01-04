
/**
 * 在这里给出对类 QuickSortAssignment 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */

import edu.duke.*;
import java.util.*;
import java.lang.Math.*;

public class QuickSortAssignment {
    
    public static Integer[] swap(Integer[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
        return arr;
    }
    
    public static int choosePivot(Integer[] arr,int left,int right){
        int pi=left;
        return pi;
    }
    
    public static int choosePivotRight(Integer[] arr,int left,int right){
        int pi=right;
        return pi;
    }

    public static int findMedian(Integer[] arr,int left,int right){
        int length=right-left+1;
        int mid=0;
        if(length%2==0){mid=length/2-1+left;}
        else{mid=length/2+left;}
        int leftNum=arr[left];
        int midNum=arr[mid];
        int rightNum=arr[right];
        int maxi=Math.max(Math.max(leftNum,rightNum),midNum);
        int mini=Math.min(Math.min(leftNum,rightNum),midNum);
        if(leftNum!=maxi && leftNum!=mini){return left;}
        else if(midNum!=maxi && midNum!=mini){return mid;}
        else{return right;}
    }
    
    public static int partition(Integer[] arr,int left,int right,int pi){
       if(pi!=0){swap(arr,pi,left);}
       int pivot=arr[left];
       int i=left+1;
       for(int j=left+1;j<=right;j++){
            if (arr[j]<pivot){
            arr=swap(arr,i,j);
            i++;
            }
       }
       arr=swap(arr,left,i-1);
       return i-1;
    }
    
    public static int quickSortLeft(Integer[] arr,int left,int right){  
        if(left>=right){return 0;} 
        int pi=choosePivot(arr,left,right);
        int position=partition(arr,left,right,pi);
        int leftSide=quickSortLeft(arr,left,position-1);
        int rightSide=quickSortLeft(arr,position+1,right);
        return leftSide+rightSide+right-left;
    }
    
    public static int quickSortRight(Integer[] arr,int left,int right){ 
        if(left>=right){return 0;} 
        int pi=choosePivotRight(arr,left,right);
        int position=partition(arr,left,right,pi);
        int leftSide=quickSortRight(arr,left,position-1);
        int rightSide=quickSortRight(arr,position+1,right);
        return leftSide+rightSide+right-left;
    }
    
    public static int quickSortMedian(Integer[] arr,int left,int right){
        if(left>=right){return 0;} 
        int pi=findMedian(arr,left,right);
        int position=partition(arr,left,right,pi);
        int leftSide=quickSortMedian(arr,left,position-1);
        int rightSide=quickSortMedian(arr,position+1,right);
        return leftSide+rightSide+right-left;
    }

    public void testLeftCount(){
        FileResource fr=new FileResource();
        String text=fr.asString();
        List<Integer> lst=new ArrayList();
        String[] arrOfStr=text.split("\n");
        for(String numString:arrOfStr){
            int num=Integer.parseInt(numString);
            lst.add(num);
        }
        Integer[] arr=new Integer[lst.size()];
        lst.toArray(arr);
        int total=quickSortLeft(arr,0,lst.size()-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(total);
    }
    
    public void testRightCount(){
        FileResource fr=new FileResource();
        String text=fr.asString();
        List<Integer> lst=new ArrayList();
        String[] arrOfStr=text.split("\n");
        for(String numString:arrOfStr){
            int num=Integer.parseInt(numString);
            lst.add(num);
        }
        Integer[] arr=new Integer[lst.size()];
        lst.toArray(arr);
        int total=quickSortRight(arr,0,lst.size()-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(total);
    }
    
    public void testMedianCount(){
        FileResource fr=new FileResource();
        String text=fr.asString();
        List<Integer> lst=new ArrayList();
        String[] arrOfStr=text.split("\n");
        for(String numString:arrOfStr){
            int num=Integer.parseInt(numString);
            lst.add(num);
        }
        Integer[] arr=new Integer[lst.size()];
        lst.toArray(arr);
        int total=quickSortMedian(arr,0,lst.size()-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(total);
    }
    
    public void testAll(){
        FileResource fr=new FileResource();
        String text=fr.asString();
        List<Integer> lst=new ArrayList();
        String[] arrOfStr=text.split("\n");
        for(String numString:arrOfStr){
            int num=Integer.parseInt(numString);
            lst.add(num);
        }
        Integer[] arr1=new Integer[lst.size()];
        lst.toArray(arr1);
        int totalLeft=quickSortLeft(arr1,0,lst.size()-1);
        
        Integer[] arr2=new Integer[lst.size()];
        lst.toArray(arr2);        
        int totalRight=quickSortRight(arr2,0,lst.size()-1);
        
        Integer[] arr3=new Integer[lst.size()];
        lst.toArray(arr3);   
        int totalMedian=quickSortMedian(arr3,0,lst.size()-1);
        System.out.println(totalLeft+" "+totalRight+" "+totalMedian);
    }
          
}

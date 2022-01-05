
/**
 * 在这里给出对类 WordLengths 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */

import java.util.*;
import edu.duke.*;
public class WordLengths {
    public int[] countWordLengths(FileResource resource,int[] counts){
        int index=0;
        for(String word:resource.words()){
            StringBuilder sb=new StringBuilder(word);
            if (!Character.isLetter(sb.charAt(sb.length()-1))){
                sb.delete(sb.length()-2,sb.length()-1);
            }
            String wd=sb.toString();
            int len=wd.length();
            if(len>30){len=30;}
            counts[len]++;
            index++;
        }
        return counts;
    }
    
    public void testCountWordLengths(){
        FileResource fr=new FileResource();
        int[] counts=new int[31];
        int[] countArray=countWordLengths(fr,counts);
        
        String text=Arrays.toString(countArray);
        for(int i=0;i<countArray.length;i++){
            int num=countArray[i];
            if(num==0){continue;}
            System.out.println("Words with "+i+" characters' numbers is "+num);
        }
        System.out.println("The largest number's index is "+(indexOfMax(countArray)));
    }
    
    public int indexOfMax(int[] values){
        int large=0;
        int largeIdx=0;
        for(int i=0;i<values.length;i++){
            if(values[i]>large){
                largeIdx=i;
                large=values[i];
            }
        }
        return largeIdx;
    }
   
    

}

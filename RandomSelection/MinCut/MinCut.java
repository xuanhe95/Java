
/**
 * 在这里给出对类 MinCut 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;

public class MinCut {
    public void createArray(FileResource fr){
        ArrayList arr=new ArrayList();
        int accum=0;
        for(String line:fr.lines()){
            String[] words= line.split("\t");
            arr.add(words);
        }
        for(int i=0;i<arr.size();i++){
            List text=Arrays.asList(arr.get(i));
            System.out.println(text);
        }
    }
    

    public void test(){
        FileResource fr=new FileResource();
        createArray(fr);
        
    }
}

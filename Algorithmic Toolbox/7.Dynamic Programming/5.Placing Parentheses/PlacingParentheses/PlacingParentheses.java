
/**
 * 在这里给出对类 PlacingParentheses 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class PlacingParentheses {
    private int[] nums = {5,8,7,4,8,9};
    private String[] options = {"sub","add","mul","sub","add"};
    private HashMap<String,int[]> map = new HashMap<String,int[]>();
    public int placingParentheses(int start,int end){
        String key = Integer.toString(start)+Integer.toString(end);
        for(int s=0;s<=end-start;s++){  //限定i与j的差，由此来决定对角的遍历的顺序
            for(int i=start;i<=end-start-s;i++){
                int j=i+s;
                String curKey = Integer.toString(i)+Integer.toString(j);
                int[] minAndMax = minAndMax(i,j);   //计算i与j时的最小值与最大值
                int min = minAndMax[0];
                int max = minAndMax[1];
                if(!map.containsKey(curKey)){
                    map.put(curKey,minAndMax);
                }
                else if(map.get(curKey)[0] > min){
                    int[] curValue = {min,map.get(curKey)[1]};
                    map.put(curKey,curValue);
                }
                else if(map.get(curKey)[1] < max){
                    int[] curValue = {map.get(curKey)[0],max};
                    map.put(curKey,curValue);
                }
            }
        }
        int maxValue = Math.max(map.get(key)[0],map.get(key)[1]);
        return maxValue;
    }
    
    public int[] minAndMax(int start,int end){
        if(start == end){   //start=end时，返回整数自身
            int[] minAndMax = {nums[start],nums[end]};
            return minAndMax;
        }
        double min = 1/0.0;
        double max = -1/0.0;
        for(int mid=start;mid<end;mid++){   //遍历子问题，更新min和max
            int minFront = minAndMax(start,mid)[0]; 
            int maxFront = minAndMax(start,mid)[1];
            int minBack = minAndMax(mid+1,end)[0];
            int maxBack = minAndMax(mid+1,end)[1];
            String op = options[mid];
            if(op.equals("add")){
                int a = minFront + minBack;
                int b = minFront + maxBack;
                int c = maxFront + minBack;
                int d = maxFront + maxBack;
                min = Math.min(min,Math.min(a,Math.min(b,Math.min(c,d))));
                max = Math.max(max,Math.max(a,Math.max(b,Math.max(c,d))));
            }
            else if(op.equals("sub")){
                int a = minFront - minBack;
                int b = minFront - maxBack;
                int c = maxFront - minBack;
                int d = maxFront - maxBack;
                min = Math.min(min,Math.min(a,Math.min(b,Math.min(c,d))));
                max = Math.max(max,Math.max(a,Math.max(b,Math.max(c,d))));
            }
            else if(op.equals("mul")){
                int a = minFront * minBack;
                int b = minFront * maxBack;
                int c = maxFront * minBack;
                int d = maxFront * maxBack;
                min = Math.min(min,Math.min(a,Math.min(b,Math.min(c,d))));
                max = Math.max(max,Math.max(a,Math.max(b,Math.max(c,d))));
            }
        }
        int[] minAndMax = {(int)min,(int)max};
        return minAndMax;
    }
    
    public void test(){
        System.out.println(placingParentheses(0,5));
    }
}

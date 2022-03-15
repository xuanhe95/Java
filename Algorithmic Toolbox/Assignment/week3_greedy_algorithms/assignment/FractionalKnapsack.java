import java.util.Scanner;
import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        ArrayList<Double[]> items = new ArrayList<Double[]>(values.length);
        for(int i=0;i<values.length;i++){
            Double[] item = new Double[2];
            item[0] = (double)values[i] / weights[i];
            item[1] = (double)weights[i];
            items.add(item);
        }
        
        for(int i=0;i<values.length;i++){
            int maxIndex = 0;
            double maxValue = 0;
            for(int j=0;j<items.size();j++){
                if(items.get(j)[0]>maxValue){
                    maxValue=items.get(j)[0];
                    maxIndex=j;
                }
            }
            
            if (capacity >= items.get(maxIndex)[1]){
                capacity -= items.get(maxIndex)[1];
                value += items.get(maxIndex)[0] * items.get(maxIndex)[1];
            }
            else{
                value += capacity * items.get(maxIndex)[0];
                return value;
            }
            items.remove(maxIndex);
        }
        return value;
    }
    
    
    public void test(){
        int capacity = 50;
        int[] values = {60,100,120};
        int[] weights = {20,50,30};
        System.out.println(getOptimalValue(capacity,values,weights));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 

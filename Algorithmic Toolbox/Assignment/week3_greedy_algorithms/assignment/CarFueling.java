import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int refill = 0;
        int position = 0;
        int leftTank = tank;
        
        for(int i=0;i<stops.length;i++){
            int tempDist = stops[i] - position; //现有位置与车站的距离
            if(leftTank >= tempDist){   //如果可以走到
                leftTank -= tempDist;   //前进耗油
                position += tempDist;   //行驶距离
                int nextStop = 0;
                if(i==stops.length-1){
                    nextStop = dist;
                }
                else{
                    nextStop = stops[i+1];
                }
                if(leftTank >= nextStop-position){ //如果可以走到下一个车站
                    continue;   //继续
                }
                else{   //如果不能走到下一个车站
                    refill+=1;  //加油
                    leftTank=tank;
                    if(leftTank < nextStop-position){  //加油后不能走到下一个车站
                        return -1;
                    }
                    continue;
                }
            }
        }
        return refill;
    }
    
    public void test(){
        int dist = 10;
        int tank = 3;
        int[] stops = {1,2,5,9};
        System.out.println(computeMinRefills(dist,tank,stops));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}

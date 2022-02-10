
/**
 * 在这里给出对类 PrimitiveCalculator 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class PrimitiveCalculator {
    
    public int calculate(int solution){
        if(solution == 1){
            return 0;
        }
        int best = -1;
        if(solution%2==0){
            int nextTry = calculate(solution/2);
            if(best < 0 || best > nextTry+1){
                best = nextTry+1;
            }
        }
        if(solution%3==0){
            int nextTry = calculate(solution/3);
            if(best < 0 || best > nextTry+1){
                best = nextTry+1;
            }
        }
        if(solution-1 >= 1){
            int nextTry = calculate(solution-1);
            if(best < 0 || best > nextTry+1){
                best = nextTry+1;
            }
        }
        return best;
    }
    
    public void test(int num){
        int solution = num;
        System.out.println("To calculate "+ num + ",");
        System.out.println("The minimum operation time is " + calculate(solution) + ".");
    }
}

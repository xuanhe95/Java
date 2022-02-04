
/**
 * 在这里给出对类 EuclideanAlgorithm 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class EuclideanAlgorithm {
    public int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        int aR = a % b;
        return gcd(b,aR);
    }
    
    public void test(){
        System.out.println(gcd(10,4));
        System.out.println(gcd(357,234));
        System.out.println(gcd(3918848,1653264));
    }
}

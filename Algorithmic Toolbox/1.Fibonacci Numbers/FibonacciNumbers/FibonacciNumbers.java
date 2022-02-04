
/**
 * 在这里给出对类 FibonacciNumbers 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class FibonacciNumbers {
    public long fibo(int order){
        if(order == 0 || order == 1){
            return 1;
        }
        long[] a = new long[order];
        a[0] = 1;
        a[1] = 1;
        for(int i=2;i<order;i++){
            a[i] = a[i-1] + a[i-2];
        }
        
        return a[order-1];
    }
    
    public void test(){
        System.out.println(fibo(3));
        System.out.println(fibo(6));
        System.out.println(fibo(10));
        System.out.println(fibo(20));
        System.out.println(fibo(50));
        System.out.println(fibo(100));
    }
}

import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
                
        int[] table = new int[n+1];
        table[1] = 0;
        sequence.add(1);
        
        for(int i=2;i<=n;i++){
            table[i] = n+1;
            //遍历可选操作
            if(i-1>=0){
                int next = table[i-1]+1;
                if(next < table[i]){
                    table[i] = next;
                    if(sequence.size()>next){
                        sequence.set(next,i);
                    }
                    else{
                        sequence.add(i);
                    }
                    
                }
            }
            if(i%2==0){
                int next = table[i/2]+1;
                if(next < table[i]){
                    table[i] = next;
                    if(sequence.size()>next){
                        sequence.set(next,i);
                    }
                    else{
                        sequence.add(i);
                    }
                }
            }
            if(i%3==0){
                int next = table[i/3]+1;
                if(next < table[i]){
                    table[i] = next;
                    if(sequence.size()>next){
                        sequence.set(next,i);
                    }
                    else{
                        sequence.add(i);
                    }
                }
            }
        }
        System.out.println(table[n]);
        ArrayList<Integer> array = new ArrayList<Integer>(sequence.subList(0,table[n]+1));
        return array;
    }
    
    public void test(){
        int n=22;
        System.out.println(optimal_sequence(n));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}


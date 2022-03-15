import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        if (m == 0){
            return 0;
        }
        if (m >= 10){
            return getChange(m-10) + 1;
        }
        else if(m >= 5){
            return getChange(m-5) + 1;
        }
        else{
            return getChange(m-1) + 1;
        }

    }
    public void test(){
        System.out.println(getChange(5));
        System.out.println(getChange(154));
        System.out.println(getChange(12));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


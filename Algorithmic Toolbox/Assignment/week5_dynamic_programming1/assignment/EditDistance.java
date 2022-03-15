import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        //write your code here
        int[][] m = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++){
            m[i][0]=i;
        }
        for(int j=0;j<=t.length();j++){
            m[0][j]=j;
        }
    
    
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                char charS = s.charAt(i-1);
                char charT = t.charAt(j-1);
                if(charS == charT){
                    int a = m[i-1][j-1]+1;
                    int b = m[i-1][j]+1;
                    int c = m[i][j-1]+1;
                    int d = m[i-1][j-1];
                    m[i][j] = Math.min(a,Math.min(b,Math.min(c,d)));
                }
                else{
                    int a = m[i-1][j-1]+1;
                    int b = m[i-1][j]+1;
                    int c = m[i][j-1]+1;
                    m[i][j] = Math.min(a,Math.min(b,c));
                }
            }
        }
        return m[s.length()][t.length()];
    }
    public void test(){
        String s = "binzin";
        String t = "zincac";
        System.out.println(EditDistance(s,t));
    }
  
    private static void print(int[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+"    ");
            }
            System.out.println("  ");
        }
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}

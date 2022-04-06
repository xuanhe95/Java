//Rotate Array

class Solution {
    public void rotate(int[] nums, int k) {
        if (k != 0){
            int m = gcd(nums.length,k);
        
            for (int n = 0; n < m; n++ ) {
                int i = n + k;
                i %= nums.length;

                int temp = nums[n];
                while( true ){
                    int tempI = nums[i];
                    nums[i] = temp;
                    temp = tempI;
                
                    i += k;
                    i %= nums.length;
                
                    if (i == n){
                        nums[n] = temp;
                        break;
                    }
                }
            }
        }
    }
    
    private int gcd(int a, int b){
        int max = a;
        int min = b;
        if (max == min){
            return min;
        }
        
        if ( a < b ){
            max = b;
            min = a;
        }
        
        return gcd(max - min, min);
    }
}
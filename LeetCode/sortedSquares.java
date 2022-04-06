//Sqaures of a Sorted Array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length-1;
        int[] ans = new int[nums.length];
        
        while (left <= right) {
            if ( nums[left] < 0 ){
                if ( (-nums[left]) < nums[right] ){
                    ans[i] = nums[right] * nums[right];
                    right--;
                }
                else {
                    ans[i] = nums[left] * nums[left];
                    left++;
                }
                i--;
            }
            else{
                if ( nums[left] < nums[right] ){
                    ans[i] = nums[right] * nums[right];
                    right--;
                }
                else{
                    ans[i] = nums[left] * nums[left];
                    left++;
                }
                i--;
            }
        }
        return ans;
    }
}
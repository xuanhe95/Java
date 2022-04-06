//Two Sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] ans = new int[2];
        
        for (int i = 0; i < nums.length; i++){
            int result = target - nums[i];
            if ( map.containsKey(result) ){
                ans[0] = map.get(result);
                ans[1] = i;
                return ans;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
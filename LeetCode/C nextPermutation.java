//Next Permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int flag = 0;   //标记，如果没有下一个排列时，排序数组。
        if (nums.length != 1){
            int i = nums.length -2;
            while (i >= 0){
                if (nums[i + 1] <= nums[i]) {   //从尾部开始，比较元素是否是大到小
                    i--;
                    continue;
                }
                else {  //排序关系不正确时
                    for (int j = nums.length-1;j>i;j--){
                        if (nums[j] <= nums[i]){
                            continue;
                        }
                        int temp = nums[j]; //将i元素和遍历过的元素中第一个比nums[i]大的交换。
                        nums[j] = nums[i];
                        nums[i] = temp;
                        Arrays.sort(nums,i+1,nums.length);  //排序i之后的数组。
                        flag = 1;
                        break;
                    }
                    break;
                }
            }
            if (flag == 0 ){    //如果全部从大到小，则排序整个数组。
                Arrays.sort(nums);
            }  
        }
    }
}
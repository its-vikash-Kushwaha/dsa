class Solution {
    public void moveZeroes(int[] nums) {
        int index=-1;
        if(nums.length<=1)return;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                index=i;
                break;
            }
        }
        if(index==-1)return;

           for(int i=index;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            nums[index++]=nums[i];
            nums[i]=0;


        }

    }
}
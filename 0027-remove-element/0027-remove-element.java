class Solution {
    public int removeElement(int[] nums, int val) {
        int prev=-1;
        if(nums.length==0)return 0;
        if(nums.length==1) {
            if(nums[0]==val )return 0;
            else return 1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                prev=i;
                break;
            }
        }

        if(prev==-1)return nums.length;

         for(int i=prev+1;i<nums.length;i++){
            if(nums[i]==val){
               continue;
            }

           
            nums[prev]=nums[i];
             prev++;
        }
        return prev;
    }
}
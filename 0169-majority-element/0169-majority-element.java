class Solution {
    public int majorityElement(int[] nums) {

        int el=0;
        int count=0;

        for(int i:nums){

            if(count==0){
                count=1;
                el=i;
            }else if(el==i){
                count++;
            }else count--;

        }

        return el;
        
    }
}
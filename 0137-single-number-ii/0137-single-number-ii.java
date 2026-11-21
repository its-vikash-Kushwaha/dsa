class Solution {
    public int singleNumber(int[] nums) {
        
        int res=0;

        for(int bit=0;bit<32;bit++){

            int count=0;

            for(int num:nums){
                if((num&(1<<bit))!=0)count++;
            }
             
            if(count%3==1){
               res=res|(1<<bit);
            }
        }
        return res;
    }
}
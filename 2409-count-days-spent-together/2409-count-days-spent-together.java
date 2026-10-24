class Solution {

    int find(String s,int count[]){
        String[] parts = s.split("-");
        
        // 2. Convert each string part into an integer
        int m= Integer.parseInt(parts[0]);  // Results in 8
        int day= Integer.parseInt(parts[1]);

        return count[m-1]+day;

    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int count[]=new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        count[0]=0;
        count[1]=31;
        for(int i=2;i<count.length;i++){
            count[i]+= count[i-1];
        }

        int aa=find(arriveAlice,count);
        int la=find(leaveAlice,count);
        int ab=find(arriveBob,count);
        int lb=find(leaveBob,count);

        int ans=Math.min(la,lb)-Math.max(aa,ab)+1;
        return ans<0?0:ans;
    }
}
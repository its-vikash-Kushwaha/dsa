class Solution {

    public int solve(int i,int[] days,int[] costs,int[] dp){
        if(i==days.length)return 0;
        if(dp[i]!=-1)return dp[i];
        
        int d1=costs[0]+solve(i+1,days,costs,dp);
        
        int d7=0,d30=0;
        int curr=i;

        while(curr<days.length && days[curr]<days[i]+7)curr++;
        d7=costs[1]+solve(curr,days,costs,dp);
        curr=i;
        while(curr<days.length && days[curr]<days[i]+30)curr++;
        d30=costs[2]+solve(curr,days,costs,dp);
        return dp[i]=Math.min(Math.min(d1,d7),d30);

    }
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length];
        Arrays.fill(dp,-1);
        return solve(0,days,costs,dp);
    }
}
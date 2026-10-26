class Solution {
     int[][] direction = {
    {0,-1},
    {0,1},
    {-1,0},
    {1,0}
};
    public long dfs(int[][] grid, int i,int j){

     long sum=grid[i][j];
     grid[i][j]=0;
       int n=grid[0].length;
        int m=grid.length;

     for(int[] dir:direction){
        int i_=dir[0]+i;
        int j_=dir[1]+j;

        if(i_>=0 && i_<m && j_>=0 && j_<n && grid[i_][j_]>0) 
                sum+=dfs(grid,i_,j_);
     }
     return sum;
    }
    public int countIslands(int[][] grid, int k) {

        int n=grid[0].length;
        int m=grid.length;
        int count=0;

        for(int i=0;i<m;i++){
              
              for(int j=0;j<n;j++){

                if(grid[i][j]>0){
                    long sum=dfs(grid,i,j);
                    if(sum%k==0)count++;
                }

              }
        }
        return count;
    }
}
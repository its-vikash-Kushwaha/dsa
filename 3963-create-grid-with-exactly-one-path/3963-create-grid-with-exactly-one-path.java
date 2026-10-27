class Solution {
    public String[] createGrid(int m, int n) {

      String[] grid = new String[m];

      StringBuilder first=new StringBuilder();

      for(int i=0;i<n;i++)first.append(".");
      grid[0]=first.toString();

       StringBuilder other=new StringBuilder();

      for(int i=0;i<n-1;i++)other.append("#");
    other.append(".");
      

      for(int i=1;i<m;i++)grid[i]=other.toString();

      return grid;





        
    }
}
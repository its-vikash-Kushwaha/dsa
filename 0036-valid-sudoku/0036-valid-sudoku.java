class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set=new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                char ch=board[i][j];

                String row=ch+"row"+i;
                String col=ch+"col"+j;

                int b=(i/3)*3+(j/3);
                String box=ch+"box"+b;

                if((!set.add(row))|| (!set.add(col)) || (!set.add(box)))return false;

            }
        }
        return true;
    }
}
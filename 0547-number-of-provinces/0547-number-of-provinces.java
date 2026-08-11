class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<isConnected.length;i++){

            for(int j=0;j<isConnected[i].length;j++){

                if((i!=j)&& isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        int count=0;
        boolean[] visited=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj,int v,boolean[] visited){

        visited[v]=true;
        for(int node:adj.get(v)){
            if(!visited[node]){
                dfs(adj,node,visited);
            }
        }
    }
}
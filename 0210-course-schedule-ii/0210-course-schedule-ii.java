class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        int in[]=new int[numCourses];

        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());

        for(int p[]:prerequisites){
            adj.get(p[1]).add(p[0]);
            in[p[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
     
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        while(!q.isEmpty()){
            int v=q.poll();
            temp.add(v);
            for(int x:adj.get(v)){
                if(--in[x]==0){
                    q.offer(x);
                }
            }

        }
        int ans[]=new int[numCourses];
        if(temp.size()==numCourses){
            for(int i=0;i<numCourses;i++){
                 ans[i]=temp.get(i);
            }
            return ans;
        }

        return new int[0];
    }
}
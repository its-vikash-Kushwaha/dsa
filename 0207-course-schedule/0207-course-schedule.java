class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int in[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int []p:prerequisites){
              adj.get(p[1]).add(p[0]);

              in[p[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> t=new ArrayList<>();

        while(!q.isEmpty()){

            int v=q.poll();
            t.add(v);

            for(int n:adj.get(v)){
                if(--in[n]==0){
                    q.offer(n);
                }
            }
        }

        if(t.size()==numCourses)return true;
        return false;
    }
}
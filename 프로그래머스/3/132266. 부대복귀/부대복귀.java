import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        boolean[] visited=new boolean[n+1];
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        for(int i=0; i<roads.length; i++){
            if(!map.containsKey(roads[i][0])) map.put(roads[i][0], new ArrayList<Integer>());
            if(!map.containsKey(roads[i][1])) map.put(roads[i][1], new ArrayList<Integer>());
            map.get(roads[i][1]).add(roads[i][0]);
            map.get(roads[i][0]).add(roads[i][1]);
        }
        
        int[] distance=new int[n+1];
        visited[destination]=true;
        Queue<int[]> BFS=new LinkedList<>();
        BFS.add(new int[] {destination, 0});
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<sources.length; i++) set.add(sources[i]);
        int sd=0;
        outer:while(!BFS.isEmpty()){
            int[] temp=BFS.poll();
            for(int a:map.get(temp[0])){
                if(!visited[a]){
                    visited[a]=true;
                    distance[a]=temp[1]+1;
                    if(set.contains(a)){
                        sd++;
                        if(sd==sources.length) break outer;
                    }
                    BFS.add(new int[] {a, temp[1]+1});
                }
            }
        }
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i]=distance[sources[i]];
            if(answer[i]==0 && sources[i]!=destination) answer[i]=-1;
        }
        return answer;
    }
}
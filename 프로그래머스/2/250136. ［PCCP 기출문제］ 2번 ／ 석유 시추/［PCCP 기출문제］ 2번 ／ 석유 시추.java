import java.util.*;
class Solution {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public int solution(int[][] land) {
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(0);
        int counter=1;
        for(int j=0; j<land[1].length; j++){
            int temps=0;
            HashSet<Integer> set=new HashSet<>();
            for(int i=0; i<land.length; i++){
                if(land[i][j]==1){
                    counter++;
                    set.add(counter);
                    int size=1;
                    land[i][j]=counter;
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[] {i,j});          
                    while(!queue.isEmpty()){
                        int[] temp=queue.poll();
                        for(int k=0; k<4; k++){
                            int nx=temp[0]+dx[k];
                            int ny=temp[1]+dy[k];
                            if(nx>=0 && nx<land.length && ny>=0 && ny<land[1].length && land[nx][ny]==1){
                                land[nx][ny]=counter;
                                size++;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                    list.add(size);
                    temps+=size;
                }else if(land[i][j]!=0 && !set.contains(land[i][j])){
                    temps+=list.get(land[i][j]);
                    set.add(land[i][j]);
                }
                answer=Math.max(answer, temps);
            }
        }
        return answer;
    }
}
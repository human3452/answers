import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        st1=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st1.nextToken());
        int M= Integer.parseInt(st1.nextToken());
        Queue<int[]>[][] SwitchMap=new LinkedList[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                SwitchMap[i][j]=new LinkedList<>();
            }
        }
        for(int i=0; i<M; i++) {
            st1 = new StringTokenizer(br.readLine());
            SwitchMap[Integer.parseInt(st1.nextToken())-1][Integer.parseInt(st1.nextToken())-1].add(new int[]{Integer.parseInt(st1.nextToken())-1, Integer.parseInt(st1.nextToken())-1});
        }
        //스위치 켜기
        int answer=1;
        boolean flag=true;
        boolean[][] barn=new boolean[N][N];
        barn[0][0]=true;
        while(!SwitchMap[0][0].isEmpty()){
            int[] zeroswitch=SwitchMap[0][0].poll();
            if(!barn[zeroswitch[0]][zeroswitch[1]]){
                barn[zeroswitch[0]][zeroswitch[1]]=true;
                answer++;
            }
        }
        while(flag){
            flag=false;
            Queue<int[]> BFS=new LinkedList<>();
            BFS.add(new int[]{0,0});
            boolean[][] visited=new boolean[N][N];
            while(!BFS.isEmpty()){
                int[] position=BFS.poll();
                visited[position[0]][position[1]]=true;
                if(!SwitchMap[position[0]][position[1]].isEmpty()){
                    while(!SwitchMap[position[0]][position[1]].isEmpty()){
                        int[] sw=SwitchMap[position[0]][position[1]].poll();
                        if(!barn[sw[0]][sw[1]]){
                            barn[sw[0]][sw[1]]=true;
                            answer++;
                            flag=true;
                        }
                    }
                }
                for(int i=0; i<4; i++){
                    int nx=position[0]+dx[i];
                    int ny=position[1]+dy[i];
                    if(nx>=0 && nx<N && ny>=0 && ny<N && barn[nx][ny] && !visited[nx][ny]){
                        visited[nx][ny]=true;
                        BFS.add(new int[]{nx,ny});

                    }
                }
            }
        }
        System.out.println(answer);
    }
}
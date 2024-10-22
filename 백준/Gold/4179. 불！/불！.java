import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int R= Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());
        boolean[][] firemap=new boolean[R][C];
        boolean[][] wallmap=new boolean[R][C];
        boolean[][] jihoonmap=new boolean[R][C];
        int x=-1, y=-1;
        Queue<int[]> fire=new LinkedList<>();
        Queue<int[]> jihoon=new LinkedList<>();
        for(int i=0; i<R; i++){
            String temp=br.readLine();
            for(int j=0; j<C; j++){
                switch (temp.charAt(j)){
                    case '#':
                        wallmap[i][j]=true;
                        break;
                    case 'J':
                        x=i;
                        y=j;
                        jihoon.add(new int[]{x, y, 1});
                        jihoonmap[i][j]=true;
                        break;
                    case 'F':
                        firemap[i][j]=true;
                        fire.add(new int[]{i, j, 1});
                        break;
                }
            }
        }
        if(x==0 || x==R-1 || y==0 || y==C-1){
            System.out.print(1);
            System.exit(0);
        }
        int counter=1;
        while(!jihoon.isEmpty()){
            //fire
            while(!fire.isEmpty() && fire.peek()[2]==counter){
                int[] temp=fire.poll();
                for(int i=0; i<4; i++){
                    int nx=temp[0]+dx[i];
                    int ny=temp[1]+dy[i];
                    if(nx>=0 && nx<R && ny>=0 && ny<C && !wallmap[nx][ny] && !firemap[nx][ny]){
                        firemap[nx][ny]=true;
                        fire.add(new int[]{nx, ny, temp[2]+1});
                    }
                }
            }
            //jihoon
            while(!jihoon.isEmpty() && jihoon.peek()[2]==counter){
                int[] temp=jihoon.poll();
                for(int i=0; i<4; i++){
                    int nx=temp[0]+dx[i];
                    int ny=temp[1]+dy[i];
                    if(nx>=0 && nx<R && ny>=0 && ny<C && !wallmap[nx][ny] && !firemap[nx][ny] && !jihoonmap[nx][ny]){
                        if(nx==0 || nx==R-1 || ny==0 || ny==C-1){
                            System.out.print(temp[2]+1);
                            System.exit(0);
                        }
                        jihoonmap[nx][ny]=true;
                        jihoon.add(new int[]{nx, ny, temp[2]+1});
                    }
                }
            }
            counter++;
        }
        System.out.print("IMPOSSIBLE");
    }
}
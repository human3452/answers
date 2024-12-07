import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static final int[] dx={1, 0, -1, 0, 0, 0};
    static final int[] dy={0, 1, 0, -1, 0, 0};
    static final int[] dz={0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int H= Integer.parseInt(st.nextToken());
        int[][][] boxes=new int[M][N][H];
        int tomato=0, max=M*N*H;
        Queue<int[]> BFS=new LinkedList<>();
        for(int height=0; height<H; height++){
            for(int width=0; width<M; width++){
                st=new StringTokenizer(br.readLine());
                for(int length=0; length<N; length++){
                    boxes[width][length][height]= Integer.parseInt(st.nextToken());
                    if(boxes[width][length][height]==1) {
                        tomato++;
                        BFS.add(new int[]{width, length, height, 0});
                    }
                    else if(boxes[width][length][height]==-1) max--;
                }
            }
        }
        if(tomato==max){
            bw.write("0");
        }else{
            int answer=-1;
            while(!BFS.isEmpty()){
                int[] temp=BFS.poll();
                answer=temp[3];
                for(int i=0; i<6; i++){
                    int nx=temp[0]+dx[i];
                    int ny=temp[1]+dy[i];
                    int nz=temp[2]+dz[i];
                    if(nx>=0 && nx<M && ny>=0 && ny<N && nz>=0 && nz<H && boxes[nx][ny][nz]==0){
                        tomato++;
                        boxes[nx][ny][nz]=1;
                        BFS.add(new int[]{nx, ny, nz, temp[3]+1});
                    }
                }
            }
            if(tomato==max){
                bw.write(answer+"");
            }else{
                bw.write(-1+"");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
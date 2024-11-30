import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Main {
    static int answer=0;
    static int[] points;
    static int[] subtree;
    static HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        boolean[][] board=new boolean[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                if(Integer.parseInt(st.nextToken())==1){
                    board[i][j]=true; //파랑=true
                }
            }
        }
        boolean[][] done=new boolean[N][N]; //0=미탐색 1=흰색 2=파란색
        int step=N;
        int white=0;
        int blue=0;
        while(step>=1){
            for(int c=0; c<N; c+=step){
                outer:for(int d=0; d<N; d+=step){
                    if(!done[c][d]){
                        boolean standard=board[c][d];

                        for(int i=c; i<c+step; i++){
                            for(int j=d; j<d+step; j++){
                                if(standard!=board[i][j]){
                                    continue outer;
                                }
                            }
                        }
                        for(int i=c; i<c+step; i++){
                            for(int j=d; j<d+step; j++){
                                done[i][j]=true;
                            }
                        }
                        if(standard) blue++;
                        else white++;
                    }
                }
            }
            step/=2;
        }
        bw.write(white+"\n");
        bw.write(blue+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
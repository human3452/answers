import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, 1, 0, -1};
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[][] board=new int[N][M];
        boolean[][] visited=new boolean[N][M];
        p=new int[N*M];
        for(int i=0; i<p.length; i++) p[i]=i;
        for(int i=0; i<N; i++){
            String temp=br.readLine();
            for(int j=0; j<M; j++){
                switch (temp.charAt(j)){
                    case 'U':
                        board[i][j]=0;
                        break;
                    case 'R':
                        board[i][j]=1;
                        break;
                    case 'D':
                        board[i][j]=2;
                        break;
                    case 'L':
                        board[i][j]=3;
                        break;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]) {
                    visited[i][j]=true;
                    int root=i*M+j;
                    int[] pointer = new int[]{i, j};
                    while(true){
                        pointer[0]=pointer[0]+dx[board[pointer[0]][pointer[1]]];
                        pointer[1]=pointer[1]+dy[board[pointer[0]][pointer[1]]];
                        if(visited[pointer[0]][pointer[1]]) {
                            union(pointer[0]*M+pointer[1], root);
                            break;
                        }
                        visited[pointer[0]][pointer[1]]=true;
                        union(pointer[0]*M+pointer[1], root);
                    }
                }
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<p.length; i++){
            set.add(find(p[i]));
        }
        bw.write(set.size()+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int A){
        if(p[A]==A){
            return A;
        }else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }
    static void union(int A, int B){
        p[find(Math.max(A, B))]=find(Math.min(A,B));
    }
}

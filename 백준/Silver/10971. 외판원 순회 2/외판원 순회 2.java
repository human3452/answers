import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        int[][] board=new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        int[] perm=new int[N];
        for(int i=1; i<N; i++) perm[i]=i;
        int min=0;
        for(int i=0; i<N-1; i++){
            if(board[i][i+1]==0) {
                min=0;
                break;
            }
            min+=board[i][i+1];
        }
        if(min==0 || board[N-1][0]==0){
            min= Integer.MAX_VALUE;
        }else min+=board[N-1][0];
        outer:while(true){
            int leftpivot=-1;
            int rightpivot=-1;
            for(int i=N-2; i>=0; i--){
                if(perm[i]<perm[i+1]){
                    leftpivot=i;
                    break;
                }
            }
            if(leftpivot==-1) break;
            int ma=999;
            for(int i=leftpivot+1; i<N; i++){
                if(perm[i]>perm[leftpivot] && ma>perm[i]){
                    ma=perm[i];
                    rightpivot=i;
                }
            }
            int temp=perm[leftpivot];
            perm[leftpivot]=perm[rightpivot];
            perm[rightpivot]=temp;
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for(int i=leftpivot+1; i<N; i++){
                pq.add(perm[i]);
            }
            for(int i=leftpivot+1; i<N; i++){
                perm[i]=pq.poll();
            }
            temp=0;
            for(int i=0; i<N-1; i++){
                if(board[perm[i]][perm[i+1]]==0) continue outer;
                temp+=board[perm[i]][perm[i+1]];
            }
            if(board[perm[N-1]][perm[0]]==0) continue;
            temp+=board[perm[N-1]][perm[0]];
            min=Math.min(temp, min);
        }
        System.out.println(min);
        bw.flush();
        bw.close();
        br.close();
    }
}
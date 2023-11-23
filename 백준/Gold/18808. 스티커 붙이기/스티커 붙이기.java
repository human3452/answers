import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        boolean[][] board=new boolean[N][M];
        int answer=0;
        outer:for(int tc=0; tc<K; tc++){
            ArrayList<int[]> arrayList=new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            int height= Integer.parseInt(st.nextToken());
            int width= Integer.parseInt(st.nextToken());
            boolean piece[][]=new boolean[height][width];
            for(int i=0; i<height; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<width; j++){
                    if(Integer.parseInt(st.nextToken())!=0){
                        arrayList.add(new int[]{i,j});
                    }
                }
            }
            spin:for(int spin=0; spin<4; spin++) {
                for (int i = 0; i <= N - height; i++) {
                    inner:for (int j = 0; j <= M - width; j++) {
                        for(int k=0; k< arrayList.size(); k++){
                            int[] temp=arrayList.get(k);
                            if(board[temp[0]+i][temp[1]+j]) continue inner;
                        }
                        answer+=arrayList.size();
                        for(int k=0; k< arrayList.size(); k++){
                            int[] temp=arrayList.get(k);
                            board[temp[0]+i][temp[1]+j]=true;
                        }
                        continue outer;
                    }
                }
                //spin
                int tmp=height;
                height=width;
                width=tmp;
                for(int i=0; i<arrayList.size(); i++){
                    int[] temp=arrayList.get(i);
                    arrayList.set(i, new int[]{temp[1],(width-1)-temp[0]});
                }
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;

        st1=new StringTokenizer(br.readLine(), " ");
        int H= Integer.parseInt(st1.nextToken());
        int W= Integer.parseInt(st1.nextToken());
        boolean[][] board=new boolean[H][W];
        st1=new StringTokenizer(br.readLine(), " ");
        int max=-1;
        for(int i=0; i<W; i++){
            int height= Integer.parseInt(st1.nextToken());
            max=Math.max(max,height);
            for(int j=0; j<height; j++){
                board[j][i]=true;
            }
        }
        int answer=0;
        for(int i=max-1; i>=0; i--){
            int counter=0;
            boolean flag=true;
            for(int j=0; j<W; j++){
                if(board[i][j]){
                    if(flag){
                        flag=false;
                        counter=0;
                    }else{
                        answer+=counter;
                        counter=0;
                    }
                }else{
                    counter++;
                }
            }
        }
        System.out.println(answer);
    }
}
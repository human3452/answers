import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int[] tower=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tower[i]= Integer.parseInt(st.nextToken());
        }
        //좌 우 찾기
        int max=0;
        for(int i=0; i<N; i++){
            //left
            int temp=0;
            double highest=Double.MAX_VALUE;
            for(int j=i-1; j>=0; j--){
                if((double) (tower[j] - tower[i]) /(j-i)<highest){
                    temp++;
                    highest=(double) (tower[j] - tower[i]) /(j-i);
                }
            }
            //right
            double rightest=-Double.MAX_VALUE;
            for(int j=i+1; j<N; j++){
                if((double) (tower[j] - tower[i]) /(j-i)>rightest){
                    temp++;
                    rightest=(double) (tower[j] - tower[i]) /(j-i);
                }
            }
            max=Math.max(max, temp);
        }
        System.out.print(max);
    }
}
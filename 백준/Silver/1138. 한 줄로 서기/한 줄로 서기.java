import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] line=new int[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int a= Integer.parseInt(st.nextToken());
            int counter=-1;
            for(int j=1; j<=N; j++){
                if(line[j]==0) counter++;
                if(counter==a){
                    line[j]=i;
                    break;
                }
            }
        }
        for (int i=1; i<=N; i++) System.out.print(line[i]+" ");
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        int[][] temp=new int[T][2];
        for(int i=0; i<T; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            temp[i][0]= Integer.parseInt(st.nextToken());
            temp[i][1]= Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<T; i++){
            int answer=1;
            for(int j=0; j<T; j++){
                if(temp[i][0]<temp[j][0] && temp[i][1]<temp[j][1]) answer++;
            }
            System.out.print(answer+" ");
        }
    }
}
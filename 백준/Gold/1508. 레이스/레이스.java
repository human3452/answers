import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int[] position=new int[K];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            position[i]= Integer.parseInt(st.nextToken());
        }
        int start=0;
        int end=N;
        while(start<=end){
            int middle=(start+end)/2;
            int pointer=0;
            int g=1;
            int temp=1;
            while(temp<=K-1){
                if(position[temp]-position[pointer]>=middle){
                    g++;
                    pointer=temp;
                }
                temp++;
            }
            if(g>=M){
                start=middle+1;
            }else{
                end=middle-1;
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(1);
        int pointer=0;
        int temp=1;
        int g=1;
        while(temp<=K-1){
            if(g==M){
                sb.append(0);
            }
            else if(position[temp]-position[pointer]>=end){
                sb.append(1);
                pointer=temp;
                g++;
            }
            else{
                sb.append(0);
            }
            temp++;
        }
        System.out.println(sb.toString());
    }
}

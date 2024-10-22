import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[] size=new int[6];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) size[i]= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int T= Integer.parseInt(st.nextToken());
        int P= Integer.parseInt(st.nextToken());
        int answer=0;
        for(int i=0; i<6; i++){
            answer+=size[i]/T;
            if(size[i]%T!=0) answer++;
        }
        System.out.println(answer);
        System.out.print(N/P+" "+N%P);
    }
}
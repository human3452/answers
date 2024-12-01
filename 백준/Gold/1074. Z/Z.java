import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= (int) Math.pow(2,Integer.parseInt(st.nextToken()));
        int r= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        int upper=0;
        int left=0;
        int answer=0;
        while(N>=2){
            int position;
            if(r>=upper+N/2){
                upper+=N/2;
                if(c>=left+N/2){
                    position=3;
                    left+=N/2;
                }else{
                    position=2;
                }
            }else if(c>=left+N/2){
                left+=N/2;
                position=1;
            }else{
                position=0;
            }
            N/=2;
            answer+=position*N*N;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
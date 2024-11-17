import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        outer:while(true){
            int[] vote=new int[26];
            int N= Integer.parseInt(br.readLine());
            if(N==0) break;
            StringTokenizer st=new StringTokenizer(br.readLine());
            int max = 0, secondmax=0, maxpointer=0;
            for(int i=1; i<=N; i++){
                vote[st.nextToken().charAt(0)-'A']++;
                max=0;
                secondmax=0;
                maxpointer=-1;
                for(int j=0; j<26; j++){
                    if(vote[j]>=max){
                        secondmax=max;
                        max=vote[j];
                        maxpointer=j;
                    }else if(vote[j]>secondmax){
                        secondmax=vote[j];
                    }
                }
                if(max-secondmax>N-i){
                    bw.write(maxpointer+'A');
                    bw.write(" "+i+"\n");
                    continue outer;
                }
            }
            if(max==secondmax) bw.write("TIE"+"\n");
            else{
                bw.write(maxpointer+'A');
                bw.write(" "+N+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        long[] ink=new long[N];
        long[] viscosity=new long[N];
        int[] answer=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            ink[i]= Long.parseLong(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            viscosity[i]= Long.parseLong(st.nextToken());
        }
        outer:for(int i=0; i<N-1; i++){
            int start=i+1;
            int end=N-1;
            if(viscosity[i+1]<=ink[i]) {
                if(ink[i]>=viscosity[N-1]){
                    answer[i]=N-i-1;
                }else {
                    while (start <= end) {
                        int middle = (start + end) / 2;
                        if (viscosity[middle] > ink[i]) {
                            end=middle-1;
                        }else{
                            start=middle+1;
                        }
                    }
                }
                answer[i]=end-i;
            }
        }
        for(int i=0; i<N-1; i++) bw.write(answer[i]+" ");
        bw.write(answer[N-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
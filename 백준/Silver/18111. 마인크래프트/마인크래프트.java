import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int B= Integer.parseInt(st.nextToken());
        int min=258;
        int max=-1;
        int[] height=new int[258];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int temp= Integer.parseInt(st.nextToken());
                min=Math.min(min, temp);
                max=Math.max(max, temp);
                for(int k=temp; k>=0; k--) height[k]++;
            }
        }
        if(min==max){
            bw.write("0"+" "+min);
        }else {
            for (int i = max; i >= min + 1; i--) {
                height[i - 1] += height[i];
            }
            int man= Integer.MAX_VALUE;
            int pointer=999;
            for (int i = max; i >= min; i--) {
                int requirements=N*M*(i-min+1)-(height[min]-height[i+1]);
                if(requirements<=height[i+1]+B){
                    int answer=requirements+height[i+1]*2;
                    if(answer<man){
                        man=answer;
                        pointer=i;
                    }
                }
            }
            bw.write(man+" "+pointer);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
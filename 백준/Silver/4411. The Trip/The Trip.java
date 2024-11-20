import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            int N= Integer.parseInt(br.readLine());
            if(N==0) break;
            double[] costs=new double[N];
            double sum=0;
            for(int i=0; i<N; i++){
                costs[i]=Double.parseDouble(br.readLine());
                sum+=costs[i];
            }
            sum/=N;
            double plus=0;
            double minus=0;
            double answer;
            for(int i=0; i<N; i++){
                if(costs[i]>=sum){
                    plus+= Math.round((costs[i]-sum)*100)/100.0;
                }else{
                    minus+= Math.round((sum-costs[i])*100)/100.0;
                }
            }
            answer=Math.min(plus, minus);
            bw.write("$"+String.format("%.2f", answer)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
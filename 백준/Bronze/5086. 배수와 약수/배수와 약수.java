import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            if(from==0) break;
            if(from>to){
                if(from%to==0) bw.write("multiple"+"\n");
                else bw.write("neither"+"\n");
            }else{
                if(to%from==0) bw.write("factor"+"\n");
                else bw.write("neither"+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
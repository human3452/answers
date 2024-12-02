import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        long[] benchmark={Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        long[] first=new long[2];
        long[] second=new long[2];
        st=new StringTokenizer(br.readLine());
        first[0]= Integer.parseInt(st.nextToken())-benchmark[0];
        first[1]= Integer.parseInt(st.nextToken())-benchmark[1];
        double answer=0;
        for(int i=2; i<N; i++){
            st=new StringTokenizer(br.readLine());
            second[0]= Integer.parseInt(st.nextToken())-benchmark[0];
            second[1]= Integer.parseInt(st.nextToken())-benchmark[1];
            answer+=((double)first[0]*second[1]-(double)first[1]*second[0])/2;
            first[0]=second[0];
            first[1]=second[1];
        }
        System.out.println(String.format("%.1f", Math.abs((answer*10)/10.0)));
        bw.flush();
        bw.close();
        br.close();
    }
}
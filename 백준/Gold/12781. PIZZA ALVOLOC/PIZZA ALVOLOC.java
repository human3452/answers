import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long x1=Long.parseLong(st.nextToken());
        long y1=Long.parseLong(st.nextToken());
        long x2=Long.parseLong(st.nextToken());
        long y2=Long.parseLong(st.nextToken());
        long x3=Long.parseLong(st.nextToken());
        long y3=Long.parseLong(st.nextToken());
        long x4=Long.parseLong(st.nextToken());
        long y4=Long.parseLong(st.nextToken());
        long CCW1=(x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3);
        long CCW2=(x1*y2+x2*y4+x4*y1-x2*y1-x4*y2-x1*y4);
        long CCW3=(x3*y4+x4*y1+x1*y3-x4*y3-x1*y4-x3*y1);
        long CCW4=(x3*y4+x4*y2+x2*y3-x4*y3-x2*y4-x3*y2);
        if(((CCW1<0 && CCW2>0) ||(CCW1>0 && CCW2<0)) && ((CCW3<0 && CCW4>0) ||(CCW3>0 && CCW4<0))) {
            System.out.println(1);
            System.exit(0);
        }else{
            System.out.println(0);
            System.exit(0);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
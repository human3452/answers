import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long x1=Long.parseLong(st.nextToken());
        long y1=Long.parseLong(st.nextToken());
        long x2=Long.parseLong(st.nextToken());
        long y2=Long.parseLong(st.nextToken());
        st=new StringTokenizer(br.readLine());
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
        }
        if(((CCW1>0 && CCW2>0) ||(CCW1<0 && CCW2<0)) || ((CCW3>0 && CCW4>0) ||(CCW3<0 && CCW4<0))) {
            System.out.println(0);
            System.exit(0);
        }
        if(CCW1*CCW2==0 ^ CCW3*CCW4==0) {
            System.out.println(1);
            System.exit(0);
        }
        if(x1==x2){
            if((Math.max(y1, y2)<y3 && Math.max(y1, y2)<y4) || (Math.min(y1, y2)>y3 && Math.min(y1, y2)>y4)){
                System.out.println(0);
            }else System.out.println(1);
        } else if(y1==y2){
            if((Math.max(x1, x2)<x3 && Math.max(x1, x2)<x4) || (Math.min(x1, x2)>x3 && Math.min(x1, x2)>x4)){
                System.out.println(0);
            }else System.out.println(1);
        }else{
            if((Math.max(y1, y2)<y3 && Math.max(y1, y2)<y4) || (Math.min(y1, y2)>y3 && Math.min(y1, y2)>y4) && (Math.max(x1, x2)<x3 && Math.max(x1, x2)<x4) || (Math.min(x1, x2)>x3 && Math.min(x1, x2)>x4)){
                System.out.println(0);
            }else System.out.println(1);
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int A){
        if(p[A]==A) return A;
        else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }
    //A<B
    static void union(int A, int B){
        p[find(A)]=find(B);
    }
}

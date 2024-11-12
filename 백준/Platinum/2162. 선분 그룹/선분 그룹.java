import java.io.*;
import java.util.*;


public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<int[]> lines=new ArrayList<>();
        int N= Integer.parseInt(br.readLine());
        p=new int[N+1];
        for(int i=1; i<=N; i++) p[i]=i;
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] temp=new int[4];
            for(int j=0; j<4; j++) temp[j]= Integer.parseInt(st.nextToken());
            for(int j=0; j<lines.size(); j++){
                if(check(temp, lines.get(j))){
                    union(j+1, i+1);
                }
            }
            lines.add(temp);
        }
        int[] answer=new int[N+1];
        for(int i=1; i<=N; i++){
            answer[find(i)]++;
        }
        Arrays.sort(answer);
        for(int i=N; i>=0; i--) {
            if (answer[i] == 0) {
                System.out.println(N - i);
                break;
            }
        }
        System.out.println(answer[N]);
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int A){
        if(p[A]==A) return A;
        else{
            p[A]=find(p[A]);
            return p[A];
        }
    }
    static void union(int A, int B){
        p[find(Math.max(A, B))]=find(Math.min(A, B));
    }
    static boolean check(int[] a1, int[] a2){
        long x1=a1[0];
        long y1=a1[1];
        long x2=a1[2];
        long y2=a1[3];
        long x3=a2[0];
        long y3=a2[1];
        long x4=a2[2];
        long y4=a2[3];
        long CCW1=(x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3);
        long CCW2=(x1*y2+x2*y4+x4*y1-x2*y1-x4*y2-x1*y4);
        long CCW3=(x3*y4+x4*y1+x1*y3-x4*y3-x1*y4-x3*y1);
        long CCW4=(x3*y4+x4*y2+x2*y3-x4*y3-x2*y4-x3*y2);
        if(((CCW1<0 && CCW2>0) ||(CCW1>0 && CCW2<0)) && ((CCW3<0 && CCW4>0) ||(CCW3>0 && CCW4<0))) {
            return true;
        }
        if(((CCW1>0 && CCW2>0) ||(CCW1<0 && CCW2<0)) || ((CCW3>0 && CCW4>0) ||(CCW3<0 && CCW4<0))) {
            return false;
        }
        if(CCW1*CCW2==0 ^ CCW3*CCW4==0) {
            return true;
        }
        if(x1==x2){
            if((Math.max(y1, y2)<y3 && Math.max(y1, y2)<y4) || (Math.min(y1, y2)>y3 && Math.min(y1, y2)>y4)){
                return false;
            }else return true;
        } else if(y1==y2){
            if((Math.max(x1, x2)<x3 && Math.max(x1, x2)<x4) || (Math.min(x1, x2)>x3 && Math.min(x1, x2)>x4)){
                return false;
            }else return true;
        }else{
            if((Math.max(y1, y2)<y3 && Math.max(y1, y2)<y4) || (Math.min(y1, y2)>y3 && Math.min(y1, y2)>y4) && (Math.max(x1, x2)<x3 && Math.max(x1, x2)<x4) || (Math.min(x1, x2)>x3 && Math.min(x1, x2)>x4)){
                return false;
            }else return true;
        }
    }
}
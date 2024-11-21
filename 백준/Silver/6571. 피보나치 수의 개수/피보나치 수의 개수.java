import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static BigInteger[] fibonacchi=new BigInteger[500];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        fibonacchi[0]=new BigInteger("1");
        fibonacchi[1]=new BigInteger("2");
        for(int i=1; i<499; i++){
            fibonacchi[i+1]=fibonacchi[i].add(fibonacchi[i-1]);
        }
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            BigInteger A=new BigInteger(st.nextToken());
            BigInteger B=new BigInteger(st.nextToken());
            if(A.toString().equals("0") && B.toString().equals("0")) break;
            int rightpointer=-1;
            int leftpointer=-1;
            int left=0;
            int right=499;
            outer:while(left<=right){
                int middle=(left+right)/2;
                switch (fibonacchi[middle].compareTo(B)){
                    case 1:
                        right=middle-1;
                        break;
                    case 0:
                        rightpointer=middle;
                        break outer;
                    case -1:
                        left=middle+1;
                        break;
                }
            }
            if(rightpointer==-1){
                rightpointer=right;
            }
            left=0;
            right=499;
            outer:while(left<=right){
                int middle=(left+right)/2;
                switch (fibonacchi[middle].compareTo(A)){
                    case 1:
                        right=middle-1;
                        break;
                    case 0:
                        leftpointer=middle;
                        break outer;
                    case -1:
                        left=middle+1;
                        break;
                }
            }
            if(leftpointer==-1){
                leftpointer=left;
            }
            bw.write((rightpointer-leftpointer+1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
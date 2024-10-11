import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        st1=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st1.nextToken());
        int M=Integer.parseInt(st1.nextToken());
        int[] basket = new int[N+1];
        for(int i=0; i<M; i++) {
            st1 = new StringTokenizer(br.readLine(), " ");
            int from=Integer.parseInt(st1.nextToken());
            int to=Integer.parseInt(st1.nextToken());
            int ball=Integer.parseInt(st1.nextToken());
            for(int j=from; j<=to; j++){
                basket[j]=ball;
            }
        }
        for(int i=1; i<N; i++){
            System.out.print(basket[i]+" ");
        }
        System.out.print(basket[N]);
    }
}
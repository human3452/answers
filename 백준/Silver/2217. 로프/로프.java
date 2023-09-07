import java.util.*;

class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[] weights=new int[N];
        for(int i=0; i<N; i++){
            weights[i]=sc.nextInt();
        }
        Arrays.sort(weights);
        int total=0;
        for(int i=N-1; i>=0; i--){
            total=Math.max(weights[i]*(N-i), total);
        }
        System.out.println(total);
    }
}
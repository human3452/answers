import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		Stack<int[]> stack=new Stack<int[]>(); 
		int counter=Integer.MAX_VALUE;
		StringTokenizer st2=new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int a=Integer.parseInt(st2.nextToken());
			if(a<counter) {
				stack.push(new int[] {a,i});
				counter=a;
			}
		}
		stack.push(new int[] {0,N});
		StringTokenizer st3=new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int a=Integer.parseInt(st3.nextToken());
			int b = 0;
			while(!stack.isEmpty() && stack.peek()[0]<a) {
				b=stack.pop()[1];
			}
			N=b-1;
			if(!stack.isEmpty() && stack.peek()[1]==N) {
				stack.pop();
			}
			stack.push(new int[] {0,N});
		}
		
		System.out.println(Math.max(0, N+1));
	}
}
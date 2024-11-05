import java.io.*;
import java.util.*;


public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[] into=new int[N+1];
        Stack<Integer>[] stack=new Stack[N+1];
        for(int i=1; i<=N; i++){
            stack[i]=new Stack<>();
        }
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int pl= Integer.parseInt(st.nextToken());
            int start= Integer.parseInt(st.nextToken());
            for(int j=0; j<pl-1; j++){
                int to=Integer.parseInt(st.nextToken());
                into[to]++;
                stack[start].add(to);
                start=to;
            }
        }
        Deque<Integer> deque=new LinkedList<>();
        boolean[] visited=new boolean[N+1];
        while(true){
            int pointer=-1;
            for(int i=1; i<=N; i++){
                if(!visited[i] && into[i]==0){
                    deque.add(i);
                    visited[i]=true;
                    pointer=i;
                    break;
                }
            }
            if(pointer==-1) break;
            while(!stack[pointer].isEmpty()){
                into[stack[pointer].pop()]--;
            }
        }
        if(deque.size()!=N){
            bw.write(0+"");
        }else {
            for (int i = 0; i < N; i++) bw.write(deque.pollFirst() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[] into=new int[N+1];
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        boolean[] visited=new boolean[N+1];
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            into[to]++;
            if(!map.containsKey(from)) map.put(from, new ArrayList<>());
            map.get(from).add(to);
        }
        int pointer;
        Queue<Integer> queue=new LinkedList<>();
        do{
            pointer=-1;
            for(int i=1; i<=N; i++){
                if(!visited[i] && into[i]==0){
                    pointer=i;
                    queue.add(pointer);
                    visited[i]=true;
                    if(map.containsKey(pointer)) {
                        for (int j = 0; j < map.get(pointer).size(); j++) {
                            into[map.get(pointer).get(j)]--;
                        }
                    }
                    break;
                }
            }
        }while(pointer!=-1);
        for(int i=0; i<N-1; i++) bw.write(queue.poll()+" ");
        bw.write(queue.poll()+"");
        bw.flush();
        br.close();
        bw.close();
    }

}
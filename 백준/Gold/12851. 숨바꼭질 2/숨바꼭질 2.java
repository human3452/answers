import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static final int INF=100000000;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int from= Integer.parseInt(st.nextToken());
        int to= Integer.parseInt(st.nextToken());
        if(from==to){
            bw.write(0+"\n");
            bw.write(1+"");
        }else {//2^17=13....
            Queue<int[]> BFS = new LinkedList<>();
            int[] visited=new int[150001];
            for(int i=0; i<=150000; i++) visited[i]=INF;
            BFS.add(new int[]{from, 0});
            visited[from]=0;
            int fastest=-1;
            int answer=0;
            while(!BFS.isEmpty()){
                int[] temp=BFS.poll();
                if(temp[1]==fastest) break;
                int twice=temp[0]*2;
                int plus=temp[0]+1;
                int minus=temp[0]-1;
                if(plus<=150000){
                    if(plus==to){
                        answer++;
                        fastest=temp[1]+1;
                    }else if(visited[plus]>=temp[1]+1){
                        BFS.add(new int[]{plus, temp[1]+1});
                        visited[plus]=temp[1]+1;
                    }
                }
                if(minus>=0){
                    if(minus==to){
                        answer++;
                        fastest=temp[1]+1;
                    }else if(visited[minus]>=temp[1]+1){
                        BFS.add(new int[]{minus, temp[1]+1});
                        visited[minus]=temp[1]+1;
                    }
                }
                if(twice<=150000){
                    if(twice==to){
                        answer++;
                        fastest=temp[1]+1;
                    }else if(visited[twice]>=temp[1]+1){
                        BFS.add(new int[]{twice, temp[1]+1});
                        visited[twice]=temp[1]+1;
                    }
                }
            }
            bw.write(fastest+"\n");
            bw.write(answer+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer> list;
    static int[] answer;
    static int M;
    static int[] used=new int[10001];
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        HashSet<Integer> set=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int temp= Integer.parseInt(st.nextToken());
            set.add(temp);
            used[temp]++;
        }
        list=new ArrayList<>(set);
        Collections.sort(list);
        answer=new int[M];
        dup(0);
        bw.flush();
        bw.close();
        br.close();
    }
    static void dup(int depth) throws IOException {
        if(depth==M){
            for(int i=0; i<M-1; i++) bw.write(answer[i]+" ");
            bw.write(answer[M-1]+"\n");
        }else{
            for (int i = 0; i < list.size(); i++) {
                if(used[list.get(i)]>0) {
                    answer[depth] = list.get(i);
                    used[list.get(i)]--;
                    dup(depth + 1);
                    used[list.get(i)]++;
                }
            }
        }
    }
}
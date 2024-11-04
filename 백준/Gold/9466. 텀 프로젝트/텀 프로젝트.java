import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int tc= Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            int N= Integer.parseInt(br.readLine());
            boolean[] visited=new boolean[N+1];
            int answer=0;
            int[] temp = new int[N + 1];
            Stack<Integer> stack=new Stack<>();
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                temp[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=N; i++){
                int tem=i;
                if(!visited[i]) {
                    visited[i]=true;
                    HashSet<Integer> set=new HashSet<>();
                    set.add(tem);
                    stack.add(tem);
                    while (true) {
                        if(temp[tem]==tem){
                            answer+=stack.size()-1;
                            stack.clear();
                            visited[tem]=true;
                            break;
                        }
                        tem = temp[tem];
                        if (visited[tem]) {
                            if(set.contains(tem)){
                                while(!stack.isEmpty() && stack.pop()!=tem){}
                                answer+=stack.size();
                                stack.clear();
                            }else {
                                while(!stack.isEmpty()) {
                                    stack.pop();
                                    answer++;
                                }
                            }
                            break;
                        } else {
                            set.add(tem);
                            stack.add(tem);
                        }
                        visited[tem]=true;
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
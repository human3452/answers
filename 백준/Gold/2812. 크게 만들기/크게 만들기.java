import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        String alpha=st.nextToken();
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0; i<N; i++){
            int temp=alpha.charAt(i)-'0';
            while(M>0 && !list.isEmpty() && temp>list.peekLast()){
                list.pollLast();
                M--;
            }
            list.add(temp);
        }
        while(M>0) {
            list.pollLast();
            M--;
        }
        StringBuilder sb=new StringBuilder();
        while(!list.isEmpty()) sb.append(list.pollFirst());
        System.out.println(sb);
    }
}

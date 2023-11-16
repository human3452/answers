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
        ArrayList<int[]> villages=new ArrayList<>();
        long all=0;
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int location= Integer.parseInt(st.nextToken());
            int people=Integer.parseInt(st.nextToken());
            all+=people;
            villages.add(new int[]{location,people});
        }
        Collections.sort(villages, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        long sum=0;
        for(int i=0; i<villages.size(); i++){
            sum+=villages.get(i)[1];
            if(sum>=all-sum){
                System.out.println(villages.get(i)[0]);
                break;
            }
        }
    }
}

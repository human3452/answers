import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        long M= Long.parseLong(st.nextToken());
        int[] trees=new int[N+1];
        st=new StringTokenizer(br.readLine());
        long temp=0;
        for(int i=0; i<N; i++){
            trees[i]= Integer.parseInt(st.nextToken());
            temp+=trees[i];
        }
        Arrays.sort(trees);
        int pointer=N;
        long requirements=M;
        int answer=0;
        while(true){
            if(pointer>1 && trees[pointer]==trees[pointer-1]) pointer--;
            else{
                if(requirements<= (long) (trees[pointer]-trees[pointer - 1]) *(long)(N-pointer+1)){
                    answer=trees[pointer]-(int)(requirements/(N-pointer+1));
                    if(requirements%(N-pointer+1)!=0){
                        answer--;
                    }
                    break;
                }else{
                    requirements-=(long) (trees[pointer]-trees[pointer - 1]) *(long)(N-pointer+1);
                    pointer--;
                }
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
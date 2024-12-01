import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] numbers=new int[1000000];
        int start=-1;
        int end=-1;
        int N= Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())){
                case 1:
                    end++;
                    numbers[end]= Integer.parseInt(st.nextToken());
                    break;
                case 2:
                    if(start!=end){
                        bw.write(numbers[end]+"\n");
                        end--;
                    }else{
                        bw.write(-1+"\n");
                    }
                    break;
                case 3:
                    bw.write((end-start)+"\n");
                    break;
                case 4:
                    if(start==end) bw.write(1+"\n");
                    else bw.write(0+"\n");
                    break;
                case 5:
                    if(start!=end){
                        bw.write(numbers[end]+"\n");
                    }else{
                        bw.write(-1+"\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
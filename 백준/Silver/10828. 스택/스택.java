import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        int[] stack=new int[N];
        int start=-1;
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    start++;
                    stack[start]= Integer.parseInt(st.nextToken());
                    break;
                case "pop":
                    if(start!=-1) {
                        bw.write(stack[start] + "\n");
                        start--;
                    }else bw.write(start+"\n");
                    break;
                case "size":
                    bw.write((start+1)+"\n");
                    break;
                case "empty":
                    if(start==-1) bw.write(1+"\n");
                    else bw.write(0+"\n");
                    break;
                case "top":
                    if(start!=-1) bw.write(stack[start]+"\n");
                    else bw.write(start+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

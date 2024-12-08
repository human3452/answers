import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        outer:for(int tc=0; tc<T; tc++){
            String order=br.readLine();
            int quant= Integer.parseInt(br.readLine());
            StringTokenizer st;
            if(quant==0) {
                String blank=br.readLine();
                for(int i=0; i<order.length(); i++){
                    if(order.charAt(i)=='D'){
                        bw.write("error"+"\n");
                        continue outer;
                    }
                }
                bw.write("[]"+"\n");
            }else{
                String word=br.readLine();
                st = new StringTokenizer(word.substring(1, word.length()-1), ",");
                int[] board=new int[quant];
                for(int i=0; i<quant; i++) board[i]= Integer.parseInt(st.nextToken());
                boolean isreverse=false;
                int start=0;
                int end=quant-1;
                for(int i=0; i<order.length(); i++){
                    if(order.charAt(i)=='R'){
                        isreverse=!isreverse;
                    }else{
                        if(isreverse) end--;
                        else start++;
                    }
                }
                if(end<start-1) bw.write("error"+"\n");
                else {
                    if (end == start - 1) {
                        bw.write("[]" + "\n");
                    } else {
                        bw.write("[");
                        if (isreverse) {
                            for (int i = end; i >= start + 1; i--) {
                                bw.write(board[i] + ",");
                            }
                            bw.write(board[start] + "");
                        } else {
                            for (int i = start; i <= end - 1; i++) {
                                bw.write(board[i] + ",");
                            }
                            bw.write(board[end] + "");
                        }
                        bw.write("]" + "\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static byte[] knows;
    static ArrayList<int[]> partylist;
    static int max= Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        knows=new byte[N+1]; //0: 모름, 1: 과장된 내용으로 알고있음, 2: 진실을 알고있음
        st=new StringTokenizer(br.readLine());
        int P= Integer.parseInt(st.nextToken());
        for(int i=0; i<P; i++){
            knows[Integer.parseInt(st.nextToken())]=2;
        }
        // 파티
        partylist=new ArrayList<>();
        // 이친구는 만약 알고있는 사람이 검출되면 knows에 넣고 파티리스트에 참가시키지 않고, 아니면 파티리스트에 넣는 중간 버퍼 역할
        Stack<Integer> buffer=new Stack<>();
        for(int i=0; i<M; i++){
            boolean flag=false;
            st=new StringTokenizer(br.readLine());
            int invited= Integer.parseInt(st.nextToken());
            for(int j=0; j<invited; j++){
                int participant= Integer.parseInt(st.nextToken());
                buffer.add(participant);
                if(knows[participant]==2){
                    flag=true;
                }
            }
            if(flag){
                for(int j=0; j<invited; j++){
                    int participant=buffer.pop();
                    knows[participant]=2;
                }
            }else{
                int[] party=new int[invited];
                for(int j=0; j<invited; j++){
                    int participant=buffer.pop();
                    party[j]=participant;
                }
                partylist.add(party);
            }
        }
        //여기는 건너건너 알게되는 친구들을 포함해요
        boolean totalflag;
        do{
            totalflag=false;
            for(int i=0; i<partylist.size(); i++){
                boolean flag=false;
                int[] temp=partylist.get(i);
                for(int j=0; j<temp.length; j++){
                    if(knows[temp[j]]==2){
                        flag=true;
                        totalflag=true;
                    }
                }
                if(flag){
                    for(int j=0; j<temp.length; j++){
                        knows[temp[j]]=2;
                    }
                    partylist.remove(i);
                    i--;
                }
            }
        }while (totalflag);
        //이러면 순수하게 아무도 모르는 파티만이 남아요
        DFS(0, 0);
        System.out.println(max);
    }
    static void DFS(int depth, int count){
       if(depth==partylist.size()){
           max=Math.max(max,count);
           return;
       }
       boolean[] test=new boolean[3];
       for(int i=0; i<partylist.get(depth).length; i++){
           test[knows[partylist.get(depth)[i]]]=true;
       }
       if(test[1] && test[2]) return;
       if(test[0] && test[1]){
           Stack<Integer> temp=new Stack<>();
           for(int i=0; i<partylist.get(depth).length; i++){
               if(knows[partylist.get(depth)[i]]==0) temp.add(partylist.get(depth)[i]);
               knows[partylist.get(depth)[i]]=1;
           }
           DFS(depth+1, count+1);
           while(temp.isEmpty()) knows[partylist.get(depth)[temp.pop()]]=0;
           return;
       }
       if(test[0] && test[2]){
           Stack<Integer> temp=new Stack<>();
           for(int i=0; i<partylist.get(depth).length; i++){
               if(knows[partylist.get(depth)[i]]==0) temp.add(partylist.get(depth)[i]);
               knows[partylist.get(depth)[i]]=2;
           }
           DFS(depth+1, count);
           while(temp.isEmpty()) knows[partylist.get(depth)[temp.pop()]]=0;
           return;
       }
       if(test[0]){
           //거짓 말하기
           for(int i=0; i<partylist.get(depth).length; i++){
               knows[partylist.get(depth)[i]]=1;
           }
           DFS(depth+1, count+1);
           for(int i=0; i<partylist.get(depth).length; i++){
               knows[partylist.get(depth)[i]]=0;
           }
           //진실 말하기
           for(int i=0; i<partylist.get(depth).length; i++){
               knows[partylist.get(depth)[i]]=2;
           }
           DFS(depth+1, count);
           for(int i=0; i<partylist.get(depth).length; i++){
               knows[partylist.get(depth)[i]]=0;
           }
           return;
       }
       if(test[1]) DFS(depth+1, count+1);
       if(test[2]) DFS(depth+1, count);
    }
}
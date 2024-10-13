import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class room{
        PriorityQueue<String> playerlist=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for(int i=0; i<16; i++){
                    if(o1.length() <= i) {
                        return -1;
                    }
                    if(o2.length()<=i){
                        return 1;
                    }
                    if(o1.charAt(i)!=o2.charAt(i)) return o1.charAt(i)-o2.charAt(i);
                }
                return 0;
            }
        });
        int firstplayer;
        room(int level, String player){
            firstplayer=level;
            playerlist.add(player);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        st1=new StringTokenizer(br.readLine());
        int P=Integer.parseInt(st1.nextToken());
        int M=Integer.parseInt(st1.nextToken());
        Map<String, Integer> userMap =new HashMap<>();
        st1=new StringTokenizer(br.readLine());
        int lev=Integer.parseInt(st1.nextToken());
        String pla=st1.nextToken();
        userMap.put(pla, lev);
        ArrayList<room> roomlist=new ArrayList<>();
        roomlist.add(new room(lev, pla));

        outer:for(int i=1; i<P; i++){
            st1=new StringTokenizer(br.readLine());
            int level=Integer.parseInt(st1.nextToken());
            String player=st1.nextToken();
            userMap.put(player,level);
            // 방을 새로 파는가? 아니면 기존 방에 잡아주는가?
            for(room a:roomlist){
                if(Math.abs(a.firstplayer-level)<=10 && a.playerlist.size()<M){
                    a.playerlist.add(player);
                    continue outer;
                }
            }
            roomlist.add(new room(level, player));
        }
        for(room a:roomlist){
            if(a.playerlist.size()==M) System.out.println("Started!");
            else System.out.println("Waiting!");
            while(!a.playerlist.isEmpty()){
                String s=a.playerlist.poll();
                System.out.println(userMap.get(s)+" "+s);
            }
        }
    }
}
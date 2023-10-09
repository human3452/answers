import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.midi.Synthesizer;


public class Main {
	static final byte[] dx= {-1, 0, 1, 0};
	static final byte[] dy= {0, 1, 0, -1};
	static boolean[][] board;
	static int[] temp;
	static LinkedList<int[]> perm=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		final int[] cons= {0, 1, 4, 9, 16, 25};
		board=new boolean[10][10];
		int n=0;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(sc.nextInt()==1) {
					n++;
					board[i][j]=true;
				}
			}
		}
		//가능 조합 계산
		for(int i=0; i<=5; i++) {
			int p1=n-cons[5]*i;
			if(p1<0) break;
			for(int j=0; j<=5; j++) {
				int p2=p1-cons[4]*j;
				if(p2<0) break;
				for(int k=0; k<=5; k++) {
					int p3=p2-cons[3]*k;
					if(p3<0) break;
					for(int l=0; l<=5; l++) {
						int p4=p3-cons[2]*l;
						if(p4>=0 && p4<=5) {
							int[] pl= {p4, l, k, j, i, p4+l+k+j+i};
							perm.add(pl);
						}
					}
				}
			}
		}
		Collections.sort(perm, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				return p1[5]-p2[5];
			}
		});
		//시작
		while(!perm.isEmpty()) {
			temp=perm.pop();
			int pointer=4;
			search(pointer, 0);
		}
		System.out.println(-1);
	}
	private static void search(int pointer, int count) {
		if(pointer==0) {
			System.out.println(temp[5]);
			System.exit(0);
		}else if(temp[pointer]==count) {
			search(pointer-1, 0);
		}else {
		for(int i=0; i<10-pointer; i++) {
			for(int j=0; j<10-pointer; j++) {
				if(check(i,j,pointer)) {
					destory(i,j,pointer);
					search(pointer, count+1);
					restore(i, j, pointer);
				}
			}
		}
		}
	}
	private static void destory(int r, int c, int size) {
		for(int i=r; i<=r+size; i++) {
			for(int j=c; j<=c+size; j++) {
				board[i][j]=false;
			}
		}
	}
	private static void restore(int r, int c, int size) {
		for(int i=r; i<=r+size; i++) {
			for(int j=c; j<=c+size; j++) {
				board[i][j]=true;
			}
		}
		
	}
	
	private static boolean check(int r, int c, int size) {
		for(int i=r; i<=r+size; i++) {
			for(int j=c; j<=c+size; j++) {
				if(!board[i][j]) return false;
			}
		}
		return true;
	}
	
}
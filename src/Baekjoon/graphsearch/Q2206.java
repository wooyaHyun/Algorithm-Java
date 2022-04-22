/*
 * Baekjoon Algorithm
 * Category	: Back Traking
 * Question	: 2206
 * Title	: 벽부수고 이동하기
 */
package Baekjoon.graphsearch;

import java.util.*;

public class Q2206 {

    static int n;
    static int m ;
    static int[][] mat;
    static boolean[][][]visited;
    static int[] mx = {1, -1, 0, 0};
    static int[] my = { 0, 0, 1, -1};
    static int answer;

    public static void wallBfs(int x, int y){
        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(0, 0, 0, 0));
        visited[x][y][0] = true;

        while(!q.isEmpty()){
            Location lc = q.poll();
            int tmpX = lc.x;
            int tmpY = lc.y;
            int tmpFlg = lc.flag;

            if(tmpX == n-1 && tmpY == m-1){
                answer = lc.cnt +1;
                return;
            }

            for(int i = 0; i < 4; i++){
                int xx = tmpX + mx[i];
                int yy = tmpY+ my[i];

                if( xx >= 0 && yy >= 0 && xx < n && yy < m){
                    int tmpCnt = lc.cnt +1;

                    if(mat[xx][yy] == 0){ //공간
                        if(tmpFlg == 0 && !visited[xx][yy][0]){ //벽깬적 없음
                            q.offer(new Location(xx,yy, 0, tmpCnt));
                            visited[xx][yy][0] = true;
                        }else if(tmpFlg== 1 && !visited[xx][yy][1]){// 벽깬적 있음
                            q.offer(new Location(xx,yy, 1, tmpCnt));
                            visited[xx][yy][1] = true;
                        }
                    }else if(mat[xx][yy] == 1){//벽
                        if(tmpFlg == 0){
                            q.offer(new Location(xx,yy, 1, tmpCnt));
                            visited[xx][yy][1] = true;
                        }
                    }
                }

            }

        }

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        mat = new int[n][m];
        visited = new boolean[n][m][2];
        for(int i = 0; i < n; i++){
            String str = sc.next();
            for(int j = 0; j < m; j++){
                mat[i][j]= str.charAt(j) - '0';
            }
        }

        answer = 0;
        wallBfs(0,0);
        if(answer == 0){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

}

class Location{
    int x, y, flag, cnt;
    public Location(int x,int y, int flag, int cnt){
        this.x = x;
        this.y = y;
        this.flag = flag;
        this.cnt = cnt;
    }
}

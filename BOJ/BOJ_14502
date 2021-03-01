import java.util.*;

class Main {
    public static int n;
    public static int m;
    public static int[][] graph;
    public static int[][] copiedGraph;
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static XY[] zeroXY;
    public static boolean[] visited;
    public static int zeroNum;

    public static int answer = 0;
    
    public static class XY {
        int x, y;
        
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] inputData = sc.nextLine().split(" ");
            
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(inputData[j]);
            }
        }
        
        solve();
        
        System.out.println(answer);
    }
    
    public static void solve() {
        copiedGraph = new int[n][m];
        copyGraph();

        zeroNum = countSafeArea();
        zeroXY = new XY[zeroNum];
        visited = new boolean[zeroNum];

        int index = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 0) {
                    zeroXY[index] = new XY(i, j);
                    index++;
                }
            }   
        }

        installWall(3, 0, 0);
    }
    
    public static void installWall(int targetDepth, int depth, int at) {
        if(depth == targetDepth) {
            copyGraph();

            for(int i = 0; i < zeroNum; i++) {
                if(visited[i]) {
                    XY xy = zeroXY[i];
                    copiedGraph[xy.x][xy.y] = 1;
                }
            }

            spreadVirus();

            answer = Math.max(answer, countSafeArea());

            return;
        }
        
        for(int i = at; i < zeroNum; i++) {
            if(!visited[i]) {
                visited[i] = true;
                installWall(targetDepth, depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void copyGraph() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copiedGraph[i][j] = graph[i][j];
            }
        }
    }
    
    public static void spreadVirus() {
        Queue<XY> queue = new LinkedList<XY>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copiedGraph[i][j] == 2) queue.add(new XY(i, j));
            }
        }
        
        while(!queue.isEmpty()) {
            XY xy = queue.poll();
            int x = xy.x;
            int y = xy.y;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(copiedGraph[nx][ny] == 1 || copiedGraph[nx][ny] == 2) continue;
                
                copiedGraph[nx][ny] = 2;
                
                queue.add(new XY(nx, ny));
            }
        }
    }
    
    public static int countSafeArea() {
        int safeArea = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copiedGraph[i][j] == 0) safeArea++;
            }
        }
        
        return safeArea;
    }
}
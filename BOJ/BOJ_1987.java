import java.util.*;

class Main {
    public static int r, c;
    public static int[][] graph;
    public static boolean[] visited = new boolean[26];
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static int result;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        
        graph = new int[r][c];
        for(int i = 0; i < r; i++) {
            String inputData = sc.nextLine();
            for(int j = 0; j < c; j++) {
                graph[i][j] = inputData.charAt(j) - 'A';
            }
        }
        
        dfs(0, 0, 0);
        
        System.out.println(result);
    }

    public static void dfs(int x, int y, int count) {
        if(visited[graph[x][y]]) {
            result = Math.max(result, count);
            return;
        }
        
        visited[graph[x][y]] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(!isValid(nx, ny)) continue;
            
            dfs(nx, ny, count + 1);
        }
        visited[graph[x][y]] = false;
    }
    
    public static boolean isValid(int x, int y) {
        if(x < 0 || x >= r) return false;
        if(y < 0 || y >= c) return false;
        
        return true;
    }
}
import java.util.*;

class Main {
    public static int itemNum, weightCapa;
    
    public static int[][] memo;
    public static int[] weights;
    public static int[] values;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        itemNum = sc.nextInt();
        weightCapa = sc.nextInt();
        sc.nextLine();
        
        memo = new int[itemNum + 1][weightCapa + 1];
        weights = new int[itemNum + 1];
        values = new int[itemNum + 1];
        
        for(int i = 1; i <= itemNum; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
            sc.nextLine();
        }
        
        for(int i = 1; i <= itemNum; i++) {
            for(int j = 1; j <= weightCapa; j++) {
                memo[i][j] = memo[i - 1][j];
                
                if(j - weights[i] >= 0) {
                    memo[i][j] = Math.max(memo[i][j], memo[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        
        System.out.println(memo[itemNum][weightCapa]);
    }
}
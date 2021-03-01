dimport java.util.*;

class Main {
    public static char[] chars;
    public static boolean[] isVowel;
    
    public static char[] arr;
    public static boolean[] visited;
    
    public static ArrayList<String> results = new ArrayList<String>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int passLen = sc.nextInt();
        int charNum = sc.nextInt();
        sc.nextLine();
        
        chars = new char[charNum];
        String[] inputData = sc.nextLine().split(" ");
        for(int i = 0; i < charNum; i++) {
            chars[i] = inputData[i].charAt(0);
        }
        
        Arrays.sort(chars);
        
        isVowel = new boolean[charNum];
        for(int i = 0; i < charNum; i++) {
            int temp = (int) (chars[i] - 'a');
            if(temp == 0 || temp == 4 || temp == 8 || temp == 14 || temp == 20) isVowel[i] = true;
            else isVowel[i] = false;
        }
        
        arr = new char[passLen];
        visited = new boolean[charNum];
        for(int cNum = 2; cNum <= passLen - 1; cNum++) {
            dfs(cNum, passLen - cNum, charNum, passLen, 0, 0, 0);
        }
        
        Collections.sort(results);
        
        for(int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
    
    public static void dfs(int cNum, int vNum, int charNum, int passLen, int con, int vow, int at) {
        if(con == cNum && vow == vNum) {
            char[] temp = new char[passLen];
            int index = 0;
            
            for(int i = 0; i < charNum; i++) {
                if(visited[i]) {
                    temp[index] = chars[i];
                    index++;
                }
            }
            
            results.add(new String(temp));
            
            return;
        }
        
        for(int i = at; i < charNum; i++) {
            if(!visited[i]) {
                if(isVowel[i] && vow < vNum) {
                    visited[i] = true;
                    dfs(cNum, vNum, charNum, passLen, con, vow + 1, i + 1);
                    visited[i] = false;
                }
            
                else if(!isVowel[i] && con < cNum) {
                    visited[i] = true;
                    dfs(cNum, vNum, charNum, passLen, con + 1, vow, i + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
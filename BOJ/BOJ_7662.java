import java.util.*;

class Main {
    public static class Min implements Comparable<Min> {
        int index;
        long value;

        public Min(int index, long value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Min other) {
            if(this.value > other.value) return 1;
            else return -1;
        }
    }

    public static class Max implements Comparable<Max> {
        int index;
        long value;

        public Max(int index, long value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Max other) {
            if(this.value < other.value) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
        
        int bigN = sc.nextInt();
        sc.nextLine();
        
        long smallN;
        int command;
        long comNum;

        boolean[] visited;
        
        for(int i = 0; i < bigN; i++) {
            smallN = sc.nextLong();
            sc.nextLine();

            PriorityQueue<Max> pqMax = new PriorityQueue<Max>();
            PriorityQueue<Min> pqMin = new PriorityQueue<Min>();
            visited = new boolean[(int) smallN];

            for(int j = 0; j < smallN; j++) {
                command = (int) (sc.next().charAt(0) - 'I');
                comNum = sc.nextLong();
                sc.nextLine();
                
                if(command == 0) {
                    pqMax.add(new Max(j, comNum));
                    pqMin.add(new Min(j, comNum));

                    continue;
                }

                if(!pqMax.isEmpty() && comNum == 1) {
                    while(!pqMax.isEmpty()) {
                        Max m = pqMax.peek();

                        if(visited[m.index]) pqMax.poll();
                        else {
                            pqMax.poll();
                            visited[m.index] = true;
                            break;
                        }
                    }
                }

                if(!pqMin.isEmpty() && comNum == -1) {
                    while(!pqMin.isEmpty()) {
                        Min m = pqMin.peek();

                        if(visited[m.index]) pqMin.poll();
                        else {
                            pqMin.poll();
                            visited[m.index] = true;
                            break;
                        }
                    }
                }
            }
            
            while(!pqMax.isEmpty()) {
                if(!visited[pqMax.peek().index]) break;

                pqMax.poll();
            }

            while(!pqMin.isEmpty()) {
                if(!visited[pqMin.peek().index]) break;

                pqMin.poll();
            }
            
            if(pqMax.isEmpty() || pqMin.isEmpty()) {
                sb.append("EMPTY\n");
            }
            
            else {
                sb.append(pqMax.peek().value + " " + pqMin.peek().value + "\n");
            }
        }

        System.out.print(sb.toString());
    }
}
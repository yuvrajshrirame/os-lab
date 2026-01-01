import java.util.Scanner;

public class diskscheduling_sstf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();

        int[] req = new int[n];
        boolean[] visited = new boolean[n];

        System.out.print("Enter current head position: ");
        int head = sc.nextInt();

        System.out.println("Enter the request sequence:");
        for (int i = 0; i < n; i++) {
            req[i] = sc.nextInt();
        }

        int totalMovement = 0;

        System.out.println("\nOrder of service:");
        System.out.print(head);

        for (int count = 0; count < n; count++){            
            int idx = -1;
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(req[i] - head);

                    if (distance < minDist) {
                        minDist = distance;
                        idx = i;
                    }
                }
            }

            visited[idx] = true;
            totalMovement += minDist;
            head = req[idx];

            System.out.print(" -> " + head);
        }

        System.out.println("\n\nTotal Head Movement = " + totalMovement + " cylinders");

        sc.close();
    
    }
}

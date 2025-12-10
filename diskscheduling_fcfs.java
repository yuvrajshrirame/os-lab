import java.util.Scanner;

public class diskscheduling_fcfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();
        
        System.out.print("Enter current head position: ");
        int head = sc.nextInt();

        int req[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter track No. " + (i + 1) + ": ");
            req[i] = sc.nextInt();
        }

        int totalMovement = 0;
        System.out.println("Order of service: ");
        System.out.print(head);

        for(int i = 0; i < n; i++){
            int distance = Math.abs(req[i] - head);
            totalMovement += distance;
            head = req[i];
            System.out.print(" -> " + head);
        }

        System.out.println("\nTotal head movement: " + totalMovement);

        sc.close();
    }
}

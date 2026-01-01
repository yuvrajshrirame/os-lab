import java.util.Arrays;
import java.util.Scanner;

public class diskscheduling_cscan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();

        int[] req = new int[n];

        System.out.print("Enter current head position: ");
        int head = sc.nextInt();

        System.out.print("Enter maximum cylinder number: "); 
        int maxCyl = sc.nextInt();

        System.out.println("Enter request sequence:");
        for (int i = 0; i < n; i++) {
            req[i] = sc.nextInt();
        }

        Arrays.sort(req);

        int totalMovement = 0;
        int pos = head;

        System.out.println("\nOrder of service:");
        System.out.print(head);

        for (int i = 0; i < n; i++) {
            if (req[i] >= head) {
                totalMovement += Math.abs(req[i] - pos);
                pos = req[i];
                System.out.print(" -> " + pos);
            }
        }

        totalMovement += Math.abs(maxCyl - pos);
        pos = maxCyl;
        System.out.print(" -> " + pos);

        totalMovement += Math.abs(maxCyl - 0);
        pos = 0;
        System.out.print(" -> " + pos);

        for (int i = 0; i < n; i++) {
            if (req[i] < head) {
                totalMovement += Math.abs(req[i] - pos);
                pos = req[i];
                System.out.print(" -> " + pos);
            }
        }

        System.out.println("\n\nTotal Head Movement = " + totalMovement + " cylinders");

        sc.close();
    }
}

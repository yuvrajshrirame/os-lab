import java.util.Arrays;
import java.util.Scanner;

public class diskscheduling_clook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk requests: ");
        int n = sc.nextInt();

        int[] req = new int[n];

        System.out.print("Enter current head position: ");
        int head = sc.nextInt();

        System.out.println("Enter request sequence:");
        for (int i = 0; i < n; i++) {
            req[i] = sc.nextInt();
        }

        System.out.print("Enter direction (1 = right/up, 0 = left/down): ");
        int direction = sc.nextInt();

        Arrays.sort(req);

        int totalMovement = 0;
        int pos = head;

        System.out.println("\nOrder of service:");
        System.out.print(head);

        if (direction == 1) {
            for (int i = 0; i < n; i++) {
                if (req[i] >= head) {
                    totalMovement += Math.abs(req[i] - pos);
                    pos = req[i];
                    System.out.print(" -> " + pos);
                }
            }

            for (int i = 0; i < n; i++) {
                if (req[i] < head) {
                    totalMovement += Math.abs(pos - req[0]);
                    pos = req[0];
                    System.out.print(" -> " + pos);
                    break;
                }
            }

            for (int i = 1; i < n; i++) {
                if (req[i] < head) {
                    totalMovement += Math.abs(req[i] - pos);
                    pos = req[i];
                    System.out.print(" -> " + pos);
                }
            }
        }

        else {

            for (int i = n - 1; i >= 0; i--) {
                if (req[i] <= head) {
                    totalMovement += Math.abs(req[i] - pos);
                    pos = req[i];
                    System.out.print(" -> " + pos);
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (req[i] > head) {
                    totalMovement += Math.abs(pos - req[n - 1]);
                    pos = req[n - 1];
                    System.out.print(" -> " + pos);
                    break;
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                if (req[i] > head) {
                    totalMovement += Math.abs(req[i] - pos);
                    pos = req[i];
                    System.out.print(" -> " + pos);
                }
            }
        }

        System.out.println("\n\nTotal Head Movement = " + totalMovement + " cylinders");

        sc.close();
    }   
}

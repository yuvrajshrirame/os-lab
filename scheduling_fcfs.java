import java.util.Scanner;

public class scheduling_fcfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] at = new int[n];
        int[] bt = new int[n];
        int[] pid = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter arrival times:");
        for (int i = 0; i < n; i++) {
            System.out.print("AT for P" + (i + 1) + ": ");
            at[i] = sc.nextInt();
            pid[i] = i + 1;
        }

        System.out.println("Enter burst times:");
        for (int i = 0; i < n; i++) {
            System.out.print("BT for P" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (at[j] > at[j + 1]) {
                    int temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;

                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }

        int time = 0;
        float sumTAT = 0;
        float sumWT = 0;

        for (int i = 0; i < n; i++) {
            if (time < at[i]) {
                time = at[i];
            }

            time += bt[i];
            ct[i] = time;

            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];

            sumTAT += tat[i];
            sumWT += wt[i];
        }

        System.out.println();
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.printf(
                    "P%-2d\t%-2d\t%-2d\t%-2d\t%-2d\t%-2d%n",
                    pid[i], at[i], bt[i], ct[i], tat[i], wt[i]
            );
        }

        System.out.println();
        System.out.printf("Average TAT: %.2f%n", sumTAT / n);
        System.out.printf("Average WT : %.2f%n", sumWT / n);
        
        sc.close();
    }
}

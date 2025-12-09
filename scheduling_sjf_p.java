import java.util.Scanner;

public class scheduling_sjf_p {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] pid = new int[n]; // process id
        int[] at  = new int[n]; // arrival time
        int[] bt  = new int[n]; // burst time
        int[] ct  = new int[n]; // completion time
        int[] tat = new int[n]; // turn around time
        int[] wt  = new int[n]; // waiting time
        boolean[] done = new boolean[n]; // completed flag

        // Input
        System.out.println("Enter arrival times:");
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.print("AT for P" + pid[i] + ": ");
            at[i] = sc.nextInt();
        }

        System.out.println("Enter burst times:");
        for (int i = 0; i < n; i++) {
            System.out.print("BT for P" + pid[i] + ": ");
            bt[i] = sc.nextInt();
        }

        int time = 0;       // current time
        int completed = 0;  // number of completed processes
        float sumTAT = 0;
        float sumWT = 0;

        // SJF (Non-preemptive) scheduling
        while (completed < n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            // find the process with minimum burst time among arrived processes
            for (int i = 0; i < n; i++) {
                if (!done[i] && at[i] <= time && bt[i] < minBT) {
                    minBT = bt[i];
                    idx = i;
                }
                // optional tie-breaker: if same BT, pick lower arrival time / PID
                else if (!done[i] && at[i] <= time && bt[i] == minBT) {
                    if (at[i] < at[idx]) {
                        idx = i;
                    }
                }
            }

            if (idx == -1) {
                // no process has arrived yet at this time → CPU idle
                time++;
            } else {
                // execute the selected process non-preemptively
                time += bt[idx];
                ct[idx] = time;
                tat[idx] = ct[idx] - at[idx];
                wt[idx] = tat[idx] - bt[idx];

                sumTAT += tat[idx];
                sumWT += wt[idx];

                done[idx] = true;
                completed++;
            }
        }

        // Output
        System.out.println();
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%-2d\t%-2d\t%-2d\t%-2d\t%-2d\t%-2d%n",
                    pid[i], at[i], bt[i], ct[i], tat[i], wt[i]);
        }

        System.out.println();
        System.out.printf("Average TAT: %.2f%n", sumTAT / n);
        System.out.printf("Average WT : %.2f%n", sumWT / n);

        sc.close();
    }
}
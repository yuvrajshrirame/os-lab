import java.util.Scanner;

public class scheduling_sjf_p {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] pid = new int[n];
        int[] at  = new int[n];
        int[] bt  = new int[n];
        int[] rt  = new int[n];
        int[] ct  = new int[n];
        int[] tat = new int[n];
        int[] wt  = new int[n];

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
            rt[i] = bt[i];
        }

        int time = 0;
        int completed = 0;
        float sumTAT = 0;
        float sumWT = 0;

        while (completed < n) {

            int idx = -1;
            int minRT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0 && rt[i] < minRT) {
                    minRT = rt[i];
                    idx = i;
                }
                else if (at[i] <= time && rt[i] > 0 && rt[i] == minRT && idx != -1) {
                    if (at[i] < at[idx]) {
                        idx = i;
                    } else if (at[i] == at[idx] && pid[i] < pid[idx]) {
                        idx = i;
                    }
                }
            }

            if (idx == -1) {
                time++;
            } else {
                rt[idx]--;
                time++;

                if (rt[idx] == 0) {
                    completed++;
                    ct[idx] = time;
                    tat[idx] = ct[idx] - at[idx];
                    wt[idx] = tat[idx] - bt[idx];

                    sumTAT += tat[idx];
                    sumWT += wt[idx];
                }
            }
        }

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

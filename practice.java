import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];

        // inputs
        for(int i = 0; i < n; i++){
            System.out.print("AT for P" + (i + 1) + ": ");
            pid[i] = i+1;
            at[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            System.out.print("BT for P" + (i + 1) + ": ");
            bt[i] = sc.nextInt();
        }

        // sorting
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(at[j] > at[j + 1]){
                    int temp = at[j];
                    at[j] = at[j+1];
                    at[j+1] = temp;

                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;

                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;
                }
            }
        }

        // calculate CT, TAT, WT

        int time = 0;
        float sumTAT = 0, sumWT = 0;

        for(int i = 0; i < n; i++){
            if(at[i] > time){
                time = at[i];
            }

            time += bt[i];
            ct[i] = time;

            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];

            sumTAT += tat[i];
            sumWT += wt[i];
        }

        // output table

        System.out.println();
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for(int i = 0; i < n; i++){
            System.out.printf("P%-2d\t%-2d\t%-2d\t%-2d\t%-2d\t%-2d%n", pid[i], at[i], bt[i], ct[i], tat[i], wt[i]);
        }

        System.out.println();

        System.out.println("Avg. TAT: " + sumTAT/n);
        System.out.println("Avg. WT: " + sumWT/n);



        sc.close();
    }
}
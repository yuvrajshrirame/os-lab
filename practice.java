import java.util.Scanner;

public class practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of processes: ");
        int n = sc.nextInt();

        int[] pid = new int[n];
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        boolean[] done = new boolean[n];

        for(int i = 0; i < n;i++){
            pid[i] = i + 1;
            System.out.print("AT for P" + pid[i] + ": ");
            at[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            System.out.print("BT for P" + pid[i] +": ");
            bt[i] = sc.nextInt();
        }

        int time = 0;
        int completed = 0;
        float sumTAT = 0;
        float sumWT = 0;

        while(completed < n){
            
        }

    }
}
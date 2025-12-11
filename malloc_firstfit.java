import java.util.Scanner;

public class malloc_firstfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of memory blocks: ");
        int m = sc.nextInt();

        int[] blockSize = new int[m];
        System.out.println("Enter size of each block:");
        for (int i = 0; i < m; i++) {
            blockSize[i] = sc.nextInt();
        }

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] processSize = new int[n];
        System.out.println("Enter size of each process:");
        for (int i = 0; i < n; i++) {
            processSize[i] = sc.nextInt();
        }

        int[] allocation = new int[n];  // stores block number for each process
        for (int i = 0; i < n; i++) {
            allocation[i] = -1;          // default: not allocated
        }

        // FIRST FIT ALGORITHM
        for (int i = 0; i < n; i++) {            // for each process
            for (int j = 0; j < m; j++) {        // check each block
                if (blockSize[j] >= processSize[i]) {
                    allocation[i] = j;           // allocate block j
                    blockSize[j] -= processSize[i]; // reduce block size
                    break;                       // stop after first fit
                }
            }
        }

        // Output Result
        System.out.println("\nProcess\tSize\tBlock");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i+1) + "\t" + processSize[i] + "\t");
            if (allocation[i] != -1)
                System.out.println(allocation[i] + 1);
            else
                System.out.println("Not Allocated");
        }

        sc.close();
    }
}

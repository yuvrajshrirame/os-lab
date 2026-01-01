import java.util.Arrays;

public class diskscheduling_clook2 {
    public static void main(String[] args) {

        int[] req = {82, 170, 43, 140, 24, 16, 190};
        int head = 50;

        Arrays.sort(req);

        int total = 0;
        int current = head;

        for (int r : req) {
            if (r >= head) {
                total += Math.abs(r - current);
                current = r;
            }
        }

        for (int r : req) {
            if (r < head) {
                total += Math.abs(r - current);
                current = r;
            }
        }

        System.out.println("Total Head Movement = " + total);
    }
}
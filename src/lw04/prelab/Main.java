package lw04.prelab;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt();
        int[] branches = new int[n];

        for (int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];

        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }
        sc.close();

        int passes = 3;
        for (int i = 1; i <= passes && i < n; i++) {
            int key = branches[i];
            int j = i - 1;
            while (j >= 0 && branches[j] < key) {
                branches[j + 1] = branches[j];
                j--;
            }
            branches[j + 1] = key;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(branches[i] + (i == n-1 ? "" : " "));
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int targets = target[i];
            int found = -1;
            for (int j = 0; j < n; j++) {
                if (branches[j] == targets) {
                    found = j;
                    break;
                }
            }
            if (found != -1) {
                System.out.println(targets + ": FOUND at index " + found);
            } else {
                System.out.println(targets + ": NOT FOUND");
            }
        }
 
    }
}

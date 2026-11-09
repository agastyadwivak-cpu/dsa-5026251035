package lw04.Unguided;
import java.util.*;
public class Main {

public static void selectionSort(int[] arr, int passes) {
        int n = arr.length;
        for (int i = 0; i < passes && i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

    int n = sc.nextInt();
    int[] cards = new int[n];

    for (int i = 0; i < n; i++) {
        cards[i] = sc.nextInt();
    }

    int m = sc.nextInt();
    int[] target = new int[m];

    for (int i = 0; i < m; i++) {
        target[i] = sc.nextInt();
    }
    sc.close();

    int passes = 2;

    selectionSort(cards, passes);

    for (int i = 0; i < n; i++) {
        System.out.print(cards[i] + (i == n - 1 ? "" : " "));
    }
    System.out.println();

    for (int i = 0; i < m; i++) {
        int targets = target[i];
        int found = linearSearch(cards, targets);
        if (found != -1) {
            System.out.println(targets + ": FOUND at index " + found);
        } else {
            System.out.println(targets + ": NOT FOUND");
        }
    }
}    
}

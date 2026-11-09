package Latihan;

import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        int [] num = {5, 9, 8, 7, 2, 1, 4, 3, 6};

        // bubblesort(num);
        insertionsort(num);

        System.out.println(Arrays.toString(num));
    }
    // public static int [] bubblesort(int [] n){
    //     for (int i = n.length - 1 ; i > 0; i--){
    //         for (int j = 0; j < i ; j++){
    //             if (n[j+1] < n[j]){
    //                 int temp = n[j];
    //                 n[j] = n[j+1];
    //                 n[j+1] = temp;
    //             }
    //         }
    //     }
    //     return n;
    // }

    // public static int [] selectionsort(int [] n){
    //     for (int i = 0; i < n.length - 1; i++){
    //         int max = i;
    //         for (int j = i + 1; j < n.length; j++){
    //             if (n[j] > n[max]){
    //                 max = j;
    //             }
    //         }
    //         int temp = n[i];
    //         n[i] = n[max];
    //         n[max] = temp;
    //     }
    //     return n;
    // }
//}

// int [] num = {5, 9, 8, 7, 2, 1, 4, 3, 6};
public static int [] insertionsort(int [] n){
    for (int i = 1; i < n.length; i++){
        int temp = n[i];
        int j = i - 1;
        while (j >= 0 && n[j] > temp){
            n[j + 1] = n[j];
            j--;
        }
        n[j + 1] = temp;
    }
    return n;
}
}

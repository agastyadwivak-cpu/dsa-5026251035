package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        
        // Write your main code here
        
        BinarySearchTree bst = new BinarySearchTree();

        if (read.hasNextLine()) {
            Scanner lineScanner = new Scanner(read.nextLine());
            while (lineScanner.hasNextInt()) {
                bst.insert(lineScanner.nextInt());
            }
            lineScanner.close();
        }

        int target = 0;
        while (read.hasNextInt()) {
            target = read.nextInt();
        }

        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder : ");
        bst.postOrder();
        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

        read.close();
    }
}
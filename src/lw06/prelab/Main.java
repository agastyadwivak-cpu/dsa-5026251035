package lw06.prelab;

import java.util.Scanner;

public class Main {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.root) {
            root.left = insert(root.left, data);
        } else if (data > root.root) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.root == target) {
            return true;
        } else if (target < root.root) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.root + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.root + " ");
            inorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.root + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here
        Node root = null;
        String[] numbers = sc.nextLine().split(" ");

        for (String number : numbers) {
            root = insert(root, Integer.parseInt(number));
        }

        int target = sc.nextInt();

        System.out.print("Preorder : ");
        preorder(root);
        System.out.print("\nInorder  : ");
        inorder(root);
        System.out.print("\nPostorder: ");
        postorder(root);
        System.out.println("\nSearch " + target + ": " + search(root, target));

        sc.close();
    }
}


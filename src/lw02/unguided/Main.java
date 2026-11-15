package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> borrowingList = new LinkedList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        while (scanner.hasNext()) {
            String name = scanner.next();
            String book_title = scanner.next();
            borrowingList.add(new String[]{name, book_title});
        }
        scanner.close();

        LinkedList<String[]> bookList = new LinkedList<>();
        bookList.add(new String[]{"Kalkulus", "2"});
        bookList.add(new String[]{"Fisika", "1"});
        bookList.add(new String[]{"Statistika", "2"});

        LinkedList<String[]> memberList = new LinkedList<>();
        for (String[] borrowing : borrowingList) {
            String name = borrowing[0];
            boolean exists = false;
            for (String[] member : memberList) {
                if (member[0].equals(name)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                memberList.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> borrowingQueue = new LinkedList<>(borrowingList);
        Stack<String[]> failedStack = new Stack<>();
        LinkedList<String[]> SuccessList = new LinkedList<>();
        int maxBorrow = 2;

        while (!borrowingQueue.isEmpty()){
            String[] borrowing = borrowingQueue.poll();
            String name = borrowing[0];
            String book_title = borrowing[1];

            String[] book = null;
            for (String[] currentBook : bookList) {
                if (currentBook[0].equals(book_title)) {
                    book = currentBook;
                    break;
                }
            }

            String[] member = null;
            for (String[] currentMember : memberList) {
                if (currentMember[0].equals(name)) {
                    member = currentMember;
                    break;
                }
            }
            int stock = Integer.parseInt(book[1]);
            int borrowedCount = Integer.parseInt(member[1]);
            
            if (stock > 0 && borrowedCount < maxBorrow) {
                stock--;
                borrowedCount++;
                book[1] = String.valueOf(stock);
                member[1] = String.valueOf(borrowedCount);
                SuccessList.add(new String[]{name, book_title});
            } else {
                failedStack.push(borrowing);
            }          
        }
        System.out.println("=== Successfully Processed Requests ===");
        for (String[] success : SuccessList) {
            System.out.println(success[0] + " " + success[1]);
        }
        System.out.println();
        System.out.println("=== Remaining Book Stock ===");
        for (String[] books : bookList) {
            System.out.println(books[0] + ": " + books[1]);
        }
        System.out.println();
        System.out.println("=== Failed Requests ===");
        while (!failedStack.isEmpty()) {
            String[] failedBorrowing = failedStack.pop();
            System.out.println(failedBorrowing[0] + " " + failedBorrowing[1]);
        }
    }        
}

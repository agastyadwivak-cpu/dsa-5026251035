package lw02.prelab;

import java.util.*;

public class BankTransactionProcessor {
    public static void main(String[] args) {
        LinkedList<String[]> transactionList = new LinkedList<>();
        try (Scanner scanner = new Scanner(BankTransactionProcessor.class.getResourceAsStream("transactions.txt"))){
            while (scanner.hasNext()){
                String name = scanner.next();
                String type = scanner.next();
                String amount = scanner.next();
                transactionList.add(new String[]{name, type, amount});
            }
        } catch (Exception e) {
            System.out.println("file tidak ditemukan");
        }
        LinkedList<String[]> customerList = new LinkedList<>();
        for (String[] transaction : transactionList) {
            String name = transaction[0];
            boolean exists = false;
            for (String[] customer : customerList) {
                if (customer[0].equals(name)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                customerList.add(new String[]{name, "0"});
            }
        }
        Queue<String[]> transactionQueue = new LinkedList<>(transactionList);
            Stack<String[]> failedStack = new Stack<>();

            while(!transactionQueue .isEmpty()){
              String[]transaction = transactionQueue.poll();
              String name = transaction[0];
              String type = transaction[1];
              int amount = Integer.parseInt(transaction[2]);
              
              String[] customer = null;
              for (String[] currentC : customerList) {
                  if (currentC[0].equals(name)) {
                      customer = currentC;
                      break;
                  }
              }
              if(customer != null){
                  int balance = Integer.parseInt(customer[1]);
                  if(type.equals("DEPOSIT")){
                      balance += amount;
                      customer[1] = String.valueOf(balance);
                  } else if(type.equals("WITHDRAW")){
                      if(balance >= amount){
                          balance -= amount;
                          customer[1] = String.valueOf(balance);
                      } else {
                          failedStack.push(transaction);
                      }
                  }
              }
            }
            System.out.println("=== Final Balances ===");
            for (String[] customer : customerList) {
                System.out.println(customer[0] + ": " + customer[1]);
            }

            System.out.println("=== Failed Transactions ===");
            while(!failedStack.isEmpty()){
                String[] failedTransaction = failedStack.pop();
                System.out.println(failedTransaction[0] + " " + failedTransaction[1] + " " + failedTransaction[2]);
            }
    }   

            
}

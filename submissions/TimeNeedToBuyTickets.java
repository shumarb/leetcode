// Question: https://leetcode.com/problems/time-needed-to-buy-tickets/description/

class Solution {
    private Queue<Person> queue;

    public int timeRequiredToBuy(int[] tickets, int k) {
        boolean isTest = false;
        int count = 0;
        queue = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            if (i == k) {
                queue.offer(new Person(true, tickets[i]));
            } else {
                queue.offer(new Person(false, tickets[i]));
            }
        }
        if (isTest) {
            display();
        }

        while (!queue.isEmpty()) {
            Person top = queue.poll();
            top.decrementCountTicket();
            count++;
            if (top.countTicket > 0) {
                queue.offer(top);
            }
            if (top.countTicket == 0 && top.isCheck == true) {
                break;
            }
            if (isTest) {
                display();
            }
        }
        if (isTest) {
            display();
            System.out.println("count: " + count);
        }

        return count;
    }

    private void display() {
        System.out.println("queue:");
        for (Person e: queue) {
            System.out.println(" * (" + e.isCheck + ", " + e.countTicket + ")");
        }
        System.out.println("------------------------------------");
    }
}

class Person {
    boolean isCheck;
    int countTicket = 0;

    public Person(boolean isCheck, int countTicket) {
        this.isCheck = isCheck;
        this.countTicket = countTicket;
    }

    public void decrementCountTicket() {
        countTicket--;
    }
}
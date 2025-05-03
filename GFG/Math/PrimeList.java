public class PrimeList {
    /*
     * You are given the head of a linked list. 
     * You have to replace all the values of the nodes with the nearest prime number. 
     * If more than one prime number exists at an equal distance, choose the smallest one.
     *  Return the head of the modified linked list.
     */

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Solution {
    Node primeList(Node head) {
        Node temp = head;
        while (temp != null) {
            int nearestPrime = findNearestPrime(temp.val);
            temp.val = nearestPrime;
            temp = temp.next;
        }
        return head;
    }

    int findNearestPrime(int n) {
        if (n < 2)
            return 2; 
        int lower = n, upper = n;
        while (!isPrime(lower) && lower > 1) {
            lower--;
        }
        while (!isPrime(upper)) {
            upper++;
        }
        return (n - lower <= upper - n) ? lower : upper;
    }
    
    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
}

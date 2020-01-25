import java.util.Iterator;

import PriorityQueue.SortedListPriorityQueue;
import Tree.LinkedBinaryTree;

class run {
    public static void main(String[] args) {
        try {
            SortedListPriorityQueue<Integer,String> temp = new SortedListPriorityQueue<>();
            temp.insert(5, "A");
            System.out.println(temp);
            temp.insert(9, "C");
            System.out.println(temp);
            temp.insert(3, "B");
            System.out.println(temp);
            temp.insert(7, "D");
            System.out.println(temp);
            System.out.println(temp.min());
            temp.removeMin();
            System.out.println(temp);
            System.out.println(temp.size());
            temp.removeMin();
            temp.removeMin();
            temp.removeMin();
            System.out.println(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


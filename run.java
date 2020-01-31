import java.util.Comparator;
import java.util.Random;

import List.DoublyLinkedList;

class SortInt implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        
        return o1.compareTo(o2);
    }
    
}

class run {
    public static void main(String[] args) {
        Integer[] temp = new Integer[10];
        Random rand = new Random();
        for(int i=0;i<10;i++){
            temp[i] = rand.nextInt(100);
        }
        for(Integer x : temp){
            System.out.print(x+" ");
        }
        System.out.println();
        MergeSortArrayBased.mergeSort(temp, new SortInt());
        for(Integer x : temp){
            System.out.print(x+" ");
        }
    }
}


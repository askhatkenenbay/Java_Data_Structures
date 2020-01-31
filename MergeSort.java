import java.util.Comparator;

import List.DoublyLinkedList;

public class MergeSort<E> {
    public static <E> void mergeSort(DoublyLinkedList<E> list, Comparator<E> comparator){
        int size = list.getSize();
        if( size == 1 ){
            return;     //trivially sorted
        }
        DoublyLinkedList<E> listOne = new DoublyLinkedList<>();
        DoublyLinkedList<E> listTwo = new DoublyLinkedList<>();
        int i = 0;
        while ( i < size / 2 ){
            listOne.addLast(list.removeFirst());
            i++;
        }
        while( !list.isEmpty()){
            listTwo.addLast(list.removeFirst());
        }
        mergeSort(listOne, comparator);
        mergeSort(listTwo, comparator);
        merge( listOne, listTwo, comparator, list);
    }
    private static <E> void merge(DoublyLinkedList<E> listOne, DoublyLinkedList<E> listTwo, Comparator<E> comparator, DoublyLinkedList<E> list){
        while(!listOne.isEmpty() && !listTwo.isEmpty()){
            if( comparator.compare(listOne.get(0), listTwo.get(0)) <= 0 ){
                list.addLast(listOne.removeFirst());
            } else {
                list.addLast(listTwo.removeFirst());
            }
        }
        while(!listOne.isEmpty()){
            list.addLast(listOne.removeFirst());
        }
        while(!listTwo.isEmpty()){
            list.addLast(listTwo.removeFirst());
        }
    }
}
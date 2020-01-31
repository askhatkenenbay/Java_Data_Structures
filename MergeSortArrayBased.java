import java.util.Comparator;

public class MergeSortArrayBased<E> {
    public static <E> void mergeSort(E[] original, Comparator<E> comparator){
        E[] input = (E[]) new Object[original.length];
        E[] output = (E[]) new Object[original.length];
        System.arraycopy(original, 0, input, 0, original.length);
        E[] temp;   //for swapping
        int n = original.length;
        for( int i = 1; i < n; i*=2 ){
            for( int j = 0; j < n; j+=2 * i){
                merge(input, output, comparator, j, i);
            }
            temp = input;
            input = output;
            output = temp;
        }
        System.arraycopy(input, 0, original, 0, input.length);
    }

    private static <E> void merge(E[] input, E[] output, Comparator<E> comparator, int start, int inc){
        int x = start;
        int end1 = Math.min(start + inc, input.length);
        int end2 = Math.min(start + 2*inc, input.length);
        int y = start+inc;
        int z = start;
        while((x < end1 ) && (y < end2) ){
            if(comparator.compare(input[x], input[y]) <= 0){
                output[z++] = input[x++];
            }else{
                output[z++] = input[y++];
            }
        }
        if( x < end1){
            System.arraycopy(input, x, output, z, end1 - x);
        } else if ( y < end2 ){
            System.arraycopy(input, y, output, z, end2 - y);
        }
    }
}
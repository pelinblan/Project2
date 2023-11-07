import java.util.Comparator;

public class MergeSort<K extends Comparable<? super K>, E>{
    private static final int THRESHOLD = 10;
    private Comparator<E> myComparator;
public void mergesort(Comparable [] A, Comparable temp [], int left, int right) {
    int i, j, k, mid;
        mid = (left+right)/2; //select the midpoint

        if(left == right) return; //list has only one record

        if((mid-left) >= THRESHOLD){
            mergesort(A, temp, left, mid);
        }
        else{
            innsort(A, left, mid, myComparator);
        }
        if((right-mid) >= THRESHOLD){
        mergesort(A, temp, mid+1, right);
        }
        else{
            innsort(A, left, mid + 1, myComparator);
        }

        //merge sort operation. copy 2 halves to temp
        for(i = left; i<= mid; i++){
            temp[i] = A[i];
        }
        for(j= right; j > mid; j--){
            temp[i++] = A[j];
        }
        //merge sublists back to the array
        for (i = left, j = right, k = left; k <= right; k++) {
            if (myComparator.compare((E)temp[i], (E)temp[j]) <= 0) {
                A[k] = temp[i++];
            } else {
                A[k] = temp[j--];
            }
        }
}

    public void innsort(Comparable [] A, int left, int right, Comparator<E> myComparator) {
        // Your insertion sort implementation with a comparator
        for (int i = left + 1; i <= right; i++) {
            Comparable<E> current = A[i];
            int j = i;

            while (j > left && myComparator.compare((E)current, (E)A[j - 1]) < 0) {
                A[j] = A[j - 1];
                j--;
            }

            A[j] = current;
        }
    }

}



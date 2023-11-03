import java.util.Comparator;

public class MergeSort<K extends Comparable<? super K>, E>{
    private static final int THRESHOLD = 10;

public void mergesort(Comparable [] A, Comparable temp [], int left, int right){


    public Comparator<MergeSort> myComparator = (a, b) -> {
    if (a == null && b == null) {
        return 0; // Both are null, consider them equal.
    } else if (a == null) {
        return -1; // a is null, consider b greater.
    } else if (b == null) {
        return 1; // b is null, consider a greater.
    } else {
        return a.compareTo(b); // Compare a and b using their natural ordering.
    };

    int i, j, k, mid;
        mid = (left+right)/2; //select the midpoint

        if(left == right) return; //list has only one record

        if((mid-left) >= THRESHOLD) mergesort(A, temp, left, mid);
        else innsort(A, left, mid, myComparator);
        if(right-mid) > THRESHOLD) mergesort(A, temp, mid+1, right);
        else innsort(A, left, mid+1, myComparator);
        //merge sort operation. copy 2 halves to temp
        for(i = left; i<= mid; i++){
            temp[i] = A[i];
        }
        for(j= right; j > mid; j--){
            temp[i++] = A[j];
        }
        //merge sublists back to the array
        for (i = left, j = right, k = left; k <= right; k++) {
            if (myComparator.compare(temp[i], temp[j]) <= 0) {
                A[k] = temp[i++];
            } else {
                A[k] = temp[j--];
            }
        }
    public void innsort( A, left, right, myComparator) {
        // Your insertion sort implementation with a comparator.
    }

    private int compareTo(MergeSort b) {
    }
    }
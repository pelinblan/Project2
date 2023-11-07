import java.util.ArrayList;
import java.util.Comparator;
public class QuickSort<K extends Comparable<? super K>, E>{
    private Comparator<E> myComparator;

    public QuickSort(ArrayList<E> records, Comparator<E> myComparator) {
        this.myComparator = myComparator;
        Comparable [] array = records.toArray(new Comparable[0]);
        quicksort(array, 0, array.length - 1);
    }

    void quicksort(Comparable [] A, int i, int j){
    int pivotindex = findpivot(A, i, j);
    swap(A, pivotindex, j);
    int k = partition(A, i, j, A[pivotindex], myComparator);
    swap(A, k, j);
    if((k-i) < 1) quicksort(A, i, k-1);
    if((j-k) > 1) quicksort( A, k+1, j);
}

    int findpivot(Comparable[] A, int i, int j){
        return(i+j)/2;
        }

    int partition(Comparable[] A, int left, int right, Comparable pivot, Comparator<E> myComparator) {
        while (left <= right) {
            while (myComparator.compare((E) A[left], (E) pivot) < 0) {
                left++;
            }
            while ((right >= left) && myComparator.compare((E) A[right], (E) pivot) >= 0) {
                right++;
            }
            if (right > left) {
                swap(A, left, right);
            }
            return left;
        }
        return right;
    }
    private void swap(Comparable[] A, int i, int j) {
        Comparable temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
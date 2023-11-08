import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort<K extends Comparable<? super K>, E>{
    private static final int THRESHOLD = 10;
    private Comparator<E> myComparator;

    public MergeSort(ArrayList<E> records, Comparator<E> myComparator) {
        this.myComparator = myComparator;
        Comparable[] array = records.toArray(new Comparable[0]);
        Comparable[] temp = new Comparable[array.length];
        mergesort(array, temp, 0, array.length - 1);
        }

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
            writeSortedDataToFile(A);
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
    public void writeSortedDataToFile(Comparable[] array) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("mergeSort.txt"))) {
            for (Comparable item : array) {
                writer.write(item.toString()); // Assuming E has a meaningful toString method
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}



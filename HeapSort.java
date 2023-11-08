import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
public class HeapSort<K extends Comparable<? super K>, E> {
    private E[] Heap; // Pointer to heap array
    private int size; // Maximum size of heap
    private int n; // # of things in heap

    private Comparator<E> myComparator;

    public HeapSort(ArrayList<E> records, Comparator<E> myComparator) {
        this.myComparator = myComparator;
        n = records.size();
        size = n;
        Heap = (E[]) records.toArray(new FilmRecord[n]);
        buildheap(myComparator);

    }

    public int heapsize() {
        return n;
    }

    public boolean isLeaf(int pos) {
        return (pos >= n / 2) && (pos < n);
    }

    public int leftchild(int pos) { // Leftchild position
        return 2 * pos + 1;
    }

    public E removemax() {
        assert n > 0 : "Removing from empty heap";
        swap(Heap, 0, --n);
        if (n != 0) shiftdown(0, myComparator);
        return Heap[n];
    }

    private void shiftdown(int pos, Comparator<E> myComparator) {
        assert (pos >= 0) && (pos < n) :
                "Illegal heap position";
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if ((j < (n - 1) && myComparator.compare(Heap[j], Heap[j + 1]) < 0))
                j++; // index of child w/ greater value
            if (myComparator.compare(Heap[pos], Heap[j]) >= 0)
                return;
            swap(Heap, pos, j);
            pos = j; // Move down
        }
    }

    private void buildheap(Comparator<E> myComparator) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            shiftdown(i, myComparator);
        }
    }
    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void heapSort(Comparable[] A, Comparator<E> myComparator) {
         ArrayList<Comparable> B = new ArrayList<Comparable>();
         for(int i = 0; i < A.length; i++){
             B.add(A[i]);
         }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("heapSort.txt"))) {
            HeapSort H = new HeapSort(B, myComparator);
            for (int i = n - 1; i >= 0; i--) {
                E max = (E) H.removemax();
                writer.write(max.toString()); // Assuming E has a meaningful toString method
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}


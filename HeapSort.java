import java.util.Comparator;
public class MaxHeap<K extends Comparable<? super K>, E> {
    private E[] Heap; // Pointer to heap array
    private int size; // Maximum size of heap
    private int n; // # of things in heap

    private Comparator<E> myComparator;

    public MaxHeap(E[] h, int num, int max) {
        Heap = h;
        n = num;
        size = max;
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
        if (n != 0) siftdown(0, myComparator);
        return Heap[n];
    }

    private void siftdown(int pos, Comparator<E> myComparator) {
        assert (pos >= 0) && (pos < n) :
                "Illegal heap position";
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if (j < (n - 1) && compareTo(Heap[j], Heap[j + 1], myComparator) < 1)
                j++; // index of child w/ greater value
            if (compareTo(Heap[pos], Heap[j], myComparator) >= 0)
                return;
            swap(Heap, pos, j);
            pos = j; // Move down
        }
    }

    private void buildheap(Comparator<E> myComparator) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            siftdown(i, myComparator);
        }
    }

    public int compareTo(E A, E B, Comparator<E> myComparator) {
        return myComparator.compare(A, B);
    }
    private void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void heapSort(Comparable[] A) {
        MaxHeap H = new MaxHeap(A, A.length, A.length);
        for (int i = 0; i < A.length; i++) {
            H.removemax();
        }
    }
}
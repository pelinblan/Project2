import java.util.Comparator;
public class MaxHeap<K extends Comparable<? super K>, E> {
    private E[] Heap; // Pointer to heap array
    private int size; // Maximum size of heap
    private int n; // # of things in heap

    public MaxHeap(E[] h, int num, int max) {
        Heap = h;
        n = num;
        size = max;
        buildheap();
    }

    public int heapsize() {
        return n;
    }

    public boolean isLeaf(int pos) {
        return (pos >= n / 2) && (pos < n);
    }

    public int leftchild(int pos) { // Leftchild position
    }

    public E removemax() {
        assert n > 0 : "Removing from empty heap";
        swap(Heap, 0, --n);
        if (n != 0) siftdown(0);
        return Heap[n];
    }

    private void siftdown(int pos) {
        assert (pos >= 0) && (pos < n) :
                "Illegal heap position";
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if (j < (n - 1) && myComparator.compare(Heap[j], Heap[j + 1]) < 0)
                j++; // index of child w/ greater value
            if (myComparator.compare(Heap[pos], Heap[j]) >= 0)
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
        MaxHeap H = new MaxHeap(A, A.length, A.length)
        for (int i = 0; i < A.length; i++) {
            H.removemax();
        }
    }
}
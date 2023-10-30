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
        DSutil.swap(Heap, 0, --n);
        if (n != 0) siftdown(0);
        return Heap[n];
    }

    private void siftdown(int pos) {
        assert (pos >= 0) && (pos < n) :
                "Illegal heap position";
        while (!isLeaf(pos)) {
            int j = leftchild(pos);
            if ((j<(n-1)) &&
                    (Heap[j].compareTo(Heap[j+1]) < 0))
                j++; // index of child w/ greater value
            if (Heap[pos].compareTo(Heap[j]) >= 0)
                return;
            DSutil.swap(Heap, pos, j);
            pos = j; // Move down
        }
    }

    static void heapSort(Comparable[] A) {
        MaxHeap H = new MaxHeap(A, A.length, A.length)
        for (int i = 0; i < A.length; i++) {
            H.removemax();
        }
    }
}
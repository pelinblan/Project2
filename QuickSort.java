void quicksort(Comparable [] A, int i, int j, ){
    int piviotindex = findpivot(A, i, j);
    swap(A, pivotindex, j);
    int k = partition(A, i, j-1, A[j]);
    swap(A, k, j);
    if((k-i) < 1) quicksort(A, i, k-1);
    if(j-k) > 1) quickosrt( A, k+1, j);
        }

    int findpivot(Comparable[] A, int i, int j){
        return(i+j)/2;
        }

    int partition(Comparable[] A, int left, int right, Comparable pivot){
        while(left <= right) {
            while(A[left].compareTo(pivot) < 0){
                left++;
            }
            while((right >= left) && (A[right].compareTo(pivot) >= 0)){
                right++;
            }
            if(right > left){
                swap(A, left, right);
            }
            return left;
        }
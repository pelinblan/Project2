void mergesortOpt(Comparable [] A, Comparable temp []. int left, int right){
        int i, j, k, mid;
        mid = (left+right)/2; //select the midpoint

        if(left == right) return; //list has only one record

        if((mid-left) >= THRESHOLD) mergesortOpt(A, temp, left, mid);
        else inssort(A, left, mid);
        if(right-mid) > THRESHOLD) mergesortOpt(A, temp, mid+1, right);
        else innsort(A, mid+1, right);
            //merge sort operation. copy 2 halves to temp
        for(i= leftl i<= mid; i++){
            temp[i] = A[i];
        }
        for(j= right; j > mid; j--){
            temp[i++] = A[j];
        }
        //merge sublists back to the array
        for(i=left, j=right, k=left; k<= right; k++)
            if(temp[i].compareTo(temp[j]) <= 0){
                A[k] = temp[i++];
            }
            else{
                A[k] = temp[j--];
            }
        }
        }
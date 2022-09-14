package Zusammenfassungen;

public class Sorting_Algorithms {

    void bubbleSort(int[] a) {
         for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i]> a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
         }
    }

    private void swap1(int[] a, int i, int j)  {
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public void selectionSort(int[] a)  {
        for(int k=0; k<a.length-1; k++){
            int j=k;
            for(int q=k+1; q<a.length; q++){
                if(a[j]>a[q]){
                    j=q;
                }
            }
            swap1(a, k, j);
        }
    }

    private void swap2(String[] a, int i, int j)  {
        String tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public void insertionSort(String[] a) {
        for(int k=1; k<a.length; k++){
            int q=k;
            while(q>0 && a[q].compareTo(a[q-1])<0){
                swap2(a,q,q-1);
                q--;
            }
        }
    }

    //merge1 merges two sorted arrays a and b, into one sorted array

    void merge1(int[] a, int[] left , int right []) {
        int k = 0; int q = 0;
        for (int j = 0; j < a.length; j ++) {
            if (k >= left.length) {
                a[j] = right[q];
                q ++;
            } else if (q >= right.length) {
                a[j] = left[k];
                k ++;
            } else if (left[k] <= right[q]) {
                a[j] = left[k];
                k ++;
            } else {
                a[j] = right[q];
                q ++;
            }
        }
    }

    // merge2 merges two sorted subarrays of array a, first subarray a[lo..mid], other subarray a[mid+1..hi]

    void merge2(int[] a, int lo, int mid , int hi) {
        int[] aux = new int[a.length ];
        for (int j = lo; j <= hi; j ++) {
            aux[j] = a[j];
        }
        int k = lo; int q = mid + 1;
        for (int jack = lo; jack <= hi; jack ++) {
            if (k > mid) {
                a[jack] = aux[q];
                q++;
            } else if (q > hi) {
                a[jack] = aux[k];
                k++;
            } else if (aux[k] <= aux[q]) {
                a[jack] = aux[k];
                k++;
            } else {
                a[jack] = aux[q];
                q++;
            }
        }
    }

    //mergeSort divides the input array into two halves,
    // sorts the two half-arrays recursively
    // and merges the two sorted half-arrays

    void mergeSort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (hi + lo) / 2;
        mergeSort(a, lo , mid);
        mergeSort(a, mid+1, hi);
        merge2(a, lo , mid , hi);
    }

}

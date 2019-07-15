/*William Giddins CSC 220 Programming Assignement 1*/

import java.util.Random;

public class SortAlg {
    private int[] array;
    private int size;



    public SortAlg (int n){
    size =n;
    Random rand = new Random();
    array= new int[n];
    for (int i = 0; i <= size-1 ; i++) {
        array[i] = rand.nextInt(9 - 0) + 0;
    }}

    public SortAlg(int n,int selector) {// if selector is 0 array is generated for comparison sorting, if 1 non comparison
        size = n;

        int q=(100*-1); //used for to range comparison arrays from -100 to 100
        Random rand = new Random();
        array = new int[n];
        if( selector == 0){
            for (int i = 0; i <= size - 1; i++) {
                array[i] = rand.nextInt(100 - q) + q;

        }}
        if( selector == 1){
        for (int i = 0; i <= size - 1; i++) {
            array[i] = rand.nextInt(99 - 0) + 0;
        }}
        // for loop to generate random numbers in array
    }

    public void InsertionSort() {
        int key = 0;
        int i = 0;
        int j = 0;
        for (j = 1; j <= size - 1; j++) {
            key = array[j];
            i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
    }

    public void MergeSort(int p, int r) {

        int q;
        if (p < r) {
            q = ((p + r) / 2);
            MergeSort(p, q);
            MergeSort(q + 1, r);
            Merge(array, p, q, r);
        }
    }

    private void Merge(int[] A, int p, int q, int r) {
        int k, i, j;
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (i = 0; i < n1; i++)
            L[i] = A[p + i];
        for (j = 0; j < n2; j++)
            R[j] = A[q + j + 1];

        L[n1] = 100000000;
        R[n2] = 100000000;
        i = 0;
        j = 0;
        for (k = p; k < r + 1; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public void Heapsort() {
        int temp;
        BuildHeap(array, size);
        int heapsize = size - 1;
        for (int i = heapsize; i > 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapsize--;
            Heapify(array, 0, heapsize);

        }
    }

    private void BuildHeap(int[] A, int size) {
        int heapsize = size;
        for (int i = (heapsize / 2) - 1; i >= 0; i--) {
            Heapify(A, i, heapsize);
        }
    }

    private void Heapify(int[] A, int i, int heapsize) {
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;
        int largest;
        int temp;
        if (l <= heapsize - 1 && A[l] > A[i])
            largest = l;
        else
            largest = i;
        if (r <= heapsize - 1 && A[r] > A[largest])
            largest = r;
        if (largest != i) {
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            Heapify(A, largest, heapsize);
        }
    }

    public void QuicksortFirst(int p, int q){
        QuicksortFp(array,p,q);
    }

    public void QuicksortMiddle(int p, int q) {
        QuicksortMp(array, p, q);
    }

    public void QuicksortRandom(int p, int q) {
        QuicksortRand(array, p, q);
    }

    private void QuicksortFp(int A[], int p, int r) {//QuickSort based on First pivot
        if (p < r) {
            int q = PartitionFp(A, p, r);
            QuicksortFp(A, p, q - 1);
            QuicksortFp(A, q + 1, r);
        }
    }

    private int PartitionFp(int[] A, int p, int r) {
        int x = A[p];
        int i = r + 1;
        int temp;
        for (int j = r; j > p; j--) {
            if (A[j] >= x) {
                i = i - 1;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[i - 1];
        A[i - 1] = A[p];
        A[p] = temp;
        return i - 1;
    }

    private void QuicksortMp(int A[], int p, int r) {   //QuickSort based on middle pivot
        if (p < r) {
            PartitionMp(A, p, r);
        }
    }

    private void PartitionMp(int[] A, int p, int r) {
        if (p >= r)
            return;

        int mid = p + (r - p) / 2;
        int x = A[mid];
        int i = p;
        int temp;
        int j = r;

        while (i <= j) {
            while (A[i] < x) {
                i++;
            }

            while (A[j] > x) {
                j--;
            }
            if (i <= j) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j--;
                i++;
            }
        }
        if (p < j)
            QuicksortMp(A, p, j);
        if (r > i)
            QuicksortMp(A, i, r);
    }

    private void QuicksortRand(int[] A, int p, int r) {  //QuickSort based on randomly generated pivot
        if (p < r) {
            int q = Random_Partition(A, p, r);
            QuicksortFp(A, p, q - 1);
            QuicksortFp(A, q + 1, r);
        }
    }

    private int Random_Partition(int[] A, int p, int r) {
        int i = Random(A, p, r);
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return PartitionFp(A, p, r);
    }

    private int Random(int[] A, int p, int r) {     //Generates Random Pivot
        Random rand = new Random();
        int n = rand.nextInt(r) + p;
        return n;
    }

    public void CountingSort() {
        int i, j;

        int[] c = new int[size]; //changed depending on N used
        int[] b = new int[size];
        for (i = 0; i < size; i++) {   // i to k where k is the range of numbers in array
            c[i] = 0;

        }
        for (j = 0; j < size; j++) {  //j to n where n is the number of elements in array
            c[array[j]] += 1;
        }
        for (i = 1; i < size; i++) { //k to range of numbers in array
            c[i] = c[i] + c[i - 1];

        }
        for (int n = size - 1; n > -1; n--) {
            b[c[array[n]] - 1] = array[n];
            c[array[n]]--;

        }
        array = b;
    }

    private void Radix_CountingSort(int mod) { // Counting Sort modified for Radix sort
        int i, j, k = size;

        int[] c = new int[mod];
        int[] b = new int[size];
        for (i = 0; i < mod; i++) {   // i to k where k is the range of numbers in array
            c[i] = 0;
        }
        for (j = 0; j < size; j++) {  //j to n where n is the number of elements in array
            c[array[j] % mod] += 1;

        }
        for (i = 1; i < mod; i++) { //k to range of numbers in array
            c[i] = c[i] + c[i - 1];

        }
        for (int n = size - 1; n > -1; n--) {
            b[c[array[n] % mod] - 1] = array[n];
            c[array[n] % mod]--;

        }
        array = b;
    }

    public void RadixSort(int digits) {
        SortAlg d = new SortAlg(size,1);
        d.array = array;
        int k = 10;
        int j;

        for (int i = 1; i < digits + 1; i++) {//1 to the max number of digits
            j = 1;
            while (j < i) {
                k = k * 10;
                j++;
            }


            d.Radix_CountingSort(k);
        }
        array = d.array;
    }

    public void print () { // prints out put of array in order to check for correct sorting
        for (int i = 0; i <= size - 1; i++)
            System.out.printf("%d ", array[i]);

    }
}
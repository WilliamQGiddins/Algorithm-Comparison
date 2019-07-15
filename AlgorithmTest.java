/*William Giddins CSC 220 Programming Assignement 1*/

public class AlgorithmTest {

    public static void main(String[] args) {
       final long startTime = System.nanoTime();

       for (int i =10; i<=1000000;i=i*10) {

           SortAlg I = new SortAlg(i,0);
           I.InsertionSort();

       }
      for (int i =10; i<=1000000;i=i*10) {

           SortAlg H = new SortAlg(i, 0);
           H.Heapsort();
       }

        for (int i =10; i<=1000000;i=i*10) {

            SortAlg M = new SortAlg(i, 0);
            M.MergeSort(0,i-1);
            }

        for (int i =10; i<=1000000;i=i*10) {

            SortAlg QF = new SortAlg(i, 0);
            QF.QuicksortFirst(0,i-1);

        }

        for (int i =10; i<=1000000;i=i*10) {

            SortAlg QM = new SortAlg(i, 0);
            QM.QuicksortMiddle(0,i-1);

        }

        for (int i =10; i<=1000000;i=i*10) {

            SortAlg QR = new SortAlg(i, 0);
            QR.QuicksortRandom(0,i-1);

        }

        for (int i =10; i<=1000000;i=i*10) {

            SortAlg R = new SortAlg(i, 1);
            R.RadixSort(2);

        }

        for (int i =10; i<=10;i=i*10) {
            if (i == 10) {
                SortAlg C = new SortAlg(i);
                C.CountingSort();
            } else {
                SortAlg C = new SortAlg(i, 1);
                C.CountingSort();
            }

        }



       final long totalTime = System.nanoTime() - startTime;
        System.out.println(totalTime);


    }
}

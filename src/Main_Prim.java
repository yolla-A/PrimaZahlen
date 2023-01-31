public class Main_Prim {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int numThreads =2;
        int maxValue = 100;
        int range = maxValue / numThreads;
        PrimzahlThread[] pThread = new PrimzahlThread[numThreads];
        Thread[] thread = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int from = 1 + i * range;
            int to = range + i * range;
            pThread[i] = new PrimzahlThread(from, to);
            thread[i] = new Thread(pThread[i]);
            thread[i].start();
        }
        for (Thread t : thread) {
            t.join();
        }
        int result = 0;
        int resultCou = 0;
        for (PrimzahlThread primzahlThread : pThread) {
            int i = primzahlThread.getCounter();
            int j = primzahlThread.getCou();
            //System.out.println(i);
            result += i;
            resultCou += j;
            System.out.println(primzahlThread.list);
        }
        System.out.println("Anzahl der Primzahlen: "+result);
        System.out.println("Anzahl der Primzahlen mit zweier Differenz: "+resultCou);


        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("\nTotal elapsed time:  " + (elapsedTime/1000.0) + " seconds.\n");
        int processors = Runtime.getRuntime().availableProcessors();
        if (processors == 1)
            System.out.println("Your computer has only 1 available processor.\n");
        else
            System.out.println("Your computer has " + processors + " available processors.\n");
    }
//        long startTime = System.currentTimeMillis();
//        int numThreads = 4;
//        int maxValue = 100000;
//        int range = maxValue/numThreads;
//        CalculateNumDivisorsOfRange[] cRange = new CalculateNumDivisorsOfRange[numThreads];
//        Thread[] tRange = new Thread[numThreads];
//        for (int i=0;i<numThreads;i++) {
//            int from = 1+i*range;
//            int to = range+i*range;
//            cRange[i] = new CalculateNumDivisorsOfRange(from,to);
//            tRange[i] = new Thread(cRange[i]);
//            tRange[i].start();
//        }
//        for (Thread thread:tRange) {
//            thread.join();
//        }
//        int maxDivisor=1;
//        int maxNumber=1;
//        for (CalculateNumDivisorsOfRange calculated:cRange) {
//            NumberDivisors result = calculated.getResult();
//            System.out.println(result);
//            if (result.numDivisors>maxDivisor) {
//                maxDivisor = result.numDivisors;
//                maxNumber = result.number;
//            }
//        }
//        System.out.println("Gewinner ist " + maxNumber + " mit " + maxDivisor + ".");
//        long elapsedTime = System.currentTimeMillis() - startTime;
//        System.out.println("\nTotal elapsed time:  " + (elapsedTime/1000.0) + " seconds.\n");
//
//        int processors = Runtime.getRuntime().availableProcessors();
//        if (processors == 1)
//            System.out.println("Your computer has only 1 available processor.\n");
//        else
//            System.out.println("Your computer has " + processors + " available processors.\n");
//    }
}

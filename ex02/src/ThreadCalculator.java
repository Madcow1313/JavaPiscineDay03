public class ThreadCalculator extends Thread {
    private static int numberOfThread = 0;
    private static int start = 0;
    private int chunk;
    private long sum;
    private int[] array;

    ThreadCalculator(int chunk, int[] array){
        numberOfThread += 1;
        this.chunk = chunk;
        if (numberOfThread != 1)
            start += chunk;
        this.array = array;
    }

    public long summarize(){
        long sum = 0;
        int finish = start + chunk > array.length ? array.length : start + chunk;
        for (int i = start; i < finish; i++){
            sum += array[i];
        }
        System.out.println("Thread " + numberOfThread + ": from " + start + " to " + (finish - 1) + " sum is " + sum);
        this.sum = sum;
        return sum;
    }

    @Override
    public void run(){
        summarize();
    }
    public long getSum() {
        return sum;
    }
}

public class Program {
    private static final int MIN = -1000;
    private static final int MAX = 1000;
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.err.println("Expected execution: Program arraySize=SIZE --threadsCount=NUMBER");
            System.exit(-1);
        }
        try{
            int arraySize = Integer.parseInt(args[0].substring("--arraySize=".length()));
            int threadsCount = Integer.parseInt(args[1].substring("--threadsCount=".length()));
            int[] array = new int[arraySize];
            ThreadCalculator[] threadCalculator = new ThreadCalculator[threadsCount];
            long sum = 0;
            for (int i = 0; i < array.length; i++){
                array[i] = getRandomNumber(MIN, MAX);
                sum += array[i];
            }
            System.out.println("Sum: " + sum);
            for (int i = 0; i < threadCalculator.length; i++){
                threadCalculator[i] = new ThreadCalculator(countChunkSize(arraySize, threadsCount), array);
                threadCalculator[i].start();
                threadCalculator[i].join();
            }
            sum = 0;
            for (int i = 0; i < threadCalculator.length; i++){
                sum += threadCalculator[i].getSum();
            }
            System.out.println("Sum by threads: " + sum);
        }
        catch (Exception e){
            System.out.println("Something went wrong");
            System.out.println("Caught exception: " + e);
            System.exit(-1);
        }
    }

    public static int getRandomNumber(int min, int max){
        return (int)(Math.random() * ( max - min + 1)) + min;
    }
    public static int countChunkSize(int arraySize, int threadCount){
        int chunk = 1;

        while (chunk * threadCount < arraySize){
            chunk += 1;
        }
        return chunk;
    }
}

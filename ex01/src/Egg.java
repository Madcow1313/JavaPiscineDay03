public class Egg implements Runnable {
    private int count;
    private Printer printer;

    Egg(int count, Printer printer){
        this.count = count;
        this.printer = printer;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; i++){
            printer.print("Egg", 0);
        }
    }
}

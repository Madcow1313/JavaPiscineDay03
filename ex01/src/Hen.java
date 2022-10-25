public class Hen implements Runnable{
    private int count;
    private Printer printer;

    Hen(int count, Printer printer){
        this.count = count;
        this.printer = printer;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; i++){
            printer.print("Hen", 1);
        }
    }
}

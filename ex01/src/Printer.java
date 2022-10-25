import java.lang.invoke.SwitchPoint;

public class Printer {
    private ToPrint toPrint = ToPrint.EGG;
    private enum ToPrint{
        EGG,
        HEN
    };
    Printer(){}

    public ToPrint getToPrint() {
        return toPrint;
    }

    private void switchToPrint(){
        if (toPrint == ToPrint.EGG){
            toPrint = ToPrint.HEN;
        }
        else{
            toPrint = ToPrint.EGG;
        }
    }
    public synchronized void print(String str, int number){
        ToPrint cameFromThread;

        if (number == 0)
            cameFromThread = ToPrint.EGG;
        else
            cameFromThread = ToPrint.HEN;
        if (cameFromThread != toPrint){
            try{
                wait();
            }
            catch (InterruptedException e){}
        }
        System.out.println(str);
        switchToPrint();
        notify();
    }
}

public class Program {
    public static void main(String[] args){
        int count = 50;
        Thread egg = new Thread(() -> {
            for (int i = 0; i < 15; i++){
                System.out.println("Egg");
            }
        });
        Thread hen = new Thread(() -> {
            for (int i = 0; i < 15; i++){
                System.out.println("Hen");
            }
        });
        egg.start();
        hen.start();
        try {
            egg.join();
            hen.join();
        }
        catch (Exception e){}
        for (int i = 0; i < 15; i++){
            System.out.println("Human");
        }
    }
}


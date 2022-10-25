public class Program {
    public static void main(String[] args){
        if (args.length != 1 || !args[0].startsWith("--count=")){
            System.err.println("Expected execution: Program --count=NUMBER");
            System.exit(-1);
        }
        try {
            int count = Integer.parseInt(args[0].substring("--count=".length()));
            Thread egg = new Thread(() -> {
                for (int i = 0; i < count; i++){
                    System.out.println("Egg");
                }
            });
            Thread hen = new Thread(() -> {
                for (int i = 0; i < count; i++){
                    System.out.println("Hen");
                }
            });
            egg.start();
            hen.start();
            egg.join();
            hen.join();
            for (int i = 0; i < count; i++){
                System.out.println("Human");
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong");
            System.out.println("Caught exception: " + e);
            System.exit(-1);
        }

    }
}


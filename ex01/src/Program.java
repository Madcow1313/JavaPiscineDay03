public class Program {
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Expected execution: Program --count=NUMBER");
            System.exit(-1);
        }
        try{
            int count = Integer.parseInt(args[0].substring("--count=".length()));
            Printer printer = new Printer();
            new Thread(new Egg(count, printer)).start();
            new Thread(new Hen(count, printer)).start();
        }
        catch (Exception e){
            System.out.println("Something went wrong");
            System.out.println("Caught exception: " + e);
            System.exit(-1);
        }




    }
}

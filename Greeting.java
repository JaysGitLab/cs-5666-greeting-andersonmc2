import org.apache.commons.cli.*;

public class Greeting{
    private static String myName;
    public static void main(String[] args) throws ParseException{
        Options options = new Options();
        options.addOption("me", true, "name machine");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);
        String[] otherArgs = cmd.getArgs();
        
        if(cmd.hasOption("me")) {
            if(cmd.getOptionValue("me") != null){
                myName = cmd.getOptionValue("me");
            }
            else{
                System.out.println("Invalid parameter!");
            }
            
            if(otherArgs.length != 0){
                System.out.print("Hello, ");
                for(int i = 0; i < otherArgs.length;i++){
                    System.out.print(otherArgs[i]);                
                    if(i < otherArgs.length-1)
                        System.out.print(" ");
                }
                System.out.print("\n");
            }
            else{
                System.out.println("Hello, Mikeal!");
            }
        }
        else {
            if(otherArgs.length != 0){
                System.out.print("Hello, ");
                for(int i = 0; i < otherArgs.length;i++){
                    System.out.print(otherArgs[i]);
                    if(i < otherArgs.length-1)
                        System.out.print(" ");                
                }
                System.out.print("\n");
            }
            else{
                System.out.println("Hello, Mikeal!");
            }
        }
    }
    public String getName(){
        return myName;
    }
}


import org.apache.commons.cli.*;

public class Greeting{
    private static String myName;
    private static String theirName;
    public static void main(String[] args) throws ParseException{
        Options options = new Options();
        options.addOption("me", true, "name machine");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);
        String[] otherArgs = cmd.getArgs();
        
        if(cmd.hasOption("me")) {
            if(cmd.getOptionValue("me") != null){
                myName = capitalize(cmd.getOptionValue("me"));
            }
            else{
                System.out.println("Invalid parameter!");
            }
            
            if(otherArgs.length != 0){
                String tempName = "";
                for(int i = 0; i < otherArgs.length;i++){
                    tempName += capitalize(otherArgs[i]);                
                    if(i < otherArgs.length-1)
                        tempName += " ";
                }
                theirName = tempName;
                System.out.print("Hello, " + getTheirName() + ". My name is " 
                                + getName() + ". How are you today, " 
                                + getTheirName() + "?\n");
            }
            else{
                System.out.print("Hello, Mikeal. My name is " + getName() 
                                    + ". How are you today, Mikeal?\n");
            }
        }
        else {
            if(otherArgs.length != 0){
                System.out.print("Hello, ");
                for(int i = 0; i < otherArgs.length;i++){
                    System.out.print(capitalize(otherArgs[i]));
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
    public static String getName(){
        return myName;
    }
    public static String getTheirName(){
        return theirName;
    }
    public static String capitalize(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
}


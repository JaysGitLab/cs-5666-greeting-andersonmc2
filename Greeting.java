class Greeting{
    public static void main (String[] args){
        if(args.length != 0){
            System.out.println("Hello, " + args[0].substring(0,1).toUpperCase()+args[0].substring(1).toLowerCase());
        }
        else{
            System.out.println("Hello, Mikeal!");
        }
    }
}

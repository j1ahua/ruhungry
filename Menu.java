package restaurant;
/**
 * Use this class to test your Menu method. 
 * This class takes in two arguments:
 * - args[0] is the menu input file
 * - args[1] is the output file
 * 
 * This class:
 * - Reads the input and output file names from args
 * - Instantiates a new RUHungry object
 * - Calls the menu() method 
 * - Sets standard output to the output and prints the restaurant
 *   to that file
 * 
 * To run: java -cp bin restaurant.Menu menu.in menu.out
 * 
 */
public class Menu {
    public static void main(String[] args) {

	// 1. Read input files
	// Option to hardcode these values if you don't want to use the command line arguments
	   
        String inputFile = args[0];
        String outputFile = args[1];
        String stockList = args[2];
        String order = args[3];
        String dono = args[4];
        String restock = args[5];
        String transaction = args[6];
        
	
        // 2. Instantiate an RUHungry object
        RUHungry rh = new RUHungry();

	// 3. Call the menu() method to read the menu
        rh.menu(inputFile);
        rh.createStockHashTable(stockList);
        rh.updatePriceAndProfit();
        StdIn.setFile(order);

        int num = StdIn.readInt();
        for(int i=0; i< num; i++){
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                rh.order(item, amount);
        }
        StdIn.setFile(dono);
        // int donoNum = StdIn.readInt();
        // for (int i = 0; i < donoNum; i ++){
        //         int amount = StdIn.readInt();
        //         StdIn.readChar();
        //         String item = StdIn.readLine();
        //         rh.donation(item, amount);
        // }
        StdIn.setFile(restock);
        // int restockNum = StdIn.readInt();
        // for (int i = 0; i < restockNum; i ++){
        //         int amount = StdIn.readInt();
        //         StdIn.readChar();
        //         String item = StdIn.readLine();
        //         rh.restock(item, amount);
        // }
        StdIn.setFile(transaction);
        int transNum = StdIn.readInt();
        for (int i = 0; i < transNum; i ++){
                String type = StdIn.readString();
                StdIn.readChar();
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                if (type.equals("order")) {rh.order(item, amount);}
                else if (type.equals("donation")) {rh.donation(item, amount);}
                else {rh.restock(item, amount);}
        }
      
        // System.out.println(amount);
      
        // System.out.println(item);
        
	// 4. Set output file
	// Option to remove this line if you want to print directly to the screen
        StdOut.setFile(outputFile);
        
	// 5. Print restaurant
        rh.printRestaurant();
    }
}

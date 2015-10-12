package dictionary_spell_checker;

import com.sun.jmx.snmp.tasks.Task;
import java.util.Scanner;

/**
 *
 * @author makena
 */
public class Dictionary_Spell_checker {

    private static D dictionary;
    final static String filePath = "/home/makena/Desktop/t.txt";
    final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        // TODO code application logic here
        
        Thread runThread = new Thread(new Task("run"));
        runThread.run();

       
        
    }

    Dictionary_Spell_checker() {
        dictionary = new D();
        dictionary.build(filePath);

    }
    
    private static class Task implements Runnable{
        private String call;
       
        public Task(String caller){
            this.call = call;
        }


    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        String input;

        while (true) {
            System.out.print("\n-------Enter a word: ");
            input = scan.nextLine();
            if (input.equals("")) {
                break;
            }
            if (dictionary.contains(input)) {
                System.out.println("\n" + input + " is spelled correctly");
            } else {
                System.out.print("is not spelled correctly, ");
                //System.out.println(printSuggestions(input));
            }
        }

    }
}
}

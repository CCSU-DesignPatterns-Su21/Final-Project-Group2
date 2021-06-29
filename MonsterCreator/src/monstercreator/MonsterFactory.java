package monstercreator;

import java.util.Scanner;

/**
 *  A Factory class that produces 
 * Monsters. Implements AbstractFactory
 * and Singleton design patterns.
 * @author  Zach Bearse
 *          Adam Hasen
 *          Jeremiah Smith
 */
public class MonsterFactory implements Factory{
    
    private static MonsterFactory instance;
    private final Scanner keyboard;
    private MonsterFactory(){
        keyboard = new Scanner(System.in);
    }
    
    public static MonsterFactory getInstance(){
        if(instance == null){
            instance = new MonsterFactory();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    /**
     * Creates a Monster with traits
     * based on user input. 
     * @return a unique Monster instance
     */
    @Override
    public Monster create(){
        // prompt user for input
        System.out.println("Name your Monster:");
        String name = keyboard.nextLine();

        System.out.println("Choose an Element: \n"
                + "1: Fire\n"
                + "2: Water\n"
                + "3: Electric\n"
                + "4: Ice\n");
        int selection = keyboard.nextInt();
        IElement type = null;
        switch (selection) {
            case 1:
                type = Fire.getInstance();
                break;
            case 2:
                type = Water.getInstance();
                break;
            case 3:
                type = Electric.getInstance();
                break;
            case 4:
                type = Ice.getInstance();
                break;
            default:
                throw new RuntimeException("Invalid Input");
        }
        
        System.out.println("Choose a Body Type: \n"
                + "1: Bipedal Terrestrial\n"
                + "2: Quadrupedal Terrestrial\n"
                + "3: Oceanic\n"
                + "4: Wyvern\n"
                + "5: Elder Dragon\n");
        int bodyType = keyboard.nextInt();       
        switch (bodyType) {
            case 1:
            {
                //TODO: use the BuildDirector to create each preset monster, should return a monster at the end
            }
            case 2:
            {
                
            }
            case 3:
            {
                
            }
            default:
                throw new RuntimeException("Invalid Input");
        }
    }

    public static void main(String[] args){
        Factory mf = MonsterFactory.getInstance();
        IMonster test = mf.create();
        System.out.println(test);

        Visitor v = new Visitor();
        test.accept(v);
        System.out.println(v.toString());
    }
}

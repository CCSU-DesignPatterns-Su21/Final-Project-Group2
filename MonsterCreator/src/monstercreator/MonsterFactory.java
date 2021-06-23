package monstercreator;

import java.util.Scanner;
import static monstercreator.Element.*;

/**
 *
 * @author zachb
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
     *
     * 
     * @return
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
        Element type = null;
        
        switch (selection) {
            case 1:
                type = FIRE;
                break;
            case 2:
                type = WATER;
                break;
            case 3:
                type = ELECTRIC;
                break;
            case 4:
                type = ICE;
                break;
            default:
                throw new RuntimeException("Invalid Input");
        }
        
        System.out.println("Choose a Body Type: \n"
                + "1: Bipedal Terrestrial\n"
                + "2: Quadrupedal Terrestrial\n"
                + "3: Flying\n");
        int bodyType = keyboard.nextInt();
        
        switch (bodyType) {
            case 1:
            {
                Head head = new Head(type);
                Arm arms = new Arm(type);
                Leg legs = new Leg(type);
                Tail tail = new Tail(type);
                Monster monster = new Monster(name, head, arms, legs, tail);
                return monster;
            }
            case 2:
            {
                Head head = new Head(type);
                Leg frontLegs = new Leg(type);
                Leg backLegs = new Leg(type);
                Tail tail = new Tail(type);
                Monster monster = new Monster(name, head, frontLegs, backLegs, tail);
                return monster;
            }
            case 3:
            {
                Head head = new Head(type);
                Wing wings = new Wing(type);
                Leg legs = new Leg(type);
                Tail tail = new Tail(type);
                Monster monster = new Monster(name, head, wings, legs, tail);
                return monster;
            }
            default:
                throw new RuntimeException("Invalid Input");
        }
    }
    public static void main(String[] args){
        
    }
}

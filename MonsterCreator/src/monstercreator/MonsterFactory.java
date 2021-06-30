package monstercreator;

import java.util.ArrayList;
import java.util.Scanner;

import monstercreator.Monster.MonsterBuilder;

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
        
        Head head = null;
        ArrayList<Limb> limbs = new ArrayList();
        Tail tail = null;
        IElement headElement;
        IElement limbElement;
        IElement tailElement;
        // prompt user for input
        
        System.out.println("Name your Monster:");
        String name = keyboard.nextLine();

        System.out.println("Customize or choose from preset: \n"
                + "1: Customize\n"
                + "2: Choose from preset\n");
        int result = keyboard.nextInt();

        if (result == 1) {
            System.out.println("Choose an Element for " + name + "'s head:");
            displayElementPrompt();
            
            int selectionH = keyboard.nextInt();
            headElement = numToElement(selectionH);
            head = new Head(headElement);
            
            int limbStyle;
            do{
                System.out.println("Choose a Limb type: \n" 
                        + "1: Arms\n"
                        + "2: Legs\n"
                        + "3: Wings\n"
                        + "4: Fins\n"
                        + "0: No more Limbs (Minimum 1 limb type)\n");
                limbStyle = keyboard.nextInt();
                
                if(limbStyle == 0 && !limbs.isEmpty()){
                    break;
                }
                System.out.println("Choose an Element:");
                displayElementPrompt();
                int selectionL = keyboard.nextInt();
                limbElement = numToElement(selectionL);
            
                switch (limbStyle) {
                    case 1:
                        limbs.add(new Arm(limbElement));
                        break;
                    case 2:
                        limbs.add(new Leg(limbElement));
                        break;
                    case 3:
                        limbs.add(new Wing(limbElement));
                        break;
                    case 4:
                        limbs.add(new Fin(limbElement));
                        break;
                }
            }while(limbs.isEmpty() || limbStyle !=0 );
            
            System.out.println("Give " + name + " a tail?");
            displayElementPrompt();
            System.out.println("0: No tail\n");
            int selectionT = keyboard.nextInt();
            
            if(selectionT == 0){
                return new Monster(name, head, limbs, tail);
                }
            else{
                tailElement = numToElement(selectionT);
                tail = new Tail(tailElement);
            }
            return new Monster(name, head, limbs, tail);
        }
        else {
            MonsterBuilder builder = new MonsterBuilder();

            System.out.println("Choose monster from preset: \n"
                    + "1: Biped Monster\n"
                    + "2: Quadruped Monster\n"
                    + "3: Aerial Monster\n"
                    + "4: Oceanic Mosnter\n"
                    + "5: Fire Dragon\n"
                    + "6: Storm Drake\n"
                    + "7: Ice Kraken\n"
                    + "8: Ultimate Octopus\n"
                    + "9: Cthulhu (Warning: BOSS)\n");
            int selectionP = keyboard.nextInt();

            int selectionPE;
            
            switch(selectionP) {
                case 1:
                    System.out.println("Choose an Element:");
                    displayElementPrompt();
                    selectionPE = keyboard.nextInt();                   
                    BuildDirector.buildBipedMonster(builder, numToElement(selectionPE));
                    break;
                case 2:
                    System.out.println("Choose an Element:");
                    displayElementPrompt();
                    selectionPE = keyboard.nextInt();                   
                    BuildDirector.buildQuadrupedMonster(builder, numToElement(selectionPE));
                    break;
                case 3:
                    System.out.println("Choose an Element:");
                    displayElementPrompt();
                    selectionPE = keyboard.nextInt();                   
                    BuildDirector.buildAerialMonster(builder, numToElement(selectionPE));
                    break;
                case 4:
                    System.out.println("Choose an Element:");
                    displayElementPrompt();
                    selectionPE = keyboard.nextInt();                   
                    BuildDirector.buildOceanicMonster(builder, numToElement(selectionPE));
                    break;
                case 5:
                    BuildDirector.buildFireDragon(builder);
                    break;
                case 6:
                    BuildDirector.buildStormDrake(builder);
                    break;
                case 7:
                    BuildDirector.buildIceKraken(builder);
                    break;
                case 8:
                    name = "Master of Four Elements: " + name;
                    BuildDirector.buildUltimateOctopus(builder);
                    break;
                case 9:
                    BuildDirector.buildCthulhu(builder);
                    break;
                default:
                    throw new RuntimeException("Invalid selection");
            }

            return builder.build(name);
        }     
    }
    public static void main(String[] args){
        
        Factory mf = MonsterFactory.getInstance();
        IMonster test = mf.create();
        test.getParts().get(0).takeDamage(2000);
        Visitor v = new Visitor();
        test.accept(v);
        System.out.println(v.toString());
    }

    private IElement numToElement(int num) {
        switch (num) {
            case 1:
                return Fire.getInstance();
            case 2:
                return Water.getInstance();
            case 3:
                return Electric.getInstance();
            case 4:
                return Ice.getInstance();
            default:
                throw new RuntimeException("Invalid Input");
        }
    }

    private void displayElementPrompt() {
        System.out.println(
                "1: Fire\n"
                + "2: Water\n"
                + "3: Electric\n"
                + "4: Ice\n");
    }
}

package monstercreator;

import java.util.ArrayList;

/**
 * The Product created by the
 * MonsterFactory. Composed of 
 * several MonsterParts, specifically 
 * one Head, one Tail, and two Limbs
 * @author zachb
 */
public class Monster implements IMonster, Visitable{
    
    private String name;
    private final int maxHitPoints = 10000; // Default value
    private int currentHitPoints;
    private Head head;
    private Tail tail;
    private ArrayList<Limb> limbs;
    
    public int getMaxHP(){
        return maxHitPoints;
    }
    public int getCurrentHP() {
        return currentHitPoints;
    }
    public String getName() {
        return name;
    }
    
    /**
     * Constructor for Monster
     * @param n String - Monster's name
     * @param h Head - head
     * @param limbList ArrayList of Limbs
     * @param t Tail - tail
     */
    public Monster(String n, Head h, ArrayList<Limb> limbList, Tail t ){
        name = n;
        currentHitPoints = maxHitPoints;
        head = h;          
        tail = t;
        for(Limb l : limbList){
            limbs.add(l);
        }
        // create bidirectional relationship
        setParent();
    }
    
    public void takeDamage(int damage){
        currentHitPoints -= damage;
    }

    /**
     * Visitor pattern
     * Instructs v to visit this Monster,
     * then passes v to each MonsterPart
     * @param v Visitor 
     */
    @Override
    public void accept(Visitor v){
        v.visitMonster(this);
        // send visitor to other parts
        head.accept(v);
        for(Limb l : limbs){
            l.accept(v);
        }
        tail.accept(v);
    }
     @Override
    public String toString(){
        String str = "Monster: " + name 
                + "\nHP: " + currentHitPoints + "/" + maxHitPoints + "\n";
                /*+ "\nHead: " + head.toString() 
                + "\nForelimb: " + forelimb.toString() 
                + "\nHind Limb: " + hindLimb.toString()
                + "\nTail: " + tail.toString() + '\n';
                */
        return str;
    }

    /**
     * Sets this Monster as the parent
     * of each of its MonsterParts
     */
    private void setParent(){
        head.setParent(this);
        tail.setParent(this);
        for(Limb l : limbs){
            l.setParent(this);
        }
    }
    
    public class MonsterBuilder{
        //TODO
    }
}

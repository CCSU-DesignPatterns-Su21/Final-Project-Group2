package monstercreator;

import java.util.List;

/**
 * The Product created by the
 * MonsterFactory. Composed of 
 * several MonsterParts, specifically 
 * one Head, one Tail, and two Limbs
 * @author zachb, Jeremiah Smith
 */
public class Monster implements IMonster, Visitable{
    
    private String name;
    private final int maxHitPoints = 10000; // Default value
    private int currentHitPoints;
    private Head head;
    private Tail tail;
    private List<Arm> arms;
    private List<Leg> legs;
    private List<Fin> fins;
    private List<Wing> wings;
    
    public int getMaxHP(){
        return maxHitPoints;
    }

    public int getCurrentHP() {
        return currentHitPoints;
    }

    public String getName() {
        return name;
    }

    //TODO: refactoring Monster class for Builder functionality, may want to apply type to the monster instead of monster part
    
    /**
     * Constructor for Monster
     * @param n String - Monster's name
     * @param h Head - head
     * @param t Tail - tail
     */
    public Monster(String name, MonsterBuilder builder){
        this.name = name;
        currentHitPoints = maxHitPoints;
        arms = builder.buildArms();
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
        forelimb.accept(v);
        hindLimb.accept(v);
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
        forelimb.setParent(this);
        hindLimb.setParent(this);
        tail.setParent(this);
    }
    
    public class MonsterBuilder{
        public Monster build(String monsterName) {
            return new Monster(monsterName, this);
        }
    }
}

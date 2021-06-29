package monstercreator;

import java.util.List;

/**
 * The Product created by the
 * MonsterFactory. Composed of 
 * several MonsterParts, specifically 
 * one Head, one Tail, and two Limbs
 * @author zachb
 *         Jeremiah Smith
 */
public class Monster implements IMonster, IElement, Visitable{
    
    private String name;
    private final int maxHitPoints = 10000; // Default value
    private int currentHitPoints;
    private IElement element;
    private IElement weakness;
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

    final void setElement(IElement type){
        element = type;
    }

    public final IElement getElement(){
        return element;
    }

    public IElement getWeakness(){
        return weakness;
    }

    //TODO: refactoring Monster class for Builder functionality, applying Element type to Monster instead of MonsterPart
    
    /**
     * Constructor for Monster
     * @param n String - Monster's name
     * @param h Head - head
     * @param t Tail - tail
     */
    public Monster(String name, MonsterBuilder builder){
        this.name = name;
        currentHitPoints = maxHitPoints;
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
        tail.accept(v);
        for (Limb limb : arms) {
            limb.accept(v);
        }
        for (Limb limb : legs) {
            limb.accept(v);
        }
        for (Limb limb : fins) {
            limb.accept(v);
        }
        for (Limb limb : wings) {
            limb.accept(v);
        }
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
        for (Limb limb : arms) {
            limb.setParent(this);
        }
        for (Limb limb : legs) {
            limb.setParent(this);
        }
        for (Limb limb : fins) {
            limb.setParent(this);
        }
        for (Limb limb : wings) {
            limb.setParent(this);
        }
    }
    
    public class MonsterBuilder{
        public Monster build(String monsterName) {
            return new Monster(monsterName, this);
        }

        private void buildHead() {
            head = new Head(); //no longer have to worry about getting type to the Builder 
        }

        private void buildTail() {

        }

        private void buildArms() {

        }

        private void buildLegs() {

        }

        private void buildFins() {

        }

        private void buildWings() {

        }
    }
}

package monstercreator;

import java.util.ArrayList;

/**
 * The Product created by the
 * MonsterFactory. Composed of 
 * several MonsterParts, specifically 
 * one Head, 
 * at least one Limb,
 * and optionally a tail;
 * @author zachb
 */
public class Monster implements IMonster, Visitable{
    
    private String name;
    private final int maxHitPoints = 10000; // Default value
    private int currentHitPoints;
    private Head head;
    private Tail tail;
    private ArrayList<Limb> limbs = new ArrayList();
    
    // default state of all parts is Good, Monster can't be constructed
    // with broken parts
    private ArrayList<PartState> States = new ArrayList();

    private Observer obs = new Observer(){

        @Override
        public void setSubject(Subject sub) {
        }

        @Override
        public void update(MonsterPart part, PartState state) {
            int i = 0;
            ArrayList<MonsterPart> parts= getParts();
            for (MonsterPart p : parts) {
                if (p.equals(part)) {
                    States.set(i, new BrokenState());
                }
                i++;
            }
        }
        
    };

    public int getMaxHP() {
        return maxHitPoints;
    }
    public int getCurrentHP() {
        return currentHitPoints;
    }
    public String getName() {
        return name;
    }

    public Observer getObserver() {
        return obs;
    }

    /**
     * Method to access a Monster's parts
     * @return a list of the Monster's MonsterParts
     */
    public ArrayList<MonsterPart> getParts(){
        ArrayList<MonsterPart> partList = new ArrayList();
        partList.add(head);
        for(Limb l : limbs){
            partList.add(l);
        }
        if(tail != null){
            partList.add(tail);
        }
        return partList;
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

        for (MonsterPart p : getParts()) {
            States.add(new GoodState());
        }
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
        if(tail != null){
            tail.accept(v);
        }
    }
     @Override
    public String toString(){
        String str = "Monster: " + name 
                + "\nHP: " + currentHitPoints + "/" + maxHitPoints + "\n";
        
        for (PartState p : States) {
            if (p.isBroken()) {
                str += " A Part is Broken\n";
            }
        }
        
        return str;
    }

    /**
     * Sets this Monster as the parent
     * of each of its MonsterParts
     */
    private void setParent(){
        head.setParent(this);
        if(tail != null){
            tail.setParent(this);
        }
        for(Limb l : limbs){
            l.setParent(this);
        }
    }
    
    public static class MonsterBuilder{
        private Head builderHead;
        private Tail builderTail;
        private ArrayList<Limb> builderLimbs = new ArrayList();

        public Monster build(String monsterName) {
            return new Monster(monsterName, builderHead, builderLimbs, builderTail);
        }

        public void addHead(IElement element) {
            builderHead = new Head(element);
        }

        public void addTail(IElement element) {
            builderTail = new Tail(element);
        }

        public void addArms(int numArms, IElement element) {
            for(int i = 0; i < numArms; i++) {
                builderLimbs.add(new Arm(element));
            }
        }

        public void addLegs(int numLegs, IElement element) {
            for(int i = 0; i < numLegs; i++) {
                builderLimbs.add(new Leg(element));
            }
        }

        public void addWings(int numWings, IElement element) {
            for(int i = 0; i < numWings; i++) {
                builderLimbs.add(new Wing(element));
            }
        }

        public void addFins(int numFins, IElement element) {
            for(int i = 0; i < numFins; i++) {
                builderLimbs.add(new Fin(element));
            }
        }
    }

}

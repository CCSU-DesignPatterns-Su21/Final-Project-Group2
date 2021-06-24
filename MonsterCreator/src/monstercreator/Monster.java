package monstercreator;

/**
 *
 * @author zachb
 */
public class Monster implements Product, Visitable{
    
    private String name;
    private final int maxHitPoints = 10000;
    private int currentHitPoints;
    private Head head;
    private Tail tail;
    private Limb forelimb;
    private Limb hindLimb;
    
    public int getMaxHP(){
        return maxHitPoints;
    }
    public int getCurrentHP() {
        return currentHitPoints;
    }
    public String getName() {
        return name;
    }
    
    public Monster(String n, Head h, Limb f, Limb r, Tail t ){
        name = n;
        currentHitPoints = maxHitPoints;
        head = h;        
        forelimb = f;
        hindLimb = r;    
        tail = t;
        // create bidirectional relationship
        setParent();
    }
    @Override
    public void accept(Visitor v){
        v.visitMonster(this);
        // send visitor to other parts
        head.accept(v);
        forelimb.accept(v);
        hindLimb.accept(v);
        tail.accept(v);
    }
/*     @Override
    public String toString(){
        String str = "Monster: " + name 
                + "\nHP: " + currentHitPoints + "/" + maxHitPoints
                + "\nHead: " + head.toString() 
                + "\nForelimb: " + forelimb.toString() 
                + "\nHind Limb: " + hindLimb.toString()
                + "\nTail: " + tail.toString() + '\n';
        return str;
    } */

    private void setParent(){
        head.setParent(this);
        forelimb.setParent(this);
        hindLimb.setParent(this);
        tail.setParent(this);
    }
}

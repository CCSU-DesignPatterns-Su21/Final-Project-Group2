package monstercreator;

/**
 *
 * @author zachb
 */
public class Monster implements Product, Visitable{
    
    private String name;
    private int maxHitPoints, currentHitPoints;
    private Head head;
    private Tail tail;
    private Limb forelimb;
    private Limb hindLimb;
    
    public int getMaxHP(){
        return maxHitPoints;
    }
    public int getCurrentHP(){
        return currentHitPoints;
    }
    
    public Monster(String n,int HP, Head h, Tail t, Limb f, Limb r ){
        name = n;
        currentHitPoints = maxHitPoints = HP;
        head = h;
        tail = t;
        forelimb = f;
        hindLimb = r;        
    }
    @Override
    public void accept(Visitor v){
        
    }
    @Override
    public String toString(){
        String str = "[Monster: " + name 
                + " HP: " + currentHitPoints + "/" + maxHitPoints
                + " Head: " + head.toString() 
                +  "Forelimb: " + forelimb.toString() 
                + " Hind Limb: " + hindLimb.toString()
                + " Tail: " + tail.toString() + '\n';
        return str;
    }
}

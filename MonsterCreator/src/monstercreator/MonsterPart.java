package monstercreator;

/**
 * Abstract class that contains all
 * common attributes and behaviors
 * of the concrete MonsterParts.
 * A MonsterPart is broken when its 
 * currentHitPoints reach 0.
 * A MonsterPart does not need to be broken 
 * for the Monster to be defeated.
 * @author zachb
 */
public abstract class MonsterPart implements Visitable {
    
    private final int maxHitPoints = 2000;
    private int currentHitPoints;
    private int attackStr;
    private Monster parent;
    private PartState curState = new GoodState();
    
    public final int getMaxHP(){
        return maxHitPoints;
    }

    final void setCurrentHP(int value){
        currentHitPoints = value;
    }

    public final int getCurrentHP(){
        return currentHitPoints;
    }

    void setAttackStr(int value){
        attackStr = value;
    }

    public int getAttackStr(){
        return attackStr;
    }

    public void attack(MonsterPart target){
        curState.attack(this.getParent(), target.getParent(), this, target);
    }

    public void takeDamage(int damage){
        // Observer pattern - notify parent Monster of damage taken
        curState.takeDamage(this, damage);
    }
    
    void changeState(PartState newState){
        curState = newState;
    }

    protected final void setParent(Monster monster){
        parent = monster;
    }
    
    public final Monster getParent(){
        return parent;
    }
    
    public MonsterPart(){
        setCurrentHP(getMaxHP());
    }    
}

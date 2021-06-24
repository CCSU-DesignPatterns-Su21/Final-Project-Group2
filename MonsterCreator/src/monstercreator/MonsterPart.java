package monstercreator;

/**
 * Abstract class that contains all
 * common attributes and behaviors
 * of the concrete MonsterParts
 * @author zachb
 */
public abstract class MonsterPart implements Visitable {
    
    private final int maxHitPoints = 2000;
    private int currentHitPoints;
    private Monster parent;
    private Element element;
    
    
    public final int getMaxHP(){
        return maxHitPoints;
    }
    public final void setCurrentHP(int value){
        currentHitPoints = value;
    }
    public final int getCurrentHP(){
        return currentHitPoints;
    }
    public final void setElement(Element type){
        element = type;
    }
    public final Element getElement(){
        return element;
    }
    public final void setParent(Monster monster){
        parent = monster;
    }
    public final Monster getParent(){
        return parent;
    }
    
}

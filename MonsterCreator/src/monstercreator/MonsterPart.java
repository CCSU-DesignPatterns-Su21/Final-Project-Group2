package monstercreator;

/**
 *
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
    public final void setParent(Monster mon){
        parent = mon;
    }
    public final Monster getParent(){
        return parent;
    }
    
}

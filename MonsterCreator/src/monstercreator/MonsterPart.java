package monstercreator;

/**
 *
 * @author zachb
 */
public abstract class MonsterPart implements Visitable {
    
    private int maxHitPoints, currentHitPoints;
    private Monster parent;
    private Element element;
    
    public int getMaxHP(){
        return maxHitPoints;
    }
    public int getCurrentHP(){
        return currentHitPoints;
    }
    public Element getElement(){
        return element;
    }
    public Monster getParent(){
        return parent;
    }
    
}

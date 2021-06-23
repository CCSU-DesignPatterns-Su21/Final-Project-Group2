package monstercreator;

/**
 *
 * @author zachb
 */
public class Head extends MonsterPart {
    
    public Head(Element type){
        setElement(type);
        setCurrentHP(getMaxHP());
    }

    /**
     *
     * @param v
     */
    @Override
    public void accept(Visitor v){
        v.visitHead(this);
    }
    
}

package monstercreator;

/**
 *
 * @author zachb
 */
public class Tail extends MonsterPart {
    public Tail(Element type){
        setCurrentHP(getMaxHP());
        setElement(type);
    }
    public void accept(Visitor v){
        v.visitTail(this);
    }
    
}

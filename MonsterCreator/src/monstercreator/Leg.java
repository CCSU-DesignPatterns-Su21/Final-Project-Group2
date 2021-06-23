package monstercreator;

/**
 *
 * @author zachb
 */
public class Leg extends Limb {
    public Leg(Element type){
        setCurrentHP(getMaxHP());
        setElement(type);
    }
    public void accept(Visitor v){
        v.visitLeg(this);
    }
}

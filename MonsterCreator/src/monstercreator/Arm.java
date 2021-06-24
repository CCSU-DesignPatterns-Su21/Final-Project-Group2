package monstercreator;

/**
 * MonsterPart.
 * Concrete Limb
 * @author zachb
 */
public class Arm extends Limb{
    
    public Arm(Element type){
        setCurrentHP(getMaxHP());
        setElement(type);
    }
    public void accept(Visitor v){
        v.visitArm(this);
    }
}

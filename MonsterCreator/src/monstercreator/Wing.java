package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Wing extends Limb {
    public Wing(Element type){
        setCurrentHP(getMaxHP());
        setElement(type);
    }
    public void accept(Visitor v){
        v.visitWing(this);
    }
}

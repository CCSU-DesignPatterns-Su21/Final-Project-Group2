package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Fin extends Limb{
    public Fin(Element type){
        setCurrentHP(getMaxHP());
        setElement(type);
    }
    
    public void accept(Visitor v){
        v.visitFin(this);
    }
}

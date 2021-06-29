package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Fin extends Limb{
    public Fin(){}
    
    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    @Override
    public void accept(Visitor v){
        v.visitFin(this);
    }
}

package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Fin extends Limb{
    public Fin(IElement type){
        super(type);
    }
    
    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    @Override
    public void accept(Visitor v){
        v.visitFin(this);
    }
}

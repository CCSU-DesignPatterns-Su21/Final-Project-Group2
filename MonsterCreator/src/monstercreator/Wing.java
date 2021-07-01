package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Wing extends Limb {
    public Wing(IElement type){
        super(type);
    }

    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    @Override
    public void accept(Visitor v){
        v.visitWing(this);
    }
    @Override
    public String toString(){
        String str = "Wings: [" + super.toString() + "]\n";
        return str;
    }
}

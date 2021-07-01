package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Leg extends Limb {
    public Leg(IElement type){
        super(type);
    }

    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    @Override
    public void accept(Visitor v){
        v.visitLeg(this);
    }
    public String toString(){
        String str = "Legs: [" + super.toString() + "]\n";
        return str;
    }
}

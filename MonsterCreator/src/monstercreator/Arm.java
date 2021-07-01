package monstercreator;

/**
 * MonsterPart.
 * Concrete Limb
 * @author zachb
 */
public class Arm extends Limb{
    
    public Arm(IElement type){
        super(type);
    }

    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    public void accept(Visitor v){
        v.visitArm(this);
    }
    @Override
    public String toString(){
        String str = "Arms: [" + super.toString() + "]\n";
        return str;
    }
}

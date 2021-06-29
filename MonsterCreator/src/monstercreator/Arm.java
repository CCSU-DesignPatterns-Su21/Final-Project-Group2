package monstercreator;

/**
 * MonsterPart.
 * Concrete Limb
 * @author zachb
 */
public class Arm extends Limb{
    
    public Arm(){}

    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    public void accept(Visitor v){
        v.visitArm(this);
    }
    
    @Override
    public String toString(){
        String str = "Arm: [HP: " + getCurrentHP() + "/" + getMaxHP()+ "]\n";
        return str;
    }
}

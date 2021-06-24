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
    public String toString(){
        String str = "Arm: [" + getElement()
                + ", HP: " + getCurrentHP() + "/" + getMaxHP() + "]\n";
        return str;
    }
}

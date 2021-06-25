package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Leg extends Limb {
    public Leg(Element type){
        super(type);
    }
    public void accept(Visitor v){
        v.visitLeg(this);
    }
    public String toString(){
        String str = "Leg: [" + getElement()
                + ", HP: " + getCurrentHP() + "/" + getMaxHP() + "]\n";
        return str;
    }
}

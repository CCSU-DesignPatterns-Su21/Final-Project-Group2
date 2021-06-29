package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Leg extends Limb {
    public Leg(){}

    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    @Override
    public void accept(Visitor v){
        v.visitLeg(this);
    }
    public String toString(){
        String str = "Leg: [HP: " + getCurrentHP() + "/" + getMaxHP()+ "]\n";
        return str;
    }
}

package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Wing extends Limb {
    public Wing(Element type){
        super(type);
    }
    public void accept(Visitor v){
        v.visitWing(this);
    }
public String toString(){
        String str = "Wing: [" + getElement()
                + ", HP: " + getCurrentHP() + "/" + getMaxHP() + "]\n";
        return str;
    }
}

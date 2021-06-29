package monstercreator;

/**
 * MonsterPart
 * concrete Limb
 * @author zachb
 */
public class Wing extends Limb {
    public Wing(){}

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
        String str = "Wing: [HP: " + getCurrentHP() + "/" + getMaxHP()+ "]\n";
        return str;
    }
}

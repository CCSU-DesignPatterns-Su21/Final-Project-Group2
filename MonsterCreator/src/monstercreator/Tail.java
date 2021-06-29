package monstercreator;

/**
 * Each Monster must have
 * exactly one Tail
 * @author zachb
 */
public class Tail extends MonsterPart {
    public Tail(){}

    /**
     * For participation in Visitor pattern
     * @param v accepted Visitor
     */
    @Override
    public void accept(Visitor v){
        v.visitTail(this);
    }
    
    @Override
    public String toString(){
        String str = "Tail: [HP: " + getCurrentHP() + "/" + getMaxHP()+ "]\n";
        return str;
    }
}

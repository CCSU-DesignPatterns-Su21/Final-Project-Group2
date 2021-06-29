package monstercreator;

/**
 * MonsterPart
 * Each Monster must have 
 * exactly one Head
 * @author zachb
 */
public class Head extends MonsterPart {
    
    public Head(){}

    /**
     * 
     * @param v
     */
    @Override
    public void accept(Visitor v){
        v.visitHead(this);
    }
    
    public String toString(){
        String str = "Head: [HP: " + getCurrentHP() + "/" + getMaxHP()+ "]\n";
        return str;
    }
}

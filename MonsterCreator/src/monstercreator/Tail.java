package monstercreator;

/**
 * Each Monster must have
 * exactly one Tail
 * @author zachb
 */
public class Tail extends MonsterPart {
    public Tail(Element type){
        setCurrentHP(getMaxHP());
        setElement(type);
    }
    public void accept(Visitor v){
        v.visitTail(this);
    }
    
    public String toString(){
        String str = "Tail: [" + getElement()
                + ", HP: " + getCurrentHP() + "/" + getMaxHP()+ "]\n";
        return str;
    }
}

package monstercreator;

/**
 * MonsterPart
 * Each Monster must have 
 * exactly one Head
 * @author zachb
 */
public class Head extends MonsterPart {
    
    public Head(IElement type){
        super(type);
    }

    /**
     * 
     * @param v
     */
    @Override
    public void accept(Visitor v){
        v.visitHead(this);
    }
    
    public String toString(){
        String str = "Head:[" + super.toString() + "]\n";
        return str;
    }
}

package monstercreator;

/**
 *
 * @author zachb
 */
public class Water implements IElement {
    
    private static IElement instance;
    
    public static IElement getInstance(){
        if(instance == null){
            instance = new Water();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    public IElement getWeakness(){
        return Electric.getInstance();
    }
    
    private Water(){
        
    }
    
    public String toString(){
        return"WATER";
    }
}

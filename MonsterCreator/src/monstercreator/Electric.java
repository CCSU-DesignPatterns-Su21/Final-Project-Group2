package monstercreator;

/**
 *
 * @author zachb
 */
public class Electric implements IElement{
    
    private static IElement instance;
    
    public static IElement getInstance(){
        if(instance == null){
            instance = new Electric();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    public IElement getWeakness(){
        return Ice.getInstance();
    }
    
    private Electric(){
        
    }
    
    public String toString(){
        return "ELECTRIC ";
    }
}

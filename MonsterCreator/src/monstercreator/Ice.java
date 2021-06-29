package monstercreator;

/**
 *
 * @author zachb
 */
public class Ice implements IElement{
    
    private static IElement instance;
    
    public static IElement getInstance(){
        if(instance == null){
            instance = new Ice();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    public IElement getWeakness(){
        return Fire.getInstance();
    }
    
    private Ice(){
        
    }
    
    public String toString(){
        return "ICE ";
    }
}

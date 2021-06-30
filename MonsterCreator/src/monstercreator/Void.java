package monstercreator;

/**
 * Special element type for Cthulhu monster, only weakness is itself
 * @author Jeremiah Smith
 */
public class Void implements IElement{
    private static IElement instance;
    
    public static IElement getInstance(){
        if(instance == null){
            instance = new Void();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    public IElement getWeakness(){
        return Void.getInstance();
    }
    
    private Void(){
        
    }
    
    public String toString(){
        return "VOID ";
    }  
}

package monstercreator;

/**
 *
 * @author zachb
 */
public class Fire implements IElement{

    private static IElement instance;
    
    public static IElement getInstance(){
        if(instance == null){
            instance = new Fire();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    public IElement getWeakness(){
        return Water.getInstance();
    }
    
    private Fire(){
        
    }
    
    public String toString(){
        return "FIRE ";
    }
}

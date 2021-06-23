package monstercreator;

/**
 *
 * @author zachb
 */
public class MonsterFactory implements Factory{
    
    private static MonsterFactory instance;
    
    private MonsterFactory(){}
    
    public static MonsterFactory getInstance(){
        if(instance == null){
            instance = new MonsterFactory();
            return instance;
        }
        else{
            return instance;
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public Monster create(){
        /**
         *  TODO - creation logic and interface
         *  create parts and assemble Monster?
         */
    }
    public static void main(String[] args){
        
    }
}

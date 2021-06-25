package monstercreator;

/**
 *
 * @author zachb
 */
public interface IMonster {
    
    public void accept(Visitor v);
    public int getMaxHP();
    public int getCurrentHP();
    public String getName();
}

package monstercreator;

import java.util.ArrayList;

/**
 *
 * @author zachb
 */
public interface IMonster {
    
    public void accept(Visitor v);
    public int getMaxHP();
    public int getCurrentHP();
    public String getName();
    public ArrayList<MonsterPart> getParts();
}

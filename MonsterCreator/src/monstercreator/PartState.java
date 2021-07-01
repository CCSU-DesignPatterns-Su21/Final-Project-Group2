package monstercreator;

/**
 *
 * @author zachb
 */
public interface PartState {
    
    void attack(MonsterPart attacker, MonsterPart target);
    void takeDamage(MonsterPart part, int damage);
    public boolean isBroken();
}

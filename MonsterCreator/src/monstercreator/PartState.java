package monstercreator;

/**
 *
 * @author zachb
 *         Jeremiah Smith
 */
public interface PartState {  
    void attack(Monster attacker, Monster target, MonsterPart attackingLimb, MonsterPart targetLimb);

    void takeDamage(MonsterPart targetLimb, int damage);  
}

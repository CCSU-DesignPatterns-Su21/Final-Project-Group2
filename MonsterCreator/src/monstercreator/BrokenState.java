package monstercreator;

/**
 *
 * @author zachb
 */
public class BrokenState implements PartState {
    
    /**
     *
     * @param attacker The Part performing the attack
     * @param target The Part taking damage
     */
    public void attack(MonsterPart attacker, MonsterPart target){
        // Broken part deals 1/2 damage
        int damage = attacker.getAttackStr() / 2;
        // No Element bonus for broken part
        target.takeDamage(damage);
    }

    public void takeDamage(MonsterPart part, int damage) {
        // Part HP can't be further depleted, no logic needed
    }
}

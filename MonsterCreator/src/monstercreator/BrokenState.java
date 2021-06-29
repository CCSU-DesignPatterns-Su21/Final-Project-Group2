package monstercreator;

/**
 * A MonsterPart in BrokenState
 * deals less damage with no Element,
 * and deals recoil damage to the parent Monster
 * @author zachb
 *         Jeremiah Smith
 */
public class BrokenState implements PartState {
    
    /**
     * When broken, a MonsterPart's attack
     * deals reduced damage and takes recoil
     * @param attacker The Monster attacking
     * @param target The Monster being attacked
     * @param attackingLimb The Part attacking
     * @param targetLimb The Part being attacked
     */
    @Override
    public void attack(Monster attacker, Monster target, MonsterPart attackingLimb, MonsterPart targetLimb){
        // Broken part deals 1/2 damage
        int damage = attackingLimb.getAttackStr() / 2;

        // No Element bonus for broken part
        target.takeDamage(damage);

        // deal recoil damage to parent Monster
        attacker.takeDamage(damage);
    }

    /**
     *
     * @param part The part taking damage
     * @param damage the damage value
     */
    @Override
    public void takeDamage(MonsterPart part, int damage) {
        
        part.getParent().takeDamage(damage);
    }
}

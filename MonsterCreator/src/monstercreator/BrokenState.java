package monstercreator;

/**
 * A MonsterPart in BrokenState
 * deals less damage with no Element,
 * and deals recoil damage to the parent Monster
 * @author zachb
 */
public class BrokenState implements PartState {
    
    /**
     * When broken, a MonsterPart's attack
     * deals reduced damage and takes recoil
     * @param attacker The Part performing the attack
     * @param target The Part taking damage
     */
    @Override
    public void attack(MonsterPart attacker, MonsterPart target){
        // Broken part deals 1/2 damage
        int damage = attacker.getAttackStr() / 2;
        // No Element bonus for broken part
        target.takeDamage(damage);
        // deal recoil damage to parent Monster
        attacker.getParent().takeDamage(damage);
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
    public boolean isBroken(){
        return true;
    }
    public String toString(){
        return " BROKEN"; 
    }
}

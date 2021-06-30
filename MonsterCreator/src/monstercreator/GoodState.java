package monstercreator;

/**
 * a MonsterPart's default State
 * @author zachb
 */
public class GoodState implements PartState {

    /**
     * This method is called to perform a MonsterPart's attack
     * dealing damage to a targeted MonsterPart
     * @param attacker The Part performing the attack
     * @param target The Part taking damage
     */
    @Override
    public void attack(MonsterPart attacker, MonsterPart target) {
        int damage = attacker.getAttackStr();
        
        if(attacker.getElement() == target.getWeakness()){
            // Element advantage doubles damage
            damage *= 2;
        }
         target.takeDamage(damage);
    }

    /**
     * This method handles adjusting a damaged MonsterPart's 
     * Hit Points and change of State if necessary.
     * Damage to a MonsterPart includes equivalent damage
     * dealt to the parent Monster.
     * @param part The part taking damage
     * @param damage the damage value
     */
    @Override
    public void takeDamage(MonsterPart part, int damage){
        int newHP = part.getCurrentHP() - damage;
        if(newHP <= 0){
            part.changeState(new BrokenState());
            newHP = 0;
        }
        part.setCurrentHP(newHP);
        part.getParent().takeDamage(damage);
    }
    public boolean isBroken(){
        return false;
    }
    public String toString(){
        return ""; //don't specify State unless Broken
    }
    
}

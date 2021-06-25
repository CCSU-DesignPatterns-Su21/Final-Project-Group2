package monstercreator;

/**
 *
 * @author zachb
 */
public class GoodState implements PartState {

    /**
     *
     * @param attacker The Part performing the attack
     * @param target The Part taking damage
     */
    public void attack(MonsterPart attacker, MonsterPart target) {
        int damage = attacker.getAttackStr();
        // TODO - Element effective logic
         target.takeDamage(damage);
    }
    public void takeDamage(MonsterPart part, int damage){
        int newHP = part.getCurrentHP() - damage;
        if(newHP <= 0){
            part.changeState(new BrokenState());
            newHP = 0;
        }
        part.setCurrentHP(newHP);
    }
    
}

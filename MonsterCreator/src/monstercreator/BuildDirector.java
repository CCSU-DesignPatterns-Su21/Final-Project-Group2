package monstercreator;

/**
 *
 * @author zachb
 */
public class BuildDirector {
    
    public static void buildBipedMonster(Monster.MonsterBuilder builder, IElement type){
        // add head, arms, legs, tail, element
    }
    public static void buildQuadrupedMonster(Monster.MonsterBuilder builder, IElement type){
        // add head, legs, legs, tail, element
    }
    public static void buildWyvern(Monster.MonsterBuilder builder, IElement type){
        // add head, wings, legs, tail, element
    }
    public static void buildElderDragon(Monster.MonsterBuilder builder, IElement type){
        // add head, wings, legs, legs, tail, element
        /*
            **TODO**
            rework Monster to have a List of Limbs
            to support an abstract number of Limbs 
        */
    }
}

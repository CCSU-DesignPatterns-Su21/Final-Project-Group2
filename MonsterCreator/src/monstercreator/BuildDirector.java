package monstercreator;

/**
 * Provides several monster presets for the user to build immediately without customizing
 * @author zachb
 *         Jeremiah Smith
 */
public class BuildDirector {
    
    public static void buildBipedMonster(Monster.MonsterBuilder builder, IElement type){
        builder.addHead(type);
        builder.addTail(type);
        builder.addArms(2, type);
        builder.addLegs(2, type);
    }

    public static void buildQuadrupedMonster(Monster.MonsterBuilder builder, IElement type){
        builder.addHead(type);
        builder.addTail(type);
        builder.addLegs(4, type);
    }

    public static void buildAerialMonster(Monster.MonsterBuilder builder, IElement type){
        builder.addHead(type);
        builder.addTail(type);
        builder.addLegs(2, type);
        builder.addWings(2, type);
    }

    public static void buildOceanicMonster(Monster.MonsterBuilder builder, IElement type){
        builder.addHead(type);
        builder.addTail(type);
        builder.addFins(2, type);
    }

    public static void buildFireDragon(Monster.MonsterBuilder builder){
        builder.addHead(Fire.getInstance());
        builder.addTail(Fire.getInstance());
        builder.addArms(2, Fire.getInstance());
        builder.addLegs(4, Fire.getInstance());
        builder.addWings(2, Fire.getInstance());
    }

    public static void buildStormDrake(Monster.MonsterBuilder builder){
        builder.addHead(Electric.getInstance());
        builder.addTail(Electric.getInstance());
        builder.addArms(2, Electric.getInstance());
        builder.addLegs(2, Electric.getInstance());
        builder.addWings(2, Electric.getInstance());
    }

    public static void buildIceKraken(Monster.MonsterBuilder builder){
        builder.addHead(Ice.getInstance());
        builder.addTail(Ice.getInstance());
        builder.addArms(8, Ice.getInstance());
        builder.addLegs(8, Ice.getInstance());
        builder.addFins(8, Ice.getInstance());
    }

    public static void buildCthulhu(Monster.MonsterBuilder builder){
        builder.addHead(Void.getInstance());
        builder.addTail(Void.getInstance());
        builder.addArms(20, Void.getInstance());
        builder.addLegs(20, Void.getInstance());
    }
}

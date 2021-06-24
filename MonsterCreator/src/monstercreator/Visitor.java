package monstercreator;

/**
 * Implements Visitor pattern
 * @author zachb
 */
public class Visitor {
    private String name = "";
    private int currentHitPoints = 0;
    private int maxHitPoints = 0;
    private int head = 0;
    private int foreLimb = 0;
    private int hindLimb = 0;
    private int tail = 0;

    public String toString() {
        String outputString = "Monster: " + name;
        outputString += "\nHP: " + currentHitPoints + "/" + maxHitPoints;
        outputString+= "\nHead: " + head;
        outputString+="\nFore Limb: " + foreLimb;
        outputString+= "\nHind Limb: " + hindLimb;
        outputString+= "\nTail: " + tail + '\n';
        return outputString;
    }
    
    public void visitMonster(Monster mon) {
        name = mon.getName();
        currentHitPoints = mon.getCurrentHP();
        maxHitPoints = mon.getMaxHP();
    }
    public void visitHead(Head head){
        this.head = head.getCurrentHP();
    }
    public void visitTail(Tail tail){
        this.tail = tail.getCurrentHP();
    }
    public void visitArm(Arm arm){
        foreLimb = arm.getCurrentHP();
    }
    public void visitLeg(Leg leg){
        hindLimb = leg.getCurrentHP();
    }
    public void visitWing(Wing wing){
        
    }
    public void visitFin(Fin fin){
        
    }
    
}

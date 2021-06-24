package monstercreator;

/**
 * Implements Visitor pattern
 * @author zachb
 */
public class Visitor {
    private String monsterSummary = "";

    @Override
    public String toString() {
        return monsterSummary;
    }
    
    public void visitMonster(Monster mon) {
        monsterSummary += mon.toString();
    }
    public void visitHead(Head head){
        monsterSummary += head.toString();
    }
    public void visitTail(Tail tail){
        monsterSummary += tail.toString();
    }
    public void visitArm(Arm arm){
        monsterSummary += arm.toString();
    }
    public void visitLeg(Leg leg){
        monsterSummary += leg.toString();
    }
    public void visitWing(Wing wing){
        monsterSummary += wing.toString();
    }
    public void visitFin(Fin fin){
        monsterSummary += fin.toString();
    }
   
}

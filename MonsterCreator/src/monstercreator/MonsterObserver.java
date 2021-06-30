package monstercreator;

public class MonsterObserver implements Observer {

    private Subject subject;

    public MonsterObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(Subject subject) {
        System.out.println("limb damaged");
        
    }
}

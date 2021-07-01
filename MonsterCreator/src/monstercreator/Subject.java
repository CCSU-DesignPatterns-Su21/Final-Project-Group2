package monstercreator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zachb
 */
public class Subject {
    
    private List<Observer> observers;
    private PartState state;
    
    public Subject() {
        this.observers = new ArrayList<>();
    }
/*     public void setState(PartState state) {
        this.state = state;
        notif();
    } */
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notif(MonsterPart part, PartState state) {

        for(Observer o : observers){
            o.update(part, state);
        }
    }
    
}

package monstercreator;

import java.util.List;

/**
 *
 * @author zachb
 */
public abstract class Subject {
    
    private List<Observer> observers;
    
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach(Observer observer){
        observers.remove(observer);
    }
    public void notif(){
        for(Observer o : observers){
            o.update(this);
        }
    }
    
}

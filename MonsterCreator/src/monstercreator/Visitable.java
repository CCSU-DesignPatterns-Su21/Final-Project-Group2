package monstercreator;

/**
 * Interface to support
 * Visitor design pattern
 * @author zachb
 */
public interface Visitable {
    public void accept(Visitor v);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monstercreator;

/**
 *
 * @author zachb
 */
public interface Observer {
    public void setSubject(Subject sub);
    public void update(MonsterPart part, PartState state);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.DoublyLinkedList;

/**
 *
 * @author jearo
 */
public interface GlobalListBehavior<X> {

    public boolean isEmpty();

    public void insert(X element);

    public X consult(X element);

    public void update(X initialElem, X replacedElem);
    
    public String toString();

}

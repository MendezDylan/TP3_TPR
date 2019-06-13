/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

/**
 *
 * @author jearo
 * @param <X>
 */
public interface LinkedListBehavior<X> extends GlobalListBehavior<X> {

    public void delete(X element);

}

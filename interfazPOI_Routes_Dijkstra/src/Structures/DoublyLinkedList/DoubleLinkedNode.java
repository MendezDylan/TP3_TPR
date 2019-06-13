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
public class DoubleLinkedNode<X> {

    /**
     * Se declaran los atriburos necesarios de la estructura
     */
    private X element;
    private DoubleLinkedNode<X> prev;
    private DoubleLinkedNode<X> next;

    // SE GENERAN LOS GETTERS AND SETTERS
    public X getElement() {
        return element;
    }

    public void setElement(X element) {
        this.element = element;
    }

    public DoubleLinkedNode<X> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedNode<X> prev) {
        this.prev = prev;
    }

    public DoubleLinkedNode<X> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode<X> next) {
        this.next = next;
    }

    /**
     * CONSTRUCROE DE LA CLASE
     *
     * @param element
     */
    public DoubleLinkedNode(X element) {
        this.element = element;
    }

    /**
     * El toString permite dar a conocer el elemento que contiene dicho nodo
     *
     * @return
     */
    @Override
    public String toString() {
        return "element=" + element;
    }

}

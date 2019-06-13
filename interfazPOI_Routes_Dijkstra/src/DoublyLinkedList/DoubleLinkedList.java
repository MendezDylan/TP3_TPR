/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

/**
 *
 * @author jearo Esta clase permite generar una lista doblemente enlazada
 * totalmente funcional
 * @param <X>
 */
public class DoubleLinkedList<X> implements LinkedListBehavior<X> {

    /*
    Primeramente se declaran los atributos
     */
    private DoubleLinkedNode<X> head;
    private DoubleLinkedNode<X> tail;
    private int size;

    // SE GENERAN LOS GETTERS AND SETTER
    public DoubleLinkedNode<X> getHead() {
        return head;
    }

    public void setHead(DoubleLinkedNode<X> head) {
        this.head = head;
    }

    public DoubleLinkedNode<X> getTail() {
        return tail;
    }

    public void setTail(DoubleLinkedNode<X> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Permite insertar elementos dentro de la lista doblemente enlazada Por
     * convención se insertan detrás de la lista
     *
     * @param element
     */
    @Override
    public void insert(X element) {
        if (isEmpty()) {
            head = new DoubleLinkedNode(element);
            tail = head;
            size++;
        } else {
            tail.setNext(new DoubleLinkedNode(element));
            tail.getNext().setPrev(tail);
            tail = tail.getNext();
            size++;
        }
    }

    /**
     * Permite consultar cualquier nodo de la lista según el elemento que
     * contenga el nodo siempre y cuandos ea idéntico al ingresado
     *
     * @param element
     * @return
     */
    @Override
    public X consult(X element) {
        DoubleLinkedNode<X> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.getElement() == element) {
                break;
            }
            else {
                temp = temp.getNext();
            }
        }
        return temp.getElement();
    }

    /**
     * Permite actualizar cualquier elemento de la lista
     *
     * @param initialElem // Parámetro inicial
     * @param replacedElem // Parámetro por el cual se quiere actualizar diho
     * elemento
     */
    @Override
    public void update(X initialElem, X replacedElem) {
        DoubleLinkedNode<X> temp;
        DoubleLinkedNode<X> replacedNode, tempPrev, tempNext;
        temp = head;

        for (int i = 0; i < size; i++) {
            if (temp.getElement().equals(initialElem)) {
                tempPrev = temp.getPrev();
                tempNext = temp.getNext();

                replacedNode = new DoubleLinkedNode<>(replacedElem);
                tempPrev.setNext(replacedNode);
                tempNext.setPrev(replacedNode);
                replacedNode.setPrev(tempPrev);
                replacedNode.setNext(tempNext);

                temp.setPrev(null);
                temp.setNext(null);
                break;
            } else {
                temp = temp.getNext();
            }
        }
    }

    /**
     * Permite eleminar de frente
     */
    private void frontDelete() {
        DoubleLinkedNode<X> temp = head;
        head = head.getNext();
        temp.setNext(null);
        head.setPrev(null);
        size--;
    }

    /**
     * Permite eliminar detrás
     */
    private void rearDelete() {
        DoubleLinkedNode<X> temp = tail;
        tail = tail.getPrev();
        temp.setPrev(null);
        tail.setNext(null);
        size--;
    }

    /**
     * Permite eliminar un únco elemento de la lista
     *
     * @param element
     */
    private void deleteUniqueElement(X element) {
        if (head.getElement().equals(element)) {
            head = null;
            tail = head;
            size--;
        }
    }

    /**
     * Permite eliminar uno de los elementos de una lista de tamaño = 2
     *
     * @param element
     */
    private void deleteOnTowElements(X element) {
        if (head.getElement().equals(element)) {
            frontDelete();
        } else if (tail.getElement().equals(element)) {
            rearDelete();
        }
        size--;
    }

    /**
     * Permite eliminar elementos que se encuentran en medio de 2 nodos
     *
     * @param element
     */
    private void deleteOnMiddle(X element) {
        DoubleLinkedNode<X> temp;
        DoubleLinkedNode<X> tempNext, tempPrev;
        temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.getElement().equals(element)) {
                tempPrev = temp.getPrev();
                tempNext = temp.getNext();
                tempNext.setPrev(tempPrev);
                tempPrev.setNext(tempNext);
                temp.setNext(null);
                temp.setPrev(null);
                break;
            } else {
                temp = temp.getNext();
            }
        }
        size--;
    }

    /**
     * Permite a la´lógica elegir dónde eliminar un nodo
     *
     * @param element
     */
    @Override
    public void delete(X element) {
        if (!isEmpty()) {
            if (tail.getElement().equals(element)) {
                rearDelete();
            } else if (head.getElement().equals(element)) {
                frontDelete();
            } else if (size == 1) {
                deleteUniqueElement(element);
            } else if (size == 2) {
                deleteOnTowElements(element);
            } else if (size >= 3) {
                deleteOnMiddle(element);
            }
        }
    }

    /**
     * Por convención el toString permite conocer los elementos de la lista
     *
     * @return
     */
    @Override
    public String toString() {
        String msg = "";
        DoubleLinkedNode<X> temp = head;
        for (int i = 0; i < size; i++) {
            msg += temp.toString() + "\n";
            temp = temp.getNext();
        }
        return msg;
    }

    /**
     * Permite conocer los elementos de la lista al reverso
     *
     * @return
     */
    public String toStringReverse() {
        String msg = "";
        DoubleLinkedNode<X> temp = tail;
        for (int i = 0; i < size; i++) {
            msg += temp.toString() + "\n";
            temp = temp.getPrev();
        }
        return msg;
    }
}

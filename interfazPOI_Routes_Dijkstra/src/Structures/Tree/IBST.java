/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures.Tree;

/**
 *
 * @author Dylan
 * @param <T>
 */
public interface IBST<T extends Comparable<T>>{
   void insert(T element);
   
   boolean exists(T element);
   
   T get(T element);
   
   boolean isLeaf();
   
   boolean isEmpty();
   
   void preOrder();
   
   void inOrder();
   
   void postOrder();
   
   void delete(T element);
   
    
}

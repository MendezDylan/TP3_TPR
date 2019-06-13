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
 * 
 */
public class BST<T extends Comparable<T>> implements IBST<T>{
    
    private T root;
    private BST<T> left,right;
    private BST<T> parent;
    
    @Override
    public void insert(T element){
        insertImpl(element, null);
    }
    
    //Metodo recursivo para insertar elemento al arbol, el metodo se finaliza
    //cuando se encuentra un BST que esté vacio.
    private void insertImpl(T element, BST parent) {
        //Caso base: Se encuentra una hoja
        if(isEmpty()){
            this.root=element;
            this.parent=parent;
        }else{
            //Compara si el elemento a insertar es mayor o menor que la raiz para
            //para insertarlo a la izq o der.
            if(element.compareTo(root)<0){
                if((left==null)) left=new BST();
                left.insertImpl(element, this);
            }else if(element.compareTo(root)>0){
                if(right==null) right=new BST();
                right.insertImpl(element, this);
            }else{
                //No lo inserta debido a que el elemento ya existe en el arbol.
            }
        }
    }

    @Override
    //Funcion para saber si un elemento es hoja
    public boolean isLeaf() {
        //devuelve TRUE o FALSE dependiendo de si el root de un subarbol
        //tiene o no tiene hijos
        return root!=null && left==null && right==null;
    }

    @Override
    //Funcion boolean para saber si un arbol esta vacio
    public boolean isEmpty() {
        //devuelve true si el root es null, y false si el root es diferente a null
        return root==null;
    }
    
    @Override
    //Metodo para averiguar si un elemento existe o no dentro del arbol.    
    public boolean exists(T element) {
        if(root!=null){
            if(element.compareTo(root)==0){
                return true;
            }else if(element.compareTo(root)<0 && left!=null){
                return left.exists(element);
            }else if(element.compareTo(root)>0 && right!=null){
                return right.exists(element);
            }else{
                return false;
            }
        //el elemento no se encontró
        }else{
            return false;
        }
    }
    
    @Override
    //Metodo para buscar y obtener un valor del arbol, en caso de que no exista
    //deveulve 0.
    //DEDE VALIDARSE CON EL METODO EXISTS ANTES DE HACER LA BUSQUEDA.    
    public T get(T element){
        if(root!=null){
            if(element.compareTo(root)==0){
                return element;
            }else if(element.compareTo(root)<0 && left!=null){
                return left.get(element);
            }else if(element.compareTo(root)>0 && right!=null){
                return right.get(element);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    
    @Override
    //Metodo para imprimir en consola el recorrido en preorden del BST
    //Funcion recursiva indirecta
    public void preOrder() {
        preOrderImpl("");
    }
    private void preOrderImpl(String str){
        if(root!=null){
             System.out.println(str + root);
             if(left!=null) left.preOrderImpl(str + "  ");
             if(right!=null) right.preOrderImpl(str + "  ");
        }        
    }
    
    @Override
    //Metodo para imprimir en consola el recorrido en indorden del BST
    //Funcion recursiva indirecta
    public void inOrder() {
        inOrderImpl("");
    }
    private void inOrderImpl(String str){
        if(root!=null){
             if(left!=null) left.inOrderImpl(str + "  ");
             System.out.println(str + root);
             if(right!=null) right.inOrderImpl(str + "  ");
        }        
    }
    
    @Override
    //Metodo para imprimir en consola el recorrido en postorden del BST
    //Funcion recursiva indirecta
    public void postOrder() {
        postOrderImpl("");
    }
    private void postOrderImpl(String str){
        if(root!=null){
             if(right!=null) right.postOrderImpl(str + "  ");
             if(left!=null) left.postOrderImpl(str + "  ");
             System.out.println(str + root);
        }        
    }

    @Override
    /*Metodos para eliminar un elemento del BST
      Funcion recursiva indirecta*/
    
    /*Busca el elemento de manera recursiva.
      El metodo se detiene cuando encuentra el elemento en la raiz de un
      subarbol y llama al siguiente metodo para eliminar.*/
    public void delete(T element) {

        if(root!=null){
            if(root.compareTo(element)==0){
                deleteImpl(element);
            }else if(element.compareTo(root)<0 && left!=null){
                left.delete(element);
            }else if(element.compareTo(root)>0 && right!=null){
                right.delete(element);
            }
        }else{
          //Arbol vacio  
        }
    }
    //Metodo para buscar el elemento mas a la izquierda
    private BST minimum(){
        if(left!=null && !left.isEmpty()){
            return left.minimum();
        }else{
            return this;
        }
    }
    //Metodo para eliminar
    private void deleteImpl(T element){
        if(left!=null && right!=null){//elimina con 2 hijos
            BST<T> min=right.minimum();
            this.root=min.root;
            right.delete(min.root);
        }else if (left!=null || right!=null){//elimina con 1 hijo
            BST<T> replacement= left!=null ? left:right;
            this.root=replacement.root;
            this.left=replacement.left;
            this.right=replacement.right;
        }else{//elimina con 0 hijos
            if(this == parent.left) parent.left=null;
            if(this == parent.right) parent.right=null;
            parent=null;
        }
    }

}

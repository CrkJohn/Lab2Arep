package edu.escuelaing.arem.firstWorkshop;



/**
 * Esta clase representa el nodo de tipo T que esta almacenado en una linked list,
 * donde en el tiene almacenado el nodo siguiente a él y a su vez el anterior
 * 
 * @author CrkJohn
 *  
 */

public class Node<T> {
	
	private Node next , before;
	T data;
	
	
	/**
	 * Constructor de la clase
	 * @param data valor del nodo
	 * @param next nodo siguiente de la linked list
	 * @param before nodo anterior de la linked list
	 */
	public Node(T data, Node next, Node before) {
		 this.data = data;
		 this.next = next;
		 this.before = before;
	}
	
	/**
	 * @return retorno el nodo siguiente del invocado, este puede ser nulo si la cola de la linked list.
	 */
	public Node getNext() {
		return next;
	}

	
	/**
	 *  @param next el nodo adyancente al cual se le quiere generar un puntero.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	

	/**
	 * @return retorno el nodo anterior del invocado, este puede ser nulo si es la cabeza de la linked list.
	 */
	public Node getBefore() {
		return before;
	}
	
	
	/**
	 * @param before el nodo anterior al cual se le quiere generar un puntero.
	 */

	public void setBefore(Node before) {
		this.before = before;
	}
	
	
	/**
	 * @return retorna el valor de tipo T almacenado en el nodo
	 */
	

	public T getData() {
		return data;
	}
	
	
	/**
	 * @param data valor que se quiere almacenar en el nodo
	 */	

	public void setData(T data) {
		this.data = data;
	}
	
	
	
	/**
	 * @return retorna la representacion en string del valor almacenado
	 */
	public String toString() {
		return data.toString();
	}

	
}

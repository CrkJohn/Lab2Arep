package edu.escuelaing.arem.firstWorkshop;


/**
 *  Clase que representa la funciones basicas de una linked list
 *  
 *  @author CrkJohn
 */
public interface ILikendList<T> {
	
	
	/**
	 *  @param node nodo que se quiere agregar a la linked list
	 */
	
	public void add(T node);
	
	
	/**
	 * @param id indice del nodo que se desea obtener de la linked list
	 * @return retorna el nodo indexado en ese id
	 */
	
	public T getNode(int id) throws Exception;

}

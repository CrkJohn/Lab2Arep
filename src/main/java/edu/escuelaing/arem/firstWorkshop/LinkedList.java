package edu.escuelaing.arem.firstWorkshop;



/**
 * Clase que representa una linked list de tipo T
 * 
 * @author CrkJohn 
 */
public class LinkedList<T> implements ILikendList<T>{
	
	private static Node head = null;

	public  LinkedList(){
		head = null;
	}
	public void add(T data) {
		Node newNode = new Node<T>(data,null,null);
		if(head == null) {
			head = newNode;
		}else{
			Node lastNode = head;
			while(lastNode.getNext() != null) {
				lastNode = lastNode.getNext(); 
			}
			newNode.setBefore(lastNode);
			lastNode.setNext(newNode);
			head.setBefore(newNode); // last Node			
		}
	}
	

	public T getNode(int id) throws Exception {
		if(head == null){
			throw new  Exception("head null");
		}
		int currentIndex  = 0;
		Node current = head;
		while(currentIndex!=id && current.getNext()!=null) {
			current =  current.getNext();
			currentIndex++;
		}
		if(currentIndex != id) {
			throw new  Exception("Id fuera rango");
		}
		return (T) current.getData();
	}
	
	
	
	/**
	 * @return retorna un string que es  la respresentacion de linked list
	 */	
	public String ToString() {
		Node current = head;
		StringBuilder builder = new StringBuilder();
		builder.append("{ ");
		while(current.getNext()!=null) {
			builder.append(current.getData().toString() + " , ");
			current =  current.getNext();
		}
		builder.append( current.getData().toString() +" }");
		return builder.toString();
	}
	
}

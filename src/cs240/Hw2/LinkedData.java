package cs240.Hw2;

import java.util.EmptyStackException;

public final class LinkedData<T> implements StackInterface<T> {
	Node firstNode;
	private int numberOfEntries;
	public LinkedData(){
		firstNode = null;
		numberOfEntries=0;
	}
	
	private class Node{
		private T data;
		private Node next;
		private Node(T dataPortion){
			this(dataPortion,null);
		}
		private Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry);
		newNode.next= firstNode;
		firstNode = newNode;
		numberOfEntries++;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyStackException();
		}
		else{
			Node temp = firstNode;
			firstNode = firstNode.next;
			numberOfEntries--;
			return temp.data;
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return firstNode.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (numberOfEntries==0 && firstNode == null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!isEmpty()){
			firstNode = firstNode.next;
			numberOfEntries--;
		}
	}

}

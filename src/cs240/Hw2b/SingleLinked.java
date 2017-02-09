package cs240.Hw2b;

public final class SingleLinked<T> implements QueueInterface<T> {
	private Node firstNode;
	private Node lastNode;
	
	public SingleLinked(){
		firstNode = null;
		lastNode = null;
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
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry, null);
		if(isEmpty()){
			firstNode = newNode;
		}
		else{
			lastNode.next= newNode;
		}
		lastNode = newNode;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T temp = null;
		if(!isEmpty()){
			temp = firstNode.data;
			firstNode = firstNode.next;
		}
		return temp;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		T temp = null;
		if(!isEmpty()){
			temp = firstNode.data;
		}
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		firstNode = null;
		lastNode = null;
	}

}

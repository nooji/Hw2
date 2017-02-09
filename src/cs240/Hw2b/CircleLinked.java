package cs240.Hw2b;

public final class CircleLinked<T> implements QueueInterface<T> {
	private Node backNode;
	private Node freeNode;
	private int numEntries;
	private final int MAX_SIZE = 10;
	
	public CircleLinked(){
		freeNode = new Node(null, null);
		freeNode.next = freeNode;
		backNode = freeNode;
		numEntries = 0;
	}
	
	
	private class Node{
		private T data;
		private Node next;
		public Node(T newEntry){
			this(newEntry, null);
		}
		public Node(T data, Node next){
			this.data= data;
			this.next = next;
		}
	}
	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		
		if(freeNode.next == backNode && numEntries <= MAX_SIZE){
			freeNode.data = newEntry;
			Node newNode = new Node(null);
			backNode =  freeNode;
			newNode.next = backNode;
			freeNode = newNode;
		}
		else if(freeNode.next.data == null){
			freeNode.next.data = newEntry;
			backNode = freeNode.next;
		}
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		Node temp = new Node(null);
		int num =0;
		temp = backNode;
		while(temp.next!=freeNode){
			temp = temp.next;
			num++;
		}
		switch(num){
			case 0:
				backNode.data = null;
				break;
			case 1:
				backNode.next.data = null;
				break;
			case 2: 
				backNode.next.next.data = null;
				break;
			case 3:
				backNode.next.next.next.data = null;
				break;
			case 4:
				backNode.next.next.next.next.data = null;
				break;
			case 5:
				backNode.next.next.next.next.next.data = null;
				break;
			case 6:
				backNode.next.next.next.next.next.next.data = null;
				break;
			case 7:
				backNode.next.next.next.next.next.next.next.data = null;
				break;
			case 8:
				backNode.next.next.next.next.next.next.next.next.data = null;
				break;
			case 9:
				backNode.next.next.next.next.next.next.next.next.next.data = null;
				break;
			case 10:
				backNode.next.next.next.next.next.next.next.next.next.next.data = null;
				break;
		}
		freeNode = temp;
		return temp.data;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		Node temp = new Node(null);
		temp = backNode;
		while(temp.next!=freeNode){
			temp = temp.next;
		}
		return temp.data;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return backNode == freeNode;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!isEmpty()){
			dequeue();
		}
	}
	

}

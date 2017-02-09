package cs240.Hw2b;

public class CircleArray<T> implements QueueInterface<T> {
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY = 50;
	public CircleArray(){
		this(DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public CircleArray(int initialCapacity){
		queue = (T[]) new Object[initialCapacity+1];
		frontIndex=0;
		backIndex= initialCapacity;
	}
	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T temp = null;
		if(!isEmpty()){
			temp = queue[frontIndex];
			queue[frontIndex]=null;
			frontIndex =(frontIndex + 1) % queue.length; 
		}
		return temp;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		T temp = null;
		if(!isEmpty()){
			temp = queue[frontIndex];
		}
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return frontIndex == ((backIndex+1) % queue.length);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!isEmpty()){
			this.dequeue();
		}
	}
}

package cs240.Hw2;
import java.util.Vector;
import java.util.EmptyStackException;

public final class Vectorz<T> implements StackInterface<T> {
	private Vector<T> bag;
	
	public Vectorz(){
		bag = new Vector<T>();
	}
	public Vector<T> getBag(){
		return bag;
	}
	@Override
	public void push(T newEntry) {
		bag.addElement(newEntry);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyStackException();
		}
		else{
			T temp = bag.lastElement();
			bag.remove(bag.indexOf(bag.lastElement()));
			//bag.remove(bag.capacity()-1);
			return temp;
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new EmptyStackException();
		else
			return bag.lastElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bag.isEmpty();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		bag.clear();
	}

}

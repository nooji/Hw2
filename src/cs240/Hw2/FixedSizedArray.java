package cs240.Hw2;

import java.util.EmptyStackException;

public final class FixedSizedArray<T> implements StackInterface<T>{
	private final T[] bag;
	private int numberOfEntries;
	
	@SuppressWarnings("unchecked")
	public FixedSizedArray(){
		numberOfEntries=0;
		bag = (T[]) new Object[10];
	}
	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		if(numberOfEntries < bag.length){
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		else{
			System.out.println("Nothing was added because something went wrong.");
		}
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyStackException();
		}
		else{
			T temp =  bag[numberOfEntries];
			bag[numberOfEntries] = null;
			numberOfEntries--;
			return temp;
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyStackException();
		}
		else{
			return bag[numberOfEntries];
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfEntries == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(!isEmpty()){
			bag[numberOfEntries]=null;
			numberOfEntries--;
		}
	}

}

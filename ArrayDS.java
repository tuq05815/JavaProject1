//package Project1p;


//public class ArratDS<T> {

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

public class ArrayDS<T> implements SequenceInterface<T>, ReorderInterface {

	private final BagInterface<Integer>[][] array; //the underlying 2-D array
	private int size; //the number of items in the sequence
	private T[] alphabet; //the possible item values (e.g., the decimal digits)
	private T firstItem; //the first item in the sequence
	private T lastItem; //the last item in the sequence

		

		
	public ArrayDS(T[] alphabet) {
		this.size=0;
		this.alphabet = alphabet;  //x2??
		//this.ResizableArrayBag = new ResizableArrayBag;
		//call array to Resizeable array bag
	//	array = ResizableArrayag<Interger>-- use alphabet in place of integer
		array = (BagInterface<Integer>[][] )new ResizableArrayBag[alphabet.length][alphabet.length];
		for (int i = 0; i < alphabet.length; i++) {
			for (int j = 0; j < alphabet.length; j++) {
				array[i][j] = new ResizableArrayBag<>();
				
			}
		}
		
	}
	
	public ArrayDS(ArrayDS<T> other) {
		//array = other.array;
		alphabet = other.alphabet;
		size = other.size();
		this.array = new ResizableArrayBag[other.alphabet.length][other.alphabet.length];
		
		
		for (int i = 0; i <other.alphabet.length; i++) {
			for(int j = 0; j <other.alphabet.length; j++) {
				this.array[i][j] = new ResizableArrayBag<>();
				this.array[i][j] = other.array[i][j];
				
				}
			}
		}
	
		//call alphabet 
		//use size method again?
		//resizable array 
		// how to duplicate the same array when 
		//find the index of item for array bag
		//BagInt: resizable bags of integers,arrays of integers
		
	//start on methods toString, append, itemAt,

	//sequence interface
	public void append(T item) {
		
	
		if (size ==0) { //checking if empty
			firstItem = item; //for 1
		
			int alphabetIndex = indexInAlphabet(item);
			//Set item and set inside 2d array
		}
		
			
	
		
		else if (size == 1) {
			int nextIndex = indexInAlphabet(firstItem);
			
		//	if (alphabetIndex??
	}
	}
	
	public int indexInAlphabet(T item) {
		for (int i = 0; i < alphabet.length; i ++) {
			if (alphabet[i].equals(item)) { //just run through and return if equates
				return 1;
		
	}
	}
		return -1;
	}
	
	/** Return the index of a given item in the alphabet of the sequence
	 * @param item an item
	 * @return the index of item in the alphabet of the sequence
	 *         or -1 if the item doesn't exist
	//size == 2
	
		*/
		
	public void prefix(T item) {
		//rewrite append, should be opposite but similar base code
		//int first = ""
		//int last = ""
		//same function, but subtract since prefix, so add (-1) from;
		if (size ==0) {
			lastItem = item;
		}
		int alphabetIndex = indexInAlphabet(item); //CHECK
		firstItem = item;
		size++;
	}
			
	public class EmptySequenceException {
		}
	
		
	
	
	public T deleteHead() {
		if (isEmpty()) {
	//		throw new EmptySequenceException();
		}
		
		T deletedHead = firstItem;
		int alphabetIndex = indexInAlphabet(firstItem);
		
		if (size ==1) {
			firstItem = null;
		}else {
			for (int i = 0; i<size-1; i++) {
				int nextIndex = indexInAlphabet(alphabet [i +1]);
				array[nextIndex][indexInAlphabet(alphabet[i])].add(array[nextIndex][indexInAlphabet(lastItem)].remove());
			}
			firstItem = alphabet[indexInAlphabet(alphabet[1])];
		}
		
		size--;
		return deletedHead;
	}
/*		}else {
		
			//	int alphabetIndex = indexInAlphabet(firstItem);
//			lastItem = item;
			for (int i = 0; i< size-1; i++) {
		//		array[indexInAlphabet(alphabet[i])]
			}
		size--;
		if (size == 0 ) {
			firstItem = null;
			lastItem = null;
		}else {
//			firstItem = alphabet[remove.Item]; //FIX
		}
		return firstItem;
	}}*/
		
			//need throw EmptySequenceException();
			
		
		//index for first item, used baginterface to equate array
		
	
	
	public T deleteTail() { 
		if (isEmpty()) {
	//		throw new EmptySequenceException("");
		}
		T deletedTail = lastItem;
		int alphabetIndex = indexInAlphabet(lastItem);
		
		if (size ==1) {
			lastItem = null;
		}else {
			for (int i = size-1; i>0; i--) {
				int prevIndex = indexInAlphabet(lastItem);
				array[prevIndex][indexInAlphabet(lastItem)].add(array[prevIndex][indexInAlphabet(lastItem)].remove());
			}
			lastItem = alphabet[indexInAlphabet(alphabet[1])];
		}
		
		size--;
		return deletedTail;
	}
		
		
		/*int alphabet = indexInAlphabet(lastItem);
		size --;
		
		if (size ==0) {
			firstItem = null;
			lastItem = null;
		}else {
//			lastItem = alphabet[removeItem]; //FIX
		}
		return lastItem;
		
	*/
	
	
	
	public boolean isEmpty() {
		return size == 0;
		
	}	
	
	public int size() {
		return size;
	}
	
	
	public T first() { 
		if (isEmpty()) {
			return null;
		}
		return itemAt(0);
	}
	
	
	public T last() {
		if (isEmpty()) {
			return null;
		}
		return itemAt(size-1);
	}
	
	public void reverse() {
		for (int i = 0; i <size; i++) {
			for (int j = 0; j < alphabet.length; j++) {
				BagInterface<Integer> temp = array [j][i];
				array[j][i]= array[j][size - 1 - i];
				array[j][size - 1 - i] = temp;
			}
		}
	}
	
	public boolean hasSubsequence(SequenceInterface<T> another) { //WORK OVER
		if (another.size() ==0) {
			return true;
		}
	
		if (this.size < another.size()) {
			return false;
		}
		
		T[] thisArray= this.toArray();
		T[] anotherArray = another.toArray();
		
		for (int i = 0; i <= this.size- another.size(); i ++) {
	//		if (array.equals(array.copyOfRange(thisArray, i, i+ another.size()), anotherArray)) {
				return true;
			}

		return false;
	}
	
	public boolean predecessor(T first, T second) {
		int firstItem = indexInAlphabet(first);
		int secondItem = indexInAlphabet(second);
		
		for (int i = 0; i <alphabet.length; i++) {
			if(array[firstItem][i].contains(second)) {
				return true;
			}
		}
		return false;
		
	}
	
	
	public int getFrequencyOf(T item) {
		int size = 0;
		for(int i = 0; i<alphabet.length; i++) {
			for(int j = 0; j<alphabet.length; j++) {
				size += array[i][j].getFrequencyOf(item);
			}
		}
		return size;
	}
	
	public void clear() {
		while (!isEmpty()) 
			clear();
	}
	
	public T itemAt(int position) {
		if (position < 0) {
//			throw new IndexOutOfBoundsException();
			
		}
		
		if(position > size) {
	//		throw new IndexOutOfBoundsException();
			
		}
		int alphabetIndex = -1;
		int size = -1;
		
		for (int i = 0; i <alphabet.length; i++) {
			for (int j = 0; j<alphabet.length; j++) {
				size++;
				if (size == position) {
					alphabetIndex = i;
					break;
				}
			}
			if (alphabetIndex != -1) {
				break;
			}
		}
		return alphabet[alphabetIndex];
	}
		
	
	
	public T[] toArray() {
		if(isEmpty()) {
			return null;
		}
		T[] result = (T[]) new Object[size];
		
		for (int i = 0; i<size; i++) {
			result[i] = itemAt(i);
		}
		
		return result;
	}
	
	
	public int firstOccurrenceOf(T item) {
		for (int i = 0; i<alphabet.length; i++) {
			//for (int j = 0; j <alphabet.length; j++) {
			if (itemAt(i).equals(item)) {
	//			if (array[i][j].contains(item)) {
					return i;
				}
			}
		
		return -1;
	}
	
	
	

	
	public int nextIndex(T item, int position) { //WORK OVER alphabetIndex
		int alphabetIndex = indexInAlphabet(item);
		for (int i = position + 1; i < alphabet.length; i ++) {
			if(!array[alphabetIndex][i].isEmpty()) {
				return i;
			}
		}
		return -1;
		
	}
	
	public int prevIndex(T item, int position) { //work >=
		int alphabetIndex = indexInAlphabet(item);
		for (int i = position -1; i > 0; i--) {
			if(!array[alphabetIndex][i].isEmpty()) {
				return i;
			}
		}
		return -1;
	}
	
	
	public void rotateRight() {
		if (size > 0) {
			T lastItem = this.deleteTail();
			this.prefix(lastItem);
		}
		
	}
	
	
	public void rotateLeft() {
		if (size > 0) {
			T firstItem = this.deleteHead();
			this.append(firstItem);
		}
		
	
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
	for (int i = 0; i < size; i++) {
	//	int index = indexInAlphabet(array[i][i].toArray()[0]);
//		result.append(alphabet[index]);
	}
	return result.toString();
	}
	
		
	}

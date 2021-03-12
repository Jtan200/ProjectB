
public class ArrayFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {
	private T[] list;
	private int numberOfElements;
	
	//Constructor
	public ArrayFrontBackCappedList(int capacity) {
        list = (T[]) new Object[capacity];
        numberOfElements = 0;
    }
	
	//add methods
    public boolean addFront(T element){
        if(isFull()) {
        	return false;
        }        
        //shifts starting from the last index by using the numberOfElements in the list as reference to the end position
        for(int i=numberOfElements-1; i>=0; i--) {
        	list[i+1] = list[i];
        }
        numberOfElements++;
        list[0]=element;
        return true;
    }
    
    public boolean addBack(T element){
        if(isFull()) {
        	return false;
        }
        //numberOfElements++ updates the position to the end of the array properly
        list[numberOfElements++]=element;
        return true;
    }
	
	//remove methods
    public T removeFront() {
      if(isEmpty()) {
    	  return null;
      }
      
      //initialize reference to the first element 
      T removeFront = list[0];
      //shifts everything down
      for(int i=0; i<numberOfElements-1; i++) {
    	  list[i]=list[i+1];
      }
      numberOfElements--;
      return removeFront;
    }
    
    public T removeBack() {
      if(isEmpty()) {
    	  return null;
      }
      
      T removeBack = list[numberOfElements-1];
      list[numberOfElements-1] = null;
      numberOfElements--;
      return removeBack;
    }

    public void clear(){
        int maxSize = list.length;
        list=(T[]) new Object[maxSize]; //can't use numberOfElements 
        numberOfElements=0;
    }
	
	//getters
    public T getEntry(int position){
    	if(isEmpty() || position>list.length || position<0) {
    		return null;
    	} 
    	return list[position];
    	
    }
	
	public int indexOf(T anEntry) {
		int index = 0;
		
		if(contains(anEntry)==false) {
			return -1;
		}
		
		//if the index at list holds a logical equivalent to anEntry then return that index position
		for(int i=0; i<numberOfElements; i++) {
			if(list[i].equals(anEntry)) {
				return index;
			}
			index++;
		}		
		return index;
	}

	public int lastIndexOf(T anEntry) {
		int index = numberOfElements-1;
		
		if(contains(anEntry)==false) {
			return -1;
		}
		
		//iterate backwards because it's very likely to be near the end
		for(int i=numberOfElements-1; i>=0; i--) {
			if(list[i].equals(anEntry)) {
				return index;
			}
			index--;
		}
		return index;
	}
	
	public boolean contains(T anEntry) {		
		//checks the array until it runs into the first instance of anEntry
		for(int i=0; i<numberOfElements; i++) {
			if(list[i].equals(anEntry)) {
				return true;
			}
		}
		return false;
	}
	
	//size methods
    public int size() {
        return numberOfElements;
    }
	
    public boolean isFull() {
        if(numberOfElements>=list.length) {
        	return true;
        }
        return false;
    }
    
    public boolean isEmpty() {
        if(numberOfElements==0) {
        	return true;
        }
        return false;
    }
	
    public String toString() {
        String s = "size=" + numberOfElements + "; capacity=" + list.length + "; \t[";
        
        if(numberOfElements > 0){
            for(int i = 0; i < numberOfElements - 1; i++){
            	s += list[i] + ", ";
            }
            s += list[numberOfElements - 1] + "]";
        }else {
            s += "]";
        }
        return s;
    }
}

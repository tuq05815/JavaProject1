package Project1p;

public class ReallyLongInt extends ArrayDS<Integer> 
implements Comparable<ReallyLongInt> {
	// Instance variables are inherited.  You may not add any new instance variables
		private static final Integer[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		private ReallyLongInt(int size) {

			super(DIGITS);
			for (int i = 0; i < size; i++) {
				append(0);
			}
		}

		/**
		 * @param s a string representing the integer (e.g., "123456") with no leading
		 * zeros except for the special case "0".
		 * Note that we are adding the digits here to the END. This results in the
		 * MOST significant digit first. It is assumed that String s is a valid representation of an
		 * unsigned integer with no leading zeros.
		 * @throws NumberFormatException if s contains a non-digit
		 */
		public ReallyLongInt(String s)
		{
			super(DIGITS);
			char c;
			Integer digit;
			// Iterate through the String, getting each character and converting it into
			// an int.  Then add at the end.  Note that
			// the append() method (from ArrayDS) adds at the end.
			for (int i = 0; i < s.length(); i++)
			{
				c = s.charAt(i);
				if (('0' <= c) && (c <= '9'))
				{
					digit = c - '0';
					append(digit);
				}
				else
					throw new NumberFormatException("Illegal digit " + c);
			}
		}
		
		
		public ReallyLongInt(ReallyLongInt other) {
			super(other);
		}



		/** Simple call to super to copy the items from the argument ReallyLongInt into a new one.
		 * @param rightOp the object to copy
		 */
		
		
		

	public ReallyLongInt add(ReallyLongInt rightOp) {
		int maxSize = Math.max(this.size(), rightOp.size());
		ReallyLongInt result = new ReallyLongInt(maxSize + 1);
		
		int carry = 0;
		for (int i = 0; i<maxSize; i++) {
			int dig1;
			if (i< size()) {
				dig1 = itemAt(i); 
			}else{
				dig1 = 0;
			}	
			int dig2;
			if (i < rightOp.size()) {
				dig2 =  rightOp.itemAt(i);
			}else{
				dig2= 0;
			}
			int sum = dig1 + dig2 + carry;
			
			result.append(sum%10);
			carry = sum /10;
		}
		result.removeZeros();
		return result;
	}
			
		
	
	public ReallyLongInt subtract(ReallyLongInt rightOp) {
		if (compareTo(rightOp) < 0) {
			throw new ArithmeticException();
			
		}
		int maxSize = Math.max(size(),rightOp.size());
		int borrow = 0;
		ReallyLongInt result = new ReallyLongInt(maxSize);
		
		for (int i = 0; i < maxSize; i ++) {
			int dig1;
			if (i< size()) {
				dig1 = itemAt(i); 
			}else{
				dig1 = 0;
			}
			int dig2;
			if (i < rightOp.size()) {
				dig2 =  rightOp.itemAt(i);
			}else{
				dig2= 0;
			}
			
			int diff;
			if (dig1 - borrow < dig2) {
				diff = 10 + dig1 - borrow - dig2;
				borrow = 1;
			}else {
				diff = dig1 - borrow - dig2;
				borrow = 0;
			}
			
			result.append(diff);
			}
		result.removeZeros();
		return result;
	}
		
	
	public int compareTo(ReallyLongInt rOp) {
		int dig1Size = size();
		int dig2Size = rightOp.size();
		
		if (dig1Size < dig2Size) {
			return -1;
		}else if (dig1Size > dig2Size) {
			return 1;
		}else {
			for (int i = 0; i < dig1Size; i++) {
				int dig1 = itemAt(i);
				int dig2 =  rightOp.itemAt(i);
				
				if (dig1 < dig2) {
					return -1;
				}else if (dig1 > dig2) {
					return 1;
				}
				}
			
		return 0;
		}
	}
		//need add/subtract methods finished, proceed with outline
		//return -1 if less than, 0 if equal, and 1 if more than
	
	
	public boolean equals(Object rightOp) {
		if (this == rightOp) {
			return true;
		}
		if (!(rightOp instanceof ReallyLongInt)){
		return false;
	}
		ReallyLongInt other = (ReallyLongInt) rightOp;
		return compareTo(other) ==0;
	}
/*		if(rightOP ) //use if statement, need compareTo
	}
	*/
	public ReallyLongInt multTenToThe(int num) {
		if (num < 0) {
			return new ReallyLongInt(this);
		}
		
		ReallyLongInt result = new ReallyLongInt(this);
		
		for (int i = 0; i < num; i++) {
			result.append(0);;
		}
		return result;
		}
	
	/*	ReallyLongInt result = new this.rli
		for (int i = 0; i< num; i ++) {
			result.append(0);
		}
		return result;
	}*/
	
	public ReallyLongInt divTenToThe(int num) {
		ReallyLongInt result = new ReallyLongInt(this);
		
		for(int i = 0; i < num; i ++) {
			result.deleteTail();
		}
		return result;
	}
	
	/*	if (num >= size()) {
			return new rli();
		}
		
		ReallyLongInt result = new this.ReallyLongInt;
		for (int i = 0; i < num; i ++) {
			//how to get rid of first to divide, implement shifting
		}
		return result;
			
	}
	*/
	
	private void removeZeros() {
	}
	}
	

package com.test;

public class BitwiseOperatorExample {

	public static void main(String[] args) {
		
		int maxCounter         = 0x1FFFF;
		System.out.println("Display counter : "+maxCounter);
		System.out.println("Display counter bits " +Integer.toString(maxCounter, 2));
		
		int number = 8; // 0000 1000
		System.out.println("Original number : " + number);

		// left shifting bytes with 1 position
		number = number << 1; // should be 16 i.e. 0001 0000

		// equivalent of multiplication of 2
		System.out.println("value of number after left shift: " + number);

		number = -8;
		// right shifting bytes with sign 1 position
		number = number >> 1; // should be 16 i.e. 0001 0000

		// equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);

		number = -8;
		// right shifting bytes without sign 1 position
		number = number >>> 1; // should be 16 i.e. 0001 0000

		// equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);

		// Bit wise sum
		System.out.println("Bitwise sum : " + add(8, 10));

		long maxServerId = 0xFFFF;
		System.out.println("ID : " + maxServerId);

		// base 10 to base 2
		System.out.println(Integer.toString((int) maxServerId, 2));

		int numBitsServer = numOfBits(maxServerId);
		System.out.println("ID Bits : " + Integer.toString(numBitsServer, 16));

		// swap
		int val = swap(20);
		System.out.println("Swap : " + val);
	}

	public static int numOfBits(long num) {
		if (num < 0)
			throw new RuntimeException("Cant be negative");

		int count = 0;
		long temp = num;
		while (temp != 0) {
			temp = temp >> 1;
			count++;
			if (temp == 0)
				break;
		}
		return count;
	}

	// -- Swapping --
	public final static short swap(short x) {
		return (short) ((x << 8) | ((x >> 8) & 0xff));
	}

	public final static int swap(int x) {
		return (int) ((swap((short) x) << 16) | (swap((short) (x >> 16)) & 0xffff));
	}

	public final static long swap(long x) {
		return (long) (((long) swap((int) (x)) << 32) | ((long) swap((int) (x >> 32)) & 0xffffffffL));
	}
	
	public static int add(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return add( x ^ y, (x & y) << 1);
	}
}

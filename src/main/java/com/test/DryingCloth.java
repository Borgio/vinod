package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://gist.github.com/aturgarg/1180247
 * 
 * Question: Count the Clothes Visible
Pinky Bhabhi recently hired a maid to look after her household work so that she can concentrate on setting up her new business. As part of the routine work, the maid cleans the house and washes the clothes every day.
However, there is a problem with the drying of clothes on the rope. Since the rope is small and all the clothes are not able to be spread out properly, the maid places one cloth on top of other cloth. So some of the clothes are covered - partially or completely - by the other ones. Knowing the order and the position in which the clothes were hung, determine how many clothes are visible (partially or completely) when seen from front.
Consider the rope was of length N meters divided into N equal sections starting from 0 to N. Each cloth of width P occupies one or more than one section completely. (1<=P<=N & P is a +ve integer).
(Note: Ignore the other dimension of cloth for the purpose of this problem)
Input Specifications
Your program must read three arguments RopeLength, CountofClothes, ClothesPosition[] where
RopeLength is the length of the rope in meters (1<=RopeLength<=10000)
CountofClothes is the number of clothes which are placed on the rope (1<=CountofClothes<=10000)
ClothesPosition is an array giving the position in which the clothes were hung. The cloth position is described by two integers L and W, where L represents the start position of where the cloth was hung (0<=L<=10000) and W is the width of the cloth (1<=W<=10000)
The order in which the input is received is the order in which the clothes are placed on the rope.
Output Specifications
Your function GetVisibleCount should set the output variable 'output1' to the count of clothes visible completely or partially.
Example
Sample input:
10:5:{{0,4},{6,3},{1,5},{6,4},{7,2}}
Here 10 is the length of the rope in meters. 5 is the number of clothes hung on rope. The first cloth starts from 0 and covers 4 sections from 0. The second cloth starts at 6 and covers 3 sections from 6 and so on..
Sample output:
4
The total number of clothes visible when seen from front is 4.

 * 
 *
 */
public class DryingCloth {

	public static void main(String[] args) {
		System.out.println(getVisibleCount(10, 5, new int[][]{ {0,4}, {6,3}, {1,5}, {6,4}, {7,2} }));

	}

	public static int getVisibleCount(int input1, int input2, int[][] input3) {

		int output = input2;
		int noOfClothes = input2;
		Map<Integer, Integer> map, outerMap = null;
		for (int i = 0; i < noOfClothes; i++) {
			int startValue = input3[i][0];
			int length = input3[i][1];
			int endValue = startValue + length;
			map = new HashMap<Integer, Integer>();
			outerMap = new HashMap<Integer, Integer>();
			for (int k = startValue; k < endValue; k++) {
				map.put(k, k + 1);
			}

			// check if any cloth is hidden by later clothes
			for (int j = i + 1; j < noOfClothes; j++) {
				int startValueTemp = input3[j][0];
				int lengthTemp = input3[j][1];
				int endValueTemp = startValueTemp + lengthTemp;
				for (int m = startValueTemp; m < endValueTemp; m++) {
					if (!outerMap.containsKey(m)) {
						outerMap.put(m, m + 1);
					}
				}
			}

			for (Integer key : outerMap.keySet()) {
				map.remove(key);
			}

			// check if map has anything left
			if (map.size() == 0) {
				output--;
			}
		}
		return output;
	}

}

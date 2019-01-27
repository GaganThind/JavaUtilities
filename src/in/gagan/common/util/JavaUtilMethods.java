/*
 * This file is a part of JavaUtilities.
 * 
 * JavaUtilities is a free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  
 * JavaUtilities is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with JavaUtilities.  If not, see <https://www.gnu.org/licenses/>. 
 */
package in.gagan.common.util;

import java.util.Map;
import java.lang.reflect.Array;
import java.util.Collection;

/**
 * 
 * 
 */
public class JavaUtilMethods {

	/**
	 * This method is used to check if input array is null or not
	 * 
	 * @param inputArr
	 * @return true, if input array is either null or length is 0
	 */
	public static <T> boolean isEmpty(T[] inputArr) {
		return (null == inputArr || inputArr.length == 0);
	}

	/**
	 * This method is used to check if input collection is null/Empty or not
	 * 
	 * @param inColl
	 * @return true, if input collection is null/empty
	 */
	public static <T extends Collection<?>> boolean isEmpty(T inColl) {
		return (null == inColl || inColl.isEmpty());
	}

	/**
	 * This method is used to check if input map is null/Empty or not
	 * 
	 * @param inMap
	 * @return true, if input map is null/empty
	 */
	public static <T extends Map<?, ?>> boolean isEmpty(T inMap) {
		return (null == inMap || inMap.isEmpty());
	}

	/**
	 * Traverses over all elements of array and checks if all elements are not null
	 * 
	 * @param inputArray
	 * @return
	 */
	public static <T> boolean isNull(T[] inputArray) {
		for (T input : inputArray) {
			if (null != input) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks whether the given array is empty or if it's elements are all null
	 * 
	 * @param inputArray
	 * @return
	 */
	public static <T> boolean isEmptyOrNull(T[] inputArray) {
		return (isEmpty(inputArray) || isNull(inputArray));
	}

	/**
	 * Checks whether the given array is neither empty nor has all null elements.
	 * This is better for null protection.
	 * 
	 * @param inputArray
	 * @return
	 */
	public static <T> boolean isNotEmptyAndNotNull(T[] inputArray) {
		return (!isEmpty(inputArray) && !isNull(inputArray));
	}

	/**
	 * This method is used to check if any input parameter supplied is null
	 * 
	 * @param inputObjects
	 * @return true, if any input parameter is null
	 */
	public static boolean anyInputNull(Object... inputObjects) {
		for (Object obj : inputObjects) {
			if (null == obj) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used to check if all input parameters supplied are not null
	 * 
	 * @param inputObjects
	 * @return true, if all input parameters are not null
	 */
	public static boolean allInputsNotNull(Object... inputObjects) {
		return !anyInputNull(inputObjects);
	}

	/**
	 * Merge all specified arrays
	 * 
	 * @param inputArrays
	 * @return
	 */
	@SafeVarargs
	public static <T> T[] mergeArrays(T[]... inputArrays) {
		int size = inputArrays.length;
		if (1 == size) {
			return inputArrays[0];
		}

		T[] firstArry = inputArrays[0];
		for (int num = 1; num < size; num++) {
			firstArry = mergeArrays(firstArry, inputArrays[num]);
		}

		return firstArry;
	}

	/**
	 * Merge both arrays
	 * 
	 * @param firstArray
	 * @param secondArray
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <T> T[] mergeArrays(T[] firstArray, T[] secondArray) {

		// Check if both input arrays are null, then simply return null;
		if (isEmpty(firstArray) && isEmpty(secondArray)) {
			return null;
		} else if(isEmpty(firstArray)) {
			return secondArray;
		} else if(isEmpty(secondArray)) {
			return firstArray;
		}

		// Check If both provided arrays are of same type
		if (!firstArray.getClass().equals(secondArray.getClass())) {
			throw new IllegalArgumentException("All Arrays should be of the same type");
		}

		// Check if both the arrays are empty or null and have all elements as null,
		// then simply return first object
		if (isEmptyOrNull(firstArray) && isEmptyOrNull(secondArray)) {
			return firstArray;
		}

		// Check if both arrays are not null and empty, then add otherwise return the
		// non-null array
		if (isNotEmptyAndNotNull(firstArray) && isNotEmptyAndNotNull(secondArray)) {
			int sizeOfFirstArr = firstArray.length;
			int sizeOfSecondArr = secondArray.length;
			int totalSize = sizeOfFirstArr + sizeOfSecondArr;

			T[] newArr = (T[]) Array.newInstance(firstArray[0].getClass(), totalSize);
			System.arraycopy(firstArray, 0, newArr, 0, sizeOfFirstArr);
			System.arraycopy(secondArray, 0, newArr, sizeOfFirstArr, sizeOfSecondArr);
			return newArr;
		} else if (isNotEmptyAndNotNull(secondArray)) {
			return secondArray;
		}

		return firstArray;
	}

}
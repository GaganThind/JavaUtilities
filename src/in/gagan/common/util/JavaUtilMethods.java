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
import java.util.Collection;

/**
 * 
 * 
 */
public class JavaUtilMethods{

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
     * This method is used to check if any input parameter supplied is null
     * 
     * @param inputObjects
     * @return true, if any input parameter is null
     */
    public static boolean anyInputNull(Object... inputObjects) {
        for(Object obj: inputObjects) {
            if(null == obj) return true;
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

}
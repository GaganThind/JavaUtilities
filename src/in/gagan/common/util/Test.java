package in.gagan.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, String> tmpMap = null;
		System.out.println(JavaUtilMethods.isEmpty(tmpMap));
		
		tmpMap = new HashMap<>();
		tmpMap.put("tr", "sfsdf");
		System.out.println(JavaUtilMethods.isEmpty(tmpMap));
		
		List<String> tmpStr = null;
		System.out.println(JavaUtilMethods.isEmpty(tmpStr));
		
		tmpStr = new ArrayList<>(Arrays.asList("qweq","wrwer"));
		System.out.println(JavaUtilMethods.isEmpty(tmpStr));
	}
}

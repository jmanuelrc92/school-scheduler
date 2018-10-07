package com.jmanuelrc.utils;

import java.util.ArrayList;

public class ArrayUtils {
	public static String mImplode(ArrayList<String> pieces, String glue) {
		String implode = "";
		for (int i = 0; i < pieces.size(); i++) {
			implode+=pieces.get(i) + glue;
		}
		return implode.substring(0, implode.length() - 1);
	}
}

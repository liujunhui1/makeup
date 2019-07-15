package cn.zhonggong.makeup.util;

public class StringsUtil {
	public static int[] StringToInts(String str, String cut) {
		int[] ints = null;
		String[] strs = str.split(cut);
		if (strs.length != 0) {
			ints = new int[strs.length];
			for (int i = 0; i < ints.length; i++) {
				ints[i] = Integer.valueOf(strs[i]);
			}
		}
		return ints;
	}
}

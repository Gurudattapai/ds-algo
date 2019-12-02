package learn;

public class StringCompression443 {

	public static int compress(char[] chars) {
		if (chars.length == 1) {
			return 1;
		}
		StringBuilder str = new StringBuilder();
		int count = 0;
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i+1]) {
				count++;
			} else {
				count++;
				if (count > 1)
				str.append(chars[i]+""+count);
				else
				str.append(chars[i]);
				count = 0;
			}
		}
		count++;
		if (count > 1)
			str.append(chars[chars.length-1]+""+count);
			else
			str.append(chars[chars.length-1]);
		String string =str.toString();
		for (int i = 0; i < string.length(); i++) {
			chars[i] = string.charAt(i);
		}
		return string.length();
	}

	public static void main(String[] args) {
		System.out.println(compress(new char [] {'a', 'a', 'b','b','c','c','c'}));
	}

}

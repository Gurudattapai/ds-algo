package learn;

public class CompareVersionNumbers165 {

	public static int compareVersion(String version1, String version2) {
		
		StringBuilder str1 = new StringBuilder(version1);
		StringBuilder str2 = new StringBuilder(version2);
		
		while (true) {
			
			if (str1.toString().length() == 0 && str2.toString().length() > 0) {
				str1.delete(0, str1.toString().length());
				str1.append("0");
			} else if (str2.toString().length() == 0 && str1.toString().length() > 0) {
				str2.delete(0, str2.toString().length());
				str2.append("0");
			} else if (str2.toString().length() == 0 && str1.toString().length() == 0){
				return 0;
			}
			
			int str1Index = str1.indexOf(".");
			int str2Index = str2.indexOf(".");
			
			Integer i1 = str1Index == -1 ? Integer.parseInt(str1.toString())
					: Integer.parseInt(str1.substring(0, str1Index));
			Integer i2 = str2Index == -1 ? Integer.parseInt(str2.toString())
					: Integer.parseInt(str2.substring(0, str2Index));
			
			int compare = i1.compareTo(i2);
			
			if (compare == 0) {
				str1.delete(0, str1Index != -1 ? str1Index+1 : str1.toString().length());
				str2.delete(0, str2Index != -1 ? str2Index+1 : str2.toString().length());
			} else {
				return compare;
			}	
		}
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("7.5.2.4", "7.5.3"));

	}

}

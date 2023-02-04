package Other;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class ConvertToASCII {
	public static String convertToASCII(String value) {
	      try {
	            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
	            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	            return pattern.matcher(temp).replaceAll("");
	     } catch (Exception ex) {
	            ex.printStackTrace();
	      }
	      return null;
	}
}

package th.java.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File path = new File("/Developer/workspace/Interview/Interview");
		String[] list;
		list = path.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list) {
			System.out.println(dirItem);
		}
	}

}

class DirFilter implements FilenameFilter {

	private Pattern pattern;
	
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}
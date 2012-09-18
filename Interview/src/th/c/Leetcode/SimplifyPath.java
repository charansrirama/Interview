package th.c.Leetcode;

/*
 * Given an absolute path for a file (Unix-style), simplify it.

 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class SimplifyPath {
	// AC
	public static String simplifyPath(String path) {
		while (path.length() > 0 && path.charAt(path.length() - 1) == '/')
			path = path.substring(0, path.length() - 1);
		String result = "";
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (c == '.') {
				if (i + 1 < path.length() && path.charAt(i + 1) == '.') {
					int j = result.length() - 2;
					while (j >= 0 && result.charAt(j) != '/') {
						j--;
					}
					if (j < 0)
						j = 0;
					result = result.substring(0, j);
					i++;
				} else {
					result = result.substring(0, result.length() - 1);
				}
			} else if (c == '/' && result.length() > 0
					&& result.charAt(result.length() - 1) == '/') {

			} else {
				result += c;
			}
		}
		if (result.length() == 0)
			result = "/" + result;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}

}

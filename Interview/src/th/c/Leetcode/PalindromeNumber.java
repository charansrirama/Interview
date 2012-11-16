package th.c.Leetcode;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int base = 1;
        while(x/base >= 10) {
            base *= 10;
        }
        while(x != 0) {
            int l = x/base;
            int r = x%10;
            if(l != r) return false;
            x = x%base;
            x /= 10;
            base /= 100;
        }
        return true;
    }
}

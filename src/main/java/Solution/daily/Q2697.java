package Solution.daily;

/**
 * @Author: Byin
 * @Description: 2697. 字典序最小回文串 easy
 * @DateTime: 2023/12/13 9:04
 **/

public class Q2697 {
    public static void main(String[] args) {
        String s = "abcd";
        String ans = makeSmallestPalindrome(s);
        System.out.println(ans);
    }

    public static String makeSmallestPalindrome(String s) {
        int n = s.length();
        int mid = (n - 1) / 2;
        char[] arr = s.toCharArray();
        char[] ans;
        if (n % 2 == 0) {
            ans = palindrome(mid, mid + 1, n, arr);
        } else {
            ans = palindrome(mid, mid, n, arr);
        }
        return new String(ans);
    }

    public static char[] palindrome(int i, int j, int n, char[] arr) {
        while (i >= 0 && j < n) {
            if (arr[i] < arr[j]) {
                arr[j] = arr[i];
            }
            if (arr[i] > arr[j]) {
                arr[i] = arr[j];
            }
            i--;
            j++;
        }
        return arr;
    }
}

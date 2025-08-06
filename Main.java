import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
    }

    private static int fatorial (int n) {
        if (n <= 1) return 1;
        return n * fatorial (n-1);
    }

    private static int somatorio (int n) {
        if (n == 0) return 0;
        return n + somatorio (n - 1);
    }

    private static int fibonacci (int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    private static int somatorioEntre (int n, int m) {
        if (n == m) return m;
        if (n > m) return 0;
        int t = n + m;
        // System.out.println(t);
        return t + somatorioEntre(n+1, m-1);
    }

    private static boolean isPal (String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != (s.charAt(s.length()-1))) return false;
        return isPal(s.substring(1, s.length()-1));
    }

    private static String toBinary (int n) {
        return "";
        // nah
    }

    private static int alSum (ArrayList<Integer> al) {
        int current = al.remove(0);
        return current + alSum(al);
    }

    private static int findBiggest (ArrayList<Integer> al) {
        if (al.isEmpty()) return -1;
        if (al.size() == 1) return al.get(0);
        int first = al.get(0);
        int second = al.get(1);
        if (first > second) al.remove(1);
        else al.remove(0);
        return findBiggest(al);
    }

    private static boolean findSubstring (String s, String match) {
        if (s.length() < match.length()) return false;
        if (s.startsWith(match)) return true;
        return findSubstring(s.substring(1), match);
    }

    private static int nroDigit (int n) {
        int remaining = n / 10;
        return -1;
    }

    private static ArrayList<String> permutations (String s) {
        return null;
    }
}
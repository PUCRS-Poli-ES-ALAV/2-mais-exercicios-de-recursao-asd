import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Forneca uma string: ");
        String s = sc.nextLine();
        System.out.println(permutations(s));
        sc.close();
    }

    @SuppressWarnings("unused")
    private static int fatorial (int n) {
        if (n <= 1) return 1;
        return n * fatorial (n-1);
    }

    @SuppressWarnings("unused")
    private static int somatorio (int n) {
        if (n == 0) return 0;
        return n + somatorio (n - 1);
    }

    @SuppressWarnings("unused")
    private static int fibonacci (int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    @SuppressWarnings("unused")
    private static int somatorioEntre (int n, int m) {
        if (n == m) return m;
        if (n > m) return 0;
        int t = n + m;
        // System.out.println(t);
        return t + somatorioEntre(n+1, m-1);
    }

    @SuppressWarnings("unused")
    private static boolean isPal (String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != (s.charAt(s.length()-1))) return false;
        return isPal(s.substring(1, s.length()-1));
    }

    @SuppressWarnings("unused")
    private static String toBinary (int n) {
        if (n < 2) return String.valueOf(n);
        return toBinary(n/2) + (n%2);
    }

    @SuppressWarnings("unused")
    private static int alSum (ArrayList<Integer> al) {
        int current = al.remove(0);
        return current + alSum(al);
    }

    @SuppressWarnings("unused")
    private static int findBiggest (ArrayList<Integer> al) {
        if (al.isEmpty()) return -1;
        if (al.size() == 1) return al.get(0);
        int first = al.get(0);
        int second = al.get(1);
        if (first > second) al.remove(1);
        else al.remove(0);
        return findBiggest(al);
    }

    @SuppressWarnings("unused")
    private static boolean findSubstring (String s, String match) {
        if (s.length() < match.length()) return false;
        if (s.startsWith(match)) return true;
        return findSubstring(s.substring(1), match);
    }

    @SuppressWarnings("unused")
    private static int nroDigit (int n) {
        if (n < 10) return 1;
        int remaining = n / 10;
        return 1 + nroDigit (remaining);
    }

    @SuppressWarnings("unused")
    private static ArrayList<String> permutations (String s) {
        ArrayList<String> perms = new ArrayList<>();

        if (s.length() == 1) {
            perms.add(s);
            return perms;
        }

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            String rest = s.substring(0,i) + s.substring(i+1);

            ArrayList<String> currentPerms = permutations(rest);

            for (String p : currentPerms) perms.add(current + p);
        }

        return perms;
    }
}
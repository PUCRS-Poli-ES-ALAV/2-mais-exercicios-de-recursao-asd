import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean loop = true;
    private static Scanner sc = new Scanner (System.in);
    public static void main (String args[]) {
        while (loop) {
            printMenu();
            int option = sc.nextInt();
            handleCall(option);
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("""
                Selecione uma operação:
                1. Fatorial
                2. Somatório
                3. Fibonacci
                4. Somatório em intervalo
                5. Palíndromo
                6. Binário
                7. Somatório de arraylist
                8. Maior elemento
                9. Substring
                10. Número de dígitos
                11. Permutações

                0. sair""");
    }

    private static void handleCall(int option) {
        switch (option) {
            case 0: {
                // sair
                loop = false;
                break;
            }

            case 1: {
                // fatorial
                System.out.print("Fatorial - forneça um número: ");
                int n = sc.nextInt();
                System.out.println(fatorial(n));
                break;
            }

            case 2: {
                // somatorio
                System.out.print("Somatório - forneça um número: ");
                int n = sc.nextInt();
                System.out.println(somatorio(n));
                break;
            }

            case 3: {
                // fibonacci
                System.out.print("Fibonacci - forneça um número: ");
                int n = sc.nextInt();
                System.out.println(fibonacci(n));
                break;
            }

            case 4: {
                // somatorioEntre
                System.out.print("Somatório de intervalo - forneça o primeiro núumero: ");
                int a = sc.nextInt();
                System.out.print("Somatório de intervalo - forneça o segundo número: ");
                int b = sc.nextInt();
                if (a > b) {
                    int temp = b;
                    b = a;
                    a = temp;
                }
                System.out.println(somatorioEntre(a, b));
                break;
            }

            case 5: {
                // isPal
                System.out.print("Palíndromo - forneça uma string: ");
                String s;
                do {
                    s = "";
                    s = sc.nextLine();
                } while (s.equals(""));
                System.out.println(isPal(s));
                break;
            }

            case 6: {
                // toBinary
                System.out.print("Binário - forneça um número: ");
                int n = sc.nextInt();
                System.out.println(toBinary(n));
                break;
            }

            case 7: {
                // sumAl
                String in;
                ArrayList<Integer> al = new ArrayList<>();
                do {
                    in = "";
                    System.out.print("Somatório de arraylist - forneça um número (ou \"ok\" para fechar o arraylist): ");
                    do {
                        in = sc.nextLine();
                    } while (in.equals(""));
                    if (isNumeric(in)) al.add(Integer.parseInt(in));
                } while (!in.equals("ok"));
                System.out.println(alSum(al));
                break;
            }

            case 8: {
                // findBiggest
                String in = "";
                ArrayList<Integer> al = new ArrayList<>();
                do {
                    System.out.print("Maior elemento - forneça um número (ou \"ok\" para fechar o arraylist): ");
                    do {
                        in = sc.nextLine();
                    } while (in.equals(""));
                    if (isNumeric(in)) al.add(Integer.parseInt(in));
                } while (!in.equals("ok"));
                System.out.println(findBiggest(al));
                break;
            }

            case 9: {
                // findSubstring
                System.out.print("Substring - forneça a string pai: ");
                String a;
                do {
                    a = "";
                    a = sc.nextLine();
                } while (a.equals(""));
                System.out.print("Substring - forneça a string a ser procurada: ");
                String b;
                do {
                    b = "";
                    b = sc.nextLine();
                } while (b.equals(""));
                System.out.println(findSubstring(a, b));
                break;
            }

            case 10: {
                // nroDigit
                System.out.print("Número de dígitos - forneça um número: ");
                int n = sc.nextInt();
                System.out.println(nroDigit(n));
                break;
            }

            case 11: {
                // permutations
                System.out.print("Permutações - forneça uma string: ");
                String s;
                do {
                    s = "";
                    s = sc.nextLine();
                } while (s.equals(""));
                System.out.println(permutations(s));
                break;
            }

            default: {
                System.out.println("Opção inválida.");
                break;
            }
        }
    }

    private static boolean isNumeric (String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
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
        if (n < 2) return String.valueOf(n);
        return toBinary(n/2) + (n%2);
    }

    private static int alSum (ArrayList<Integer> al) {
        if (al.size() == 1) return al.get(0);
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
        if (n < 10) return 1;
        int remaining = n / 10;
        return 1 + nroDigit (remaining);
    }

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
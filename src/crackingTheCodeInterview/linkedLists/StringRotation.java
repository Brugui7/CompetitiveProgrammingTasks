package crackingTheCodeInterview.linkedLists;

/**
 * Assume you have a method isSubstring which checks if one word if a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of sq using only one call to isSubstring.
 * e.g., "waterbottle" is a rotation of "erbottlewat".
 */
public class StringRotation {

    private static boolean stringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s2 + s2).contains(s1);
    }

    public static void main(String[] args) {
        System.out.println("perro roper: " + stringRotation("perro", "roper"));
        System.out.println("b a: " + stringRotation("b", "a"));
        System.out.println("casaa aacas: " + stringRotation("casaa", "aacas"));
        System.out.println("hoy hoy: " + stringRotation("hoy", "hoy"));

    }
}

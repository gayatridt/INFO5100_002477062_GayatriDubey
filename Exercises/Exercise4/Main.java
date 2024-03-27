import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        // Test cases for each pattern
        String[][] testCases = {
                {"email.dmz@email.in", "user%example.com@example.org", "a@b@c@example.com"}, // Test cases for email
                {"12321.pdf", "ffww.doc", "abc.fee"}, // Test cases for file extensions
                {"https://www.example.com", "https://www.example.c34242"}, // Test cases for URLs
                {"Password1#", "pass123."}, // Test cases for password check
                {"abc_def", "flower!"}, // Test cases for username
        };

        String[] patterns = Regex.PATTERNS; //get patterns from Regex class
        for (int i = 0; i < patterns.length; i++)
        {
            System.out.println("Pattern: " + patterns[i]);
            Pattern pattern = Pattern.compile(patterns[i]);

            for (String testString : testCases[i])
            {
                Matcher matcher = pattern.matcher(testString);
                boolean matches = matcher.find();
                System.out.println("Test String: " + testString + ", Matches: " + matches);
            }

            System.out.println();
        }
    }
}

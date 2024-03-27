public class Regex {
    // Regular expression patterns
    public static final String[] PATTERNS = {
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|co\\.in|co\\.uk|[a-zA-Z]{2,})$", // Match an email address
            "^\\w+\\.(txt|pdf|doc)$",          // Matches file extensions like ".pdf/.txt/.doc"
            "^(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*\\.[A-Za-z]{2,}([-A-Za-z0-9+&@#/%=~_|])?$",   //Matches URLs
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#.])[A-Za-z\\d@$!%*?&#.]{8,}$", // Match password conditions
            "^[a-zA-Z0-9_]{5,20}$",    // Matches username
    };
}

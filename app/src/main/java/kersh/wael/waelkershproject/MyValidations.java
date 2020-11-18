package kersh.wael.waelkershproject;

public class MyValidations {
    
        private pattern pattern;
        private matcher matcher;
        private static final String PASSWORD_PATTERN="((?=.[a-z])(?=.\\d)(?=.[A-Z])(?=.[@#$%!]).{8,40})";

        public MyValidations() {
            pattern = pattern.compile(PASSWORD_PATTERN);
        }

        public boolean validatepassword(final String password) {

            matcher = pattern.matcher(password);
            boolean matches = matcher.matches();
            return matches;

        }
}

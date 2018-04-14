package handlererror;

@SuppressWarnings("serial")
public class LoginError extends Exception {
    public LoginError(String message) {
        super(message);
    }
    public LoginError() {
        super();
    }
}

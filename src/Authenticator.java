public interface Authenticator {

    public boolean passwordChecker(String password);
    public boolean passwordChangerConditions(String password);

}

public interface Authenticator {

    public boolean passwordChecker(String password);

    //changed the name of this method since it will be used for passwords in general, not just password changes
    public boolean passwordConditions(String password);

}

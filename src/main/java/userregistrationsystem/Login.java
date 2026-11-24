package useregistrationsystem;

public class Login {
    public boolean checkUserName(String username){ return username.contains("_") && username.length() <=5; }
    public boolean checkPasswordComplexity(String password){
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");
        return hasUpper && hasNumber && hasSpecial && password.length()>=8;
    }
    public boolean checkCellPhoneNumber(String number){ return number.matches("^\\+27\\d{9}$"); }
    public String registerUser(String username, String password){
        if(!checkUserName(username)) return "Username is not correctly formatted.";
        if(!checkPasswordComplexity(password)) return "Password is not correctly formatted.";
        return "User registered successfully.";
    }
    public boolean loginUser(String inU, String inP, String rU, String rP){ return inU.equals(rU) && inP.equals(rP); }
    public String returnLoginStatus(boolean s){ return s ? "Successful login" : "Failed login"; }
}
package Main;
import java.util.Random;

public class User {
    private String name;
    private String companyName;
    private int age;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String companyName, int age) {
        this.name = name;
        this.companyName = companyName;
        this.age = age;
        this.password = createUserpassword();
        this.email = createUseremail();
    }
    private String createUserpassword(){
        StringBuilder sb = new StringBuilder();
        sb.append(makeRandomchar());
        for (int i = 0; i < 4; i++) {
            sb.append(makeRandomint(10));
        }
        sb.append(getfirst5char());
        sb.append(makerandomsymbol());
        return sb.toString();

    }

    private String createUseremail(){
        return String.format("%s_%d@%s.com",getName().toLowerCase(), getAge(),getCompanyName().toLowerCase());

    }
    private String getfirst5char(){
        if (getName().length() < 5){

            int diff = 5-getName().length();
            StringBuilder tempname = new StringBuilder(getName());
            for (int i = 0; i < diff; i++) {
                tempname.append("0");


            }
            return tempname.toString();
        }
        else {
            return getName().substring(0,5);
        }
    }
    public int makeRandomint(int Limit){
        return  (int)(Math.random() * Limit);
    }
    private char makeRandomchar(){
        int ranNoto26 = makeRandomint(26);
        return  (char) ('a' + ranNoto26);

    }
    private char makerandomsymbol(){
        char[] special ={'!','@','#','$','%','^','&','*','(',')','-','=','+','{',':',';'};
        int ransym = makeRandomint(special.length);
        return  special[ransym];
    }

}
class User_entry{
    public static void main(String[] args) {
        User obj = new User("Saurabh","Tesla",18);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());
    }
}

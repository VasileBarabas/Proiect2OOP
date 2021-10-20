package App.Classes;

public class StudentClass extends UserClass{

    private String name;
    private String cnp;
    private String specialisation;

    public StudentClass(String password, String username,String name, String cnp, String spc)
    {
        super(password,username);
        this.name=name;
        this.cnp=cnp;
        this.specialisation=spc;
    }
    public StudentClass(String password, String username,String name, String cnp)
    {
        super(password,username);
        this.name=name;
        this.cnp=cnp;
    }


    @Override
    public String toString() {
        return "StudentClass{" +
                "username='" + super.getUsername() + '\'' +
                ", password='" +super.getPassword() + '\'' +
                ", name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9')
                return false;
        }
        return true;
    }
}

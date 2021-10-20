package App.Classes;

public class ProfessorClass extends UserClass{
    private String name;
    private String cnp;

    public ProfessorClass(String password, String username,String name, String cnp) {
        super(password, username);
        this.name = name;
        this.cnp = cnp;
    }
    public String getName()
    {
        return name;
    }
    public String getCnp()
    {
        return cnp;
    }
}

package servlet.model;

public class AlphaLeeBoardUser {
    private int alno;
    private String id;
    private String pwd;
    private String email;

    public AlphaLeeBoardUser(int alno, String id, String pwd, String email) {
        this.alno = alno;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
    }

    public AlphaLeeBoardUser(String id, String pwd, String email) {
        this.id = id;
        this.pwd = pwd;
        this.email = email;
    }

    public int getAlno() {
        return alno;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "AlphaLeeBoardUser{" +
                "alno=" + alno +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package opinion;

public class Member {

    private String name;
    private String date;
    private String login;
    private String pwd;
    private String mail;

    public Member(String name, String date, String login, String pwd, String mail) {
        this.name = name;
        this.date = date;
        this.login = login;
        this.pwd = pwd;
        this.mail = mail;
    }
    public String getLogin() {
        return this.login;
    }
}

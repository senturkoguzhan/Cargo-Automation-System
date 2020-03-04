/**
 * @author OGUZHAN SENTURK
 */
public abstract class User implements UserInterface {
    private String name;
    private String surname;
    private String password;
    private String user_id;

    /**
     * Default constructor
     */
    public User() {
    }
    /**
     * Constructor of User abstract Class sub classes uses this constructor
     * @param name This is name of sub classes
     * @param surname This is surname of sub classes
     * @param password This is password of sub classes
     * @param user_id This is ID of sub classes
     */
    public User(String name, String surname, String password, String user_id) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.user_id = user_id;
    }
    /**
     * @return This return id
     */
    public String getUser_id() {
        return user_id;
    }
    /**
     *
     * @param user_id This is new id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    /**
     * @return This return name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name This is new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return This return surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * @param surname This is new surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * @return This return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password This is new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

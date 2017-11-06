package repository;

//Class server which have just information when we create new Object, and we have one constructor POJO class
public class Server {

    private String serverName;
    private String databaseName;
    private String root;
    private String pass;

    public Server(String serverName, String databaseName, String root, String pass) {
        this.serverName = serverName;
        this.databaseName = databaseName;
        this.root = root;
        this.pass = pass;
    }

    /**
     * @return the serverName
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * @param serverName the serverName to set
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * @return the databaseName
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * @param databaseName the databaseName to set
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * @return the root
     */
    public String getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(String root) {
        this.root = root;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}

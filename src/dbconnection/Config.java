package dbconnection;


public class Config {
    protected static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String DB_URL = "jdbc:mysql://localhost:";
    protected static final String DB_PORT = "3306";
    protected static final String DB_NAME = "/gamedb?useSSL=false";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "root";
    protected static final String MAX_POOL = "250"; // set your own limit
    public static final String PATH_SOURCE = "D:\\Documenti\\java\\GameCenterProject\\gamesCenterDB\\"; // imagine this is a server
    public static final String DEFAULT_IMAGE = PATH_SOURCE + "default.png";
}

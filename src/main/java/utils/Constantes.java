package utils;

public class Constantes {
    public static String pathProjeto= System.getProperty("user.dir");
    public static String pathChrome= pathProjeto+"/src/main/resources/chromedriver.exe";
    public static String pathFirefox= pathProjeto+"/src/main/resources/geckodriver.exe";

    public static String urlBase= "https://ankiweb.net/account/login";
    public static int defaultTimeout= 30;
}

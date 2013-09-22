package quizlet;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: jackkates
 * Date: 9/22/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    public static InputStream get(String baseURL, String query) {
        InputStream response = null;
        try {
            URL url = new URL(baseURL + query);
            URLConnection connection = url.openConnection();
            response = connection.getInputStream();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}

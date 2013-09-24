package quizlet;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Utils {

    public static InputStream get(String baseURL, String query) {
        return get(baseURL + query);
    }

    public static InputStream get(String urlString) {
        InputStream response = null;
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            response = connection.getInputStream();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}

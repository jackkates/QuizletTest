import com.google.gson.Gson;
import quizlet.Term;
import quizlet.Set;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {

    public static void main(String[] args) {
        new Main().downloadSet();
    }

    public void downloadSet() {
        InputStream inputStream = null;
        String baseURL = "https://api.quizlet.com/2.0/users/jackkates11/sets";
        String query = "";
        String clientId = "?client_id=c29cpp29Gf";

        try {
            URL url = new URL(baseURL + clientId + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();

            Gson gson = new Gson();
            Set[] setList = gson.fromJson(new InputStreamReader(inputStream), Set[].class);
            Set set = setList[0];
            Term term = set.terms.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

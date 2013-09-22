package quizlet;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;


public class Quizlet {

    private final static String baseSearchURL = "https://api.quizlet.com/2.0/search/sets";

    private String clientID;

    public Quizlet(String clientID) {
        this.clientID = clientID;
    }

    public SearchResult search(String query) {
        SearchResult result = null;
        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            String url = baseSearchURL + "?" + clientID + "&" + encodedQuery;
            //Perform GET
            InputStream response = Utils.get(url);
            InputStreamReader reader = new InputStreamReader(response);

            //Create SearchResult from Json
            Gson gson = new Gson();
            result = gson.fromJson(reader, SearchResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

package quizlet;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;


public class Quizlet {

    private final static String baseSearchURL = "https://api.quizlet.com/2.0/search/sets";
    private final static String baseSetURL =  "https://api.quizlet.com/2.0/sets/";

    private String clientID;
    private Gson gson;

    public Quizlet(String clientID) {
        this.clientID = clientID;
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    public SearchResult search(String query) {
        SearchResult result = null;
        try {
            QuizletResponse response = get(baseSearchURL, query);
            //Create SearchResult from Json
            result = gson.fromJson(response, SearchResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Set getSet(int id) {
        InputStreamReader reader = get(baseSetURL + id, "");
        //Create Set from Json
        Set set = gson.fromJson(reader, Set.class);
        return set;
    }

    private QuizletResponse get(String baseURL, String query) {
        String url = String.format("%s?client_id=%s&%s", baseURL, clientID, query);
        //Perform GET
        InputStream stream = Utils.get(url);
        QuizletResponse response = new QuizletResponse(stream);
        return response;
    }
}

package quizlet;

import java.util.List;

public class Set {

    public int id;
    public String url;
    public String title;
    public String created_by;
    public int term_count;
    /**
     * List of terms.
     */
    public List<Term> terms;

}

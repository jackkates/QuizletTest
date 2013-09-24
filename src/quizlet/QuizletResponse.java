package quizlet;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Creator: jackkates
 * Date: 9/23/13
 */
class QuizletResponse extends InputStreamReader {

    /**
     * Constucts a QuizletResponse object with the specified stream
     * @param inputStream
     */
    QuizletResponse(InputStream inputStream) {
        super(inputStream);
    }
}

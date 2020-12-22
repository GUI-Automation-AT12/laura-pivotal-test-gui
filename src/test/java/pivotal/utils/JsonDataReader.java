package pivotal.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pivotal.config.Environment;

public class JsonDataReader {

    /**
     * Json reader string.
     *
     * @param key      the key
     * @param filePath the file path
     * @return the string
     */
    public String jsonReader(final String key, final String filePath) {
        String data = "";
        try {
            File srcFile = new File(Environment.getInstance().getSchemasPath() + filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(srcFile));
            data = (String) jsonObject.get(key);
        } catch (IOException | ParseException exception) {
            exception.getStackTrace();
        }
        return data;
    }
}

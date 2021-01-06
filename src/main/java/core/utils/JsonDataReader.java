package core.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pivotal.config.Environment;

public class JsonDataReader {

    private static final String USERS_PATH = "usersPath";
    private HashMap mapData;
    private JSONObject jsonObject;

    /**
     * Instantiates a new Json data reader.
     *
     * @param filePath the file path
     */
    public JsonDataReader(final String filePath) {
        this.jsonObject = convert(jsonReader(filePath));
    }

    private Object jsonReader(final String filePath) {
        Object object = new Object();
        try {
            File srcFile = new File(Environment.getInstance().getProperties().get(USERS_PATH) + filePath);
            JSONParser jsonParser = new JSONParser();
            object = jsonParser.parse(new FileReader(srcFile));
        } catch (IOException | ParseException exception) {
            exception.getStackTrace();
        }
        return object;
    }

    private JSONObject convert(final Object object) {
        if (object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
            jsonObject = (JSONObject) jsonArray.get(0);
        } else {
            jsonObject = (JSONObject) object;
        }
        return jsonObject;
    }

    private void toMap(final String identifier) {
        mapData = new HashMap<String, String>();
        mapData = (HashMap) (jsonObject.get(identifier));
    }

    /**
     * Gets value data from a key given.
     *
     * @param identifier the identifier
     * @param key        the key
     * @return the value data
     */
    public String getValueData(final String identifier, final String key) {
        toMap(identifier);
        String value = "";
        if (mapData.containsKey(key)) {
            value = String.format("%s", mapData.get(key));
        }
        return value;
    }
}

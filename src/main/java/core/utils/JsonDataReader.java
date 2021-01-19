package core.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pivotal.config.Environment;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonDataReader {

    private static final String USERS_PATH = "usersPath";
    private HashMap mapData;
    private JSONObject jsonObject;
    private JSONArray jsonArray;

    /**
     * Instantiates a new Json data reader.
     *
     * @param filePath the file path
     */
    public JsonDataReader(final String filePath) {
        jsonReader(filePath);
    }

    private JSONObject searchJsonObject(final String identifier) {
        HashMap<String, Object> map = new HashMap<>();
        return (JSONObject) jsonArray.get(0);
    }
    private void jsonReader(final String filePath) {
        try {
            File srcFile = new File(Environment.getInstance().getProperties().get(USERS_PATH) + filePath);
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(new FileReader(srcFile));
            if (object instanceof JSONArray) {
                this.jsonArray = (JSONArray)object;
            } else {
                this.jsonObject = (JSONObject) object;
            }
        } catch (IOException | ParseException exception) {
            exception.getStackTrace();
        }
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
        if (this.jsonObject == null) {
            this.jsonObject = searchJsonObject(identifier);
            jsonArray = null;
        }
        toMap(identifier);
        String value = "";
        if (mapData.containsKey(key)) {
            value = String.format("%s", mapData.get(key));
        }
        return value;
    }
}

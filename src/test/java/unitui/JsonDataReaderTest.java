package unitui;

import org.testng.Assert;
import org.testng.annotations.Test;
import core.utils.JsonDataReader;

public class JsonDataReaderTest {
    private String filePath = "users.json";
    private String key = "Name";
    private String identifier = "user";

    /**
     * Test json read name.
     */
    @Test
    public void testJsonReadName() {
      String expected = "Auto";
      String actual = new JsonDataReader(filePath).getValueData(identifier, key);
      Assert.assertEquals(actual, expected);
    }
}

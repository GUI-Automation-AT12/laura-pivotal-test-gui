package unitui;

import org.testng.Assert;
import org.testng.annotations.Test;
import core.utils.JsonDataReader;

public class JsonDataReaderTest {
    private String filePath = "users.json";
    private String key = "name";
    private String identifier = "Editable User";

    /**
     * Test json read name.
     */
    @Test
    public void testJsonReadName() {
      String expected = "testauto2020";
      String actual = new JsonDataReader(filePath).getValueData(identifier, key);
      Assert.assertEquals(actual, expected);
    }
}

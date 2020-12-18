package unitui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pivotal.utils.JsonDataReader;

public class JsonDataReaderTest {
    private String filePath = "meResponse.json";
    private String key = "name";

    /**
     * Test json read name.
     */
    @Test
    public void testJsonReadName() {
      String expected = "testauto21";
      String actual = new JsonDataReader().jsonReader(key, filePath);
      Assert.assertEquals(actual, expected);
    }
}

import org.apache.http.client.methods.HttpOptions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Options204 extends BaseTestClass {

    @Test
    public void optionsReturnsCorrectMethodsList() throws IOException {
        String header = "Access-Control-Allow-Methods";
        String expectedReply = "GET, POST, PATCH, PUT, DELETE";

        HttpOptions request = new HttpOptions(BASE_ENDPOINT);
        response = client.execute(request);

        String actualValue = ResponseUtils.getHeader(response, header);

        assertEquals(actualValue, expectedReply);

    }
}

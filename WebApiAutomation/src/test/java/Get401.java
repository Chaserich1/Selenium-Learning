import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get401 extends BaseTestClass{

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void cleanup() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void userReturns401() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 401);
    }

    @Test
    public void userFollowersReturns401() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user/followers");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 401);
    }

    @Test
    public void notificationsReturns401() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/notifications");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 401);
    }
}

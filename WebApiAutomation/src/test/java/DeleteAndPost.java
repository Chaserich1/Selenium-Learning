import entities.Credentials;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.codehaus.plexus.util.Base64;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;

public class DeleteAndPost extends BaseTestClass {

    @Test(description = "This test will only work if you set a valid token in the Credentials class")
    public void deleteSuccessful() throws IOException {

        HttpDelete request = new HttpDelete(BASE_ENDPOINT + "/repos/Chaserich1/deleteme");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(actualStatusCode, 204);
    }

    //Will only work for basic auth
    @Test(description = "This test will only work if you set a valid email + password in the Credentials class")
    public void createRepoReturns201() throws IOException {

        //Create HttpPost with a valid endpoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/user/repos");

        //Set the basic auth header
        String auth = Credentials.EMAIL + ":" + Credentials.PASSWORD;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        //Defined the Json to Post and set as Entity
        String json = "{\"name\": \"deleteme\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        //Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 201);
    }

    //In Nov 2020 when they remove basic auth this will work with web token
    @Test(description = "This test will only work if you set a valid token in the Credentials class")
    public void createRepoReturns201WebToken() throws IOException {

        //Create HttpPost with a valid endpoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/user/repos");

        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + Credentials.TOKEN);

        //Defined the Json to Post and set as Entity
        String json = "{\"name\": \"deleteme\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        //Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 201);
    }

}

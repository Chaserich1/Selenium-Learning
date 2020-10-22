import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static entities.User.ID;
import static entities.User.LOGIN;
import static org.testng.Assert.assertEquals;

public class BodyTestWithSimpleMap extends BaseTestClass{

    @Test
    public void returnsCorrectLogin() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/Chaserich1");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());
        //System.out.println(jsonBody);

        JSONObject jsonObject = new JSONObject(jsonBody);

        String loginValue = (String) getValueFor(jsonObject, LOGIN);

        assertEquals(loginValue, "Chaserich1");
    }

    @Test
    public void returnsCorrectId() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/Chaserich1");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());
        //System.out.println(jsonBody);

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer loginValue = (Integer) getValueFor(jsonObject, ID);

        assertEquals(loginValue, Integer.valueOf(50150341));
    }

    private Object getValueFor(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }
}

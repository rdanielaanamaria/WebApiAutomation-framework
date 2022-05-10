import org.apache.http.client.methods.HttpOptions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class Options204 extends BaseClass {
    @Test
    public void  optionsReturnsCorrectMethodsList() throws IOException {

        String header = "Access-Control-Allow-Methods";
        String expectedReply = "GET, POST, PATCH, PUT, DELETE";
// verify that the API gives us the correct answer (in out case are "GET, POST, PATCH, PUT, DELETE")
//        create the request object, and execute the request and get in a response
        HttpOptions request = new HttpOptions(BASE_ENDPOINT);
        response = client.execute(request);

//        extract the header with util method
        String actualValue = ResponseUtils.getHeader(response, header);
        assertEquals(actualValue, expectedReply);
    }
}

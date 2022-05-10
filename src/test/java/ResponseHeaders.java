import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ResponseHeaders extends BaseClass {

// The header is called content-type which tells us the media type(json in this case) plus the encoding
    @Test
    public void contentTypeJson() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);
        Header contentType = response.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");
    }
}

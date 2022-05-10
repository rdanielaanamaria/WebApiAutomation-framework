import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class Get200 extends BaseClass{

    @Test
    public void rateLimitReturns200() throws IOException {
//        rate_limit tells how many requests we have left within a given timeframe
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        response = client.execute(get);
        int actualResult = response.getStatusLine().getStatusCode();
        assertEquals(actualResult,200);
    }

    @Test
    public void searchResponseReturns200() throws IOException {
//        rate_limit tells how many requests we have left within a given timeframe
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");
        response = client.execute(get);
        int actualResult = response.getStatusLine().getStatusCode();
        assertEquals(actualResult,200);
    }
}

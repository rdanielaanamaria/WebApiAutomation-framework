import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import org.testng.annotations.Test;

import java.io.IOException;


import static org.testng.AssertJUnit.assertEquals;

public class DeleteAndPost extends BaseClass{

    @Test
    public void deleteIsSuccessful() throws IOException {
        HttpDelete request = new HttpDelete("https://github.com/rdanielaanamaria/deleteme.git");
        //        in order to delete the repo we must provide credentials
//        github/developer setting / personal access tokens / generate new token - the test should delete the repo
//        (it works just one time, since it has nothing to delete the second time)
//        request.setHeader(HttpHeaders.AUTHORIZATION, "token" + Credentials.TOKEN);

        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(actualStatusCode,301);
    }

    @Test
    public void createRepoReturns201() throws IOException {
//        Create an Http post with a valid Endpoint
        HttpPost request = new HttpPost("https://github.com/rdanielaanamaria?tab=repositories");
//        Set the Basic authentication header with valid login and password (use basic authentication)
        String authHeader = Credentials.EMAIL + ":" + Credentials.PASSWORD;
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
//        define json object to post and set it as the entity of the request
        String json = "{\"name\": \"deleteme\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
//        send it
        response  = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        assertEquals(actualStatusCode, 403);

    }
}

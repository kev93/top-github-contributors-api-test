package contributor.application.search;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import org.junit.Test;
import contributor.infraestructure.apiconsumer.HttpRequestMaker;
import contributor.infraestructure.apiconsumer.RESTApiConsumer;
import org.json.JSONObject;

public class ContributorSearchShould {

//    @Test
//    public void return_json_object_when_valid_json_string_was_given() {
//        JSONObject expectedJsonObject = new JSONObject("{\"valid\":{\"json\":\"response\"}}");
//        HttpRequestMaker requestMaker = createRequestMakerStub(expectedJsonObject.toString());
//
//        JSONObject response = new RESTApiConsumer(requestMaker).get("someURL");
//
//        assertEquals(expectedJsonObject.toString(), response.toString());
//    }
//
//    private HttpRequestMaker createRequestMakerStub(String response) {
//        HttpRequestMaker requestMaker = mock(HttpRequestMaker.class);
//
//        when(requestMaker.get(anyString())).thenReturn(response);
//
//        return requestMaker;
//    }

//    @Test
//    public void return_json_object_when_valid_json_string_was_given() {
//        JSONObject expectedJsonObject = new JSONObject("{\"valid\":{\"json\":\"response\"}}");
//        HttpRequestMaker requestMaker = createRequestMakerStub(expectedJsonObject.toString());
//
//        JSONObject response = new RESTApiConsumer(requestMaker).get("someURL");
//
//        assertEquals(expectedJsonObject.toString(), response.toString());
//    }
//
//    private HttpRequestMaker createRequestMakerStub(String response) {
//        HttpRequestMaker requestMaker = mock(HttpRequestMaker.class);
//
//        when(requestMaker.get(anyString())).thenReturn(response);
//
//        return requestMaker;
//    }
}

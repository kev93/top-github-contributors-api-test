package contributor.infraestructure.apiconsumer;

import org.json.JSONObject;

public final class RESTApiConsumer implements ApiConsumer {

    private HttpRequestMaker requestMaker;

    public RESTApiConsumer(HttpRequestMaker requestMaker) {
        this.requestMaker = requestMaker;
    }

    public JSONObject get(String url) {
        return new JSONObject(requestMaker.get(url));
    }
}
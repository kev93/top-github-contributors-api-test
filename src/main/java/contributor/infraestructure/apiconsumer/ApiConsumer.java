package contributor.infraestructure.apiconsumer;

import org.json.JSONObject;

public interface ApiConsumer {
    public JSONObject get(String url);
}
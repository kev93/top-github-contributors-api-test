package contributor.infraestructure.apiconsumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import contributor.infraestructure.exception.InvalidUrlWasGivenException;
import contributor.infraestructure.exception.ResponseContentCanNotBeReadException;

public class HttpRequestMaker {

    public String get(String url) {
        String responseAsString;

        HttpURLConnection connection = this.openConnection(url);

        return this.readResponseFromConnection(connection);
    }

    private HttpURLConnection openConnection(String url) {
        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod("GET");
            return con;
        } catch (IOException e) {
            throw new InvalidUrlWasGivenException("Given URL is invalid");
        }
    }

    private String readResponseFromConnection(HttpURLConnection connection) {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    connection.getInputStream()
                )
            );
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (IOException e) {
            throw new ResponseContentCanNotBeReadException("Response body can not be read");
        }
    }
}
package contributor.infraestructure.apiconsumer;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEmptyString.*;
import org.junit.Before;
import org.junit.Test;
import contributor.infraestructure.apiconsumer.HttpRequestMaker;
import contributor.infraestructure.exception.InvalidUrlWasGivenException;

public class HttpRequestMakerShould {

    @Test(expected = InvalidUrlWasGivenException.class)
    public void throw_an_exception_when_invalid_url_was_given() {
        HttpRequestMaker requestMaker = new HttpRequestMaker();

        String response = requestMaker.get("");
    }

    @Test
    public void send_get_request_returning_string_response() {
        HttpRequestMaker requestMaker = new HttpRequestMaker();

        String response = requestMaker.get("https://api.github.com/search/users?q=tom+repos:%3E42+followers:%3E1000");

        assertThat(response, is(not(isEmptyString())));
    }
}

package contributor.infraestructure.persistence;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import contributor.domain.model.Contributor;
import contributor.infraestructure.apiconsumer.ApiConsumer;
import contributor.infraestructure.persistence.GitHubApiContributorRepository;
import org.json.JSONObject;

public class GitHubApiContributorRepositoryShould {

    private final static String CITY_PROPERTY_NAME = "location";

    @Test
    public void return_empty_contributors_list_when_api_returns_empty_response() {
        ApiConsumer apiConsumer = createApiConsumerMock(new JSONObject("{\"items\":[]}"));

        List<Contributor> contributors = new GitHubApiContributorRepository(apiConsumer).searchBy(
            createCriteriaFrom(CITY_PROPERTY_NAME, "=", "city"),
            "repos",
            10,
            "desc"
        );

        assertTrue(contributors.isEmpty());
    }

    @Test
    public void return_contributors_list_when_api_returns_items() {
        ApiConsumer apiConsumer = createApiConsumerMock(new JSONObject("{\"items\":[{\"login\": \"Tester\", \"id\": 1222, \"html_url\": \"https://github.com/tester\"}]}"));
        List<Contributor> expectedContributors = new ArrayList<Contributor>();
        expectedContributors.add(new Contributor(1222, "Tester", "https://github.com/tester"));


        List<Contributor> contributorsFromApi = new GitHubApiContributorRepository(apiConsumer).searchBy(
                createCriteriaFrom(CITY_PROPERTY_NAME, "=", "city"),
                "repos",
                10,
                "desc"
        );

        assertEquals(contributorsFromApi.get(0).getId(), expectedContributors.get(0).getId());
    }

    private Map<String, Entry<String, String>> createCriteriaFrom(String propName, String operator, String value) {
        return new LinkedHashMap<String, Entry<String, String>>() {{
            put(propName, new SimpleEntry<String, String>(operator, value));
        }};
    }

    private ApiConsumer createApiConsumerMock(JSONObject response) {
        ApiConsumer apiConsumer = mock(ApiConsumer.class);

        when(apiConsumer.get(anyString())).thenReturn(response);

        return apiConsumer;
    }
}

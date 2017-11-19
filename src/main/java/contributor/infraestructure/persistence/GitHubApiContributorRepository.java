package contributor.infraestructure.persistence;

import contributor.infraestructure.apiconsumer.ApiConsumer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import contributor.domain.model.ContributorRepository;
import contributor.domain.model.Contributor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import org.json.JSONObject;

public final class GitHubApiContributorRepository implements ContributorRepository {

    private final static String USERS_ENDPOINT = "https://api.github.com/search/users?q=";

    private ApiConsumer apiConsumer;

    public GitHubApiContributorRepository(ApiConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }

    public List<Contributor> searchBy(
        Map<String, Entry<String, String>> criteria,
        String sortBy,
        Integer maxResults,
        String order
    ) {
        String apiUrlWithGivenParams = buildWholeUrlFrom(criteria, sortBy, maxResults, order);
        JSONObject response = apiConsumer.get(apiUrlWithGivenParams);
        String items = response.get("items").toString();

        return createContributorsListFromJsonString(items);
    }

    private String buildWholeUrlFrom(
        Map<String, Entry<String, String>> criteria,
        String sortBy,
        Integer maxResults,
        String order
    ) {
        String query = buildQueryFromCriteria(criteria);
        StringBuilder wholeUrl = new StringBuilder(USERS_ENDPOINT);
        wholeUrl.append(query);
        wholeUrl.append("&sort=" + sortBy);
        wholeUrl.append("&order=" + order);
        wholeUrl.append("&per_page=" + maxResults.toString());

        return wholeUrl.toString();
    }

    private String buildQueryFromCriteria(Map<String, Entry<String, String>> criteria) {
        StringBuilder query = new StringBuilder();

        for (Map.Entry<String, Entry<String, String>> entry : criteria.entrySet()) {

            if (query.length() != 0) {
                query.append("+");
            }

            query.append(entry.getKey());

            Entry<String, String> propertyCriteria = entry.getValue();
            query.append(":");
            if (!propertyCriteria.getKey().equals("=")) {
                query.append(propertyCriteria.getKey());
            }
            query.append(propertyCriteria.getValue());
        }

        return query.toString();
    }

    private List<Contributor> createContributorsListFromJsonString(String items) {
        List<Contributor> foundContributors;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            foundContributors = objectMapper.readValue(items, new TypeReference<List<Contributor>>(){});
        } catch (IOException e) {
            foundContributors = new ArrayList<Contributor>();
        }

        return foundContributors;
    }
}
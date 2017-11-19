package contributor.application.search;

import contributor.domain.model.ContributorRepository;
import contributor.domain.model.Contributor;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Map;
import static contributor.domain.model.ContributorProperty.CITY;

public final class ContributorSearcher {

    private ContributorRepository repo;

    public ContributorSearcher(ContributorRepository repo) {
        this.repo = repo;
    }

    public List<Contributor> findByCity(String cityName, String sort, Integer maxResults, String order) {
        return repo.searchBy(
            buildCriteriaFrom(cityName),
            sort,
            maxResults,
            order
        );
    }

    private Map<String, Entry<String, String>> buildCriteriaFrom(String cityName) {
        Entry<String, String> cityCriteria = new SimpleEntry<String, String>("=", cityName);

        return new LinkedHashMap<String, Entry<String, String>>() {{
            put(CITY, cityCriteria);
        }};
    }
}
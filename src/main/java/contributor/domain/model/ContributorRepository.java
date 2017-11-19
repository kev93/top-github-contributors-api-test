package contributor.domain.model;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public interface ContributorRepository {

    public List<Contributor> searchBy(
        Map<String, Entry<String, String>> criteria,
        String sortBy,
        Integer maxResults,
        String order
    );
}
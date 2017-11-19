package contributor.application.search;

import java.util.List;
import contributor.domain.model.Contributor;

public final class SearchContributorByCityCommandHandler {

    private ContributorSearcher searcher;

    public SearchContributorByCityCommandHandler(ContributorSearcher searcher) {
        this.searcher = searcher;
    }

    public List<Contributor> execute(SearchContributorByCityCommand command) {
        return searcher.findByCity(
            command.cityName(),
            command.sort(),
            command.maxResults(),
            command.order()
        );
    }
}
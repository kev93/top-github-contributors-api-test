package contributor.infraestructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import java.util.List;
import contributor.domain.model.Contributor;
import contributor.application.search.SearchContributorByCityCommand;
import contributor.application.search.SearchContributorByCityCommandHandler;
import contributor.application.search.ContributorSearcher;
import contributor.infraestructure.persistence.GitHubApiContributorRepository;
import contributor.infraestructure.apiconsumer.HttpRequestMaker;
import contributor.infraestructure.apiconsumer.RESTApiConsumer;

@RestController
public class GetContributorGontroller {

    @RequestMapping(value="/contributors",  produces={"application/json"})
    public List<Contributor> contributors(
            @RequestParam(value="city", defaultValue="barcelona") String cityName,
            @RequestParam(value="sort", defaultValue="repos") String sort,
            @RequestParam(value="size", defaultValue="50") Integer size,
            @RequestParam(value="order", defaultValue="desc") String order
    ) {
        RESTApiConsumer apiConsumer = new RESTApiConsumer(new HttpRequestMaker());
        GitHubApiContributorRepository repo = new GitHubApiContributorRepository(apiConsumer);
        ContributorSearcher searcher = new ContributorSearcher(repo);

        SearchContributorByCityCommandHandler commandHandler = new SearchContributorByCityCommandHandler(searcher);

        return commandHandler.execute(new SearchContributorByCityCommand(cityName, sort, size, order));
    }
}

package contributor.application.search;

public final class SearchContributorByCityCommand {

    private String cityName;
    private String sort;
    private Integer maxResults;
    private String order;

    public SearchContributorByCityCommand(String cityName, String sort, Integer maxResults, String order) {
        this.cityName = cityName;
        this.sort = sort;
        this.maxResults = maxResults;
        this.order = order;
    }

    public String cityName() {
        return cityName;
    }

    public String sort() {
        return sort;
    }

    public Integer maxResults() {
        return maxResults;
    }

    public String order() {
        return order;
    }
}
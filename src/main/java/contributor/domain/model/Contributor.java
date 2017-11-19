package contributor.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contributor {

    private long id;
    private String login;
    @JsonProperty("html_url")
    private String htmlUrl;

    public Contributor() {
        super();
    }

    public Contributor(long id, String login, String htmlUrl) {
        this.id = id;
        this.login = login;
        this.htmlUrl = htmlUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
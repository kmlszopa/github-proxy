package pl.kamilszopa.githubproxy.web.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.kamilszopa.githubproxy.domain.github.Branch;
import pl.kamilszopa.githubproxy.domain.github.Repository;
import reactor.core.publisher.Flux;


@Component
public class GitHubApiClient {
    @Value("${github.api.base-url}")
    private String baseUrl;

    public Flux<Repository> getRepositories(String username) {
        String url = baseUrl + "/users/" + username + "/repos";
        return WebClient.create()
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Repository.class);
    }

    public Flux<Branch> getBranches(Repository repository) {
        String url = baseUrl + "/repos/" + repository.getOwner().getLogin() + "/" + repository.getName() + "/branches";
        return WebClient.create()
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Branch.class);
    }

}


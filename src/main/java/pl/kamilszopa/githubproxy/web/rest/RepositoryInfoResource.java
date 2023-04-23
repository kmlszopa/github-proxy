package pl.kamilszopa.githubproxy.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kamilszopa.githubproxy.dto.RepositoryInfo;
import pl.kamilszopa.githubproxy.service.GitHubService;

import java.util.List;

@RestController
@RequestMapping("/repositories")
public class RepositoryInfoResource {

    private final GitHubService gitHubService;

    public RepositoryInfoResource(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping
    public List<RepositoryInfo> getRepositories(@RequestParam("username") String username) {
        return gitHubService.getRepositoryInfoList(username);
    }
}

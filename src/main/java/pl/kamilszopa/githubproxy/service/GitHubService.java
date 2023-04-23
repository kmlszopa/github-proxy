package pl.kamilszopa.githubproxy.service;

import org.springframework.stereotype.Service;
import pl.kamilszopa.githubproxy.domain.github.Branch;
import pl.kamilszopa.githubproxy.domain.github.Repository;
import pl.kamilszopa.githubproxy.dto.BranchInfo;
import pl.kamilszopa.githubproxy.dto.RepositoryInfo;
import pl.kamilszopa.githubproxy.web.client.GitHubApiClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubService {

    private final GitHubApiClient gitHubApiClient;

    public GitHubService(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    public List<RepositoryInfo> getRepositoryInfoList(String username) {
        List<RepositoryInfo> repositoryInfoList = new ArrayList<>();
        List<Repository> repositories = gitHubApiClient.getRepositories(username)
                .toStream()
                .filter(repository -> !repository.isFork())
                .toList();
        for (Repository repo : repositories) {
            RepositoryInfo repositoryInfo = new RepositoryInfo();
            repositoryInfo.setRepositoryName(repo.getName());
            repositoryInfo.setOwnerLogin(repo.getOwner().getLogin());
            List<Branch> branches = gitHubApiClient.getBranches(repo).toStream().toList();
            List<BranchInfo> branchInfos = new ArrayList<>();
            for (Branch branch : branches) {
                BranchInfo branchInfo = new BranchInfo();
                branchInfo.setBranchName(branch.getName());
                branchInfo.setLastCommitSha(branch.getCommit().getSha());
                branchInfos.add(branchInfo);
            }
            repositoryInfo.setBranches(branchInfos);
            repositoryInfoList.add(repositoryInfo);
        }
        return repositoryInfoList;
    }
}
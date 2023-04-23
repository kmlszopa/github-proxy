package pl.kamilszopa.githubproxy.dto;

import java.util.List;

public class RepositoryInfo {
    private String repositoryName;
    private String ownerLogin;
    private List<BranchInfo> branchesInfo;

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public void setBranches(List<BranchInfo> branchInfos) {
        this.branchesInfo = branchInfos;
    }
}
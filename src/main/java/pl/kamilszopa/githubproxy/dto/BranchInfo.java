package pl.kamilszopa.githubproxy.dto;

public class BranchInfo {
    private String branchName;
    private String lastCommitSha;

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setLastCommitSha(String lastCommitSha) {
        this.lastCommitSha = lastCommitSha;
    }
}
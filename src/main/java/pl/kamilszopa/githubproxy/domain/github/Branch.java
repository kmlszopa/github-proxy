package pl.kamilszopa.githubproxy.domain.github;

public class Branch {
    private String name;
    private Commit commit;

    public String getName() {
        return name;
    }

    public Commit getCommit() {
        return commit;
    }
}
import java.util.Arrays;
import java.util.List;
//EXTRA CREDIT IS DONE
public class ElectionSystem {
    public static void main(String[] args) {
        List<String> candidates = Arrays.asList("Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud");
        Election election = new Election();
        election.initializeCandidates(candidates);

        election.castVote("Cole Train");
        election.castVote("Cole Train");
        election.castVote("Marcus Fenix");
        election.castVote("Anya Stroud");
        election.castVote("Anya Stroud");

        System.out.println("Top 3 candidates after 5 votes: " + election.getTopKCandidates(3));

        election.rigElection("Marcus Fenix", 5);
        System.out.println("Top 3 candidates after rigging the election: " + election.getTopKCandidates(3));

        election.auditElection();
    }
}
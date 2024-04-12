import java.util.*;

public class Election {
    private Map<String, Integer> voteCounts;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;

    public Election() {
        voteCounts = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
    }
    public void initializeCandidates(List<String> candidates) {
        for (String candidate : candidates) {
            voteCounts.put(candidate, 0);
        }
    }

    public void castVote(String candidate) {
        voteCounts.put(candidate, voteCounts.getOrDefault(candidate, 0) + 1);
        maxHeap.clear();
        maxHeap.addAll(voteCounts.entrySet());
    }

    public void castRandomVote() {
        List<String> keys = new ArrayList<>(voteCounts.keySet());
        String randomKey = keys.get(new Random().nextInt(keys.size()));
        castVote(randomKey);
    }

    public void rigElection(String candidate, int totalVotes) {
        int neededVotes = totalVotes - voteCounts.get(candidate) + 1;
        voteCounts.put(candidate, neededVotes);
        maxHeap.clear();
        maxHeap.addAll(voteCounts.entrySet());
    }

    public List<String> getTopKCandidates(int k) {
        List<String> topKCandidates = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = maxHeap.iterator();

        while (iterator.hasNext() && k > 0) {
            topKCandidates.add(iterator.next().getKey());
            k--;
        }

        return topKCandidates;
    }

    public void auditElection() {
        while (!maxHeap.isEmpty()) {
            Map.Entry<String, Integer> entry = maxHeap.poll();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}




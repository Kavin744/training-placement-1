import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            deque.add(arr[i]);
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

            if (deque.size() > k) {
                int removed = deque.removeFirst();
                frequencyMap.put(removed, frequencyMap.get(removed) - 1);
                if (frequencyMap.get(removed) == 0) {
                    frequencyMap.remove(removed);
                }
            }
            maxUnique = Math.max(maxUnique, frequencyMap.size());
        }
        System.out.println(maxUnique);
    }
}

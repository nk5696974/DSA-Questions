class Solution {
    public boolean uniqueOccurrences(int[] arr) {
         Map<Integer, Integer> occurrences = new HashMap<>();

        // Count occurrences of each value in the array
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // Use a set to check for uniqueness of occurrences
        Set<Integer> uniqueOccurrences = new HashSet<>(occurrences.values());

        // If the size of the set is equal to the size of the occurrences map, occurrences are unique
        return uniqueOccurrences.size() == occurrences.size();
    }
}
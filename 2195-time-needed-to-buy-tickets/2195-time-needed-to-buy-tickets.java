class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int[] remainingTickets = new int[n];

        // Initialize the remaining tickets for each person
        for (int i = 0; i < n; i++) {
            remainingTickets[i] = tickets[i];
        }

        int time = 0;

        // Simulate the process until the person at position k finishes buying tickets
        while (remainingTickets[k] > 0) {
            // Process each person in the line
            for (int i = 0; i < n; i++) {
                // If the person has remaining tickets, they buy one
                if (remainingTickets[i] > 0) {
                    remainingTickets[i]--;
                    time++;

                   
                    if (i == k && remainingTickets[k] == 0) {
                        return time;
                    }
                }
            }
        }

        return time;
    }
}
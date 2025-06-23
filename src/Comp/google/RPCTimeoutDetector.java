package Comp.google;

import java.util.*;
//https://leetcode.com/discuss/post/924141/google-phone-screen-new-grad/
public class RPCTimeoutDetector {
    public static void main(String[] args) {
        // Format: {id, time, type} where type: 0=Start, 1=End
        List<int[]> logs = Arrays.asList(
                new int[]{0, 0, 0},
                new int[]{1, 1, 0},
                new int[]{0, 2, 1},
                new int[]{2, 6, 0},
                new int[]{1, 7, 1}
        );
        int timeout = 3;

        List<int[]> timeouts = detectTimeouts(logs, timeout);
        for (int[] entry : timeouts) {
            System.out.println(Arrays.toString(entry));
        }
        // Output: [1, 6]
    }

    private static List<int[]> detectTimeouts(List<int[]> logs, int timeout) {
        //record timeout in result with <id, time>
        List<int[]> result = new ArrayList<>();

        //active requests id
        Map<Integer, Integer> activeRequests = new HashMap<>();
        Queue<int[]> requestQueue = new ArrayDeque<>(); // [id, startTime]

        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            String type = log[2] == 0 ? "Start" : "End";// Assuming 0=Start, 1=End

            if (type.equals("Start")) {
                activeRequests.put(id, time);
                requestQueue.add(new int[]{id, time});
            } else {
                activeRequests.remove(id);
            }

            // Check for timeouts in the queue
            while (!requestQueue.isEmpty()) {
                int[] oldestRequest = requestQueue.peek();
                int oldestId = oldestRequest[0];
                int oldestStart = oldestRequest[1];
                if (!activeRequests.containsKey(oldestId)) {
                    // Request already completed, remove from queue
                    requestQueue.poll();
                } else if (time - oldestStart > timeout) {
                    // Timeout detected
                    result.add(new int[]{oldestId, time});
                    activeRequests.remove(oldestId);
                    requestQueue.poll();
                } else {
                    // No more timeouts possible yet
                    break;
                }

            }

        }
        return result;
    }

}

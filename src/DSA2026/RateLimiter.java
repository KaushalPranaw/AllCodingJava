package DSA2026;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Map<String, Deque<Long>> userRequests;

    //constructor
    public RateLimiter(int maxRequests, long windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInSeconds * 1000;
        this.userRequests = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        userRequests.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> timeStamps = userRequests.get(userId);

        // Remove expired timestamps
        while (!timeStamps.isEmpty()
                && currentTime - timeStamps.peekFirst() > windowSizeInMillis) {
            timeStamps.pollFirst();
        }

        //check limit
        if (timeStamps.size() < maxRequests) {
            timeStamps.addLast(currentTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {

        RateLimiter rateLimiter=new RateLimiter(3,5);
        String user = "user1";

        for (int i = 1; i <= 10; i++) {
            boolean allowed = rateLimiter.allowRequest(user);
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(1000);
        }

    }
}

package Comp.Unicommerce;

import java.util.*;

/*
You are given two arrays: deadline[] and profit[], representing N jobs.
Each job: takes 1 unit of time to complete, can be scheduled only if finished on or before its deadline,
gives the associated profit only when completed in time, and only one job can run at a time.
You must schedule jobs to maximize total profit, while also completing the maximum number of jobs possible within deadlines.
Return: The maximum number of jobs that can be completed on time. T
the maximum total profit earned from those jobs.

Examples: Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job 1 and Job 3 can be scheduled → profit = 20 + 40 = 60.

Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job 1 and Job 3 → profit = 100 + 27 = 127.

Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
Output: [3, 100] Explanation: Job 1, Job 3, Job 4 → profit = 50 + 20 + 30 = 100.
 */
public class JobSequencing {
    record Job(int deadline, int profit) {
    }

    public static void main(String[] args) {
        // ===== Test Case 1 =====
        int[] d1 = {4, 1, 1, 1};
        int[] p1 = {20, 10, 40, 30};
        System.out.println("TC1 -> " + Arrays.toString(jobScheduling(d1, p1)));
        // Expected: [2, 60]

        // ===== Test Case 2 =====
        int[] d2 = {2, 1, 2, 1, 1};
        int[] p2 = {100, 19, 27, 25, 15};
        System.out.println("TC2 -> " + Arrays.toString(jobScheduling(d2, p2)));
        // Expected: [2, 127]

        // ===== Test Case 3 =====
        int[] d3 = {3, 1, 2, 2};
        int[] p3 = {50, 10, 20, 30};
        System.out.println("TC3 -> " + Arrays.toString(jobScheduling(d3, p3)));
        // Expected: [3, 100]

        // ===== Test Case 4 =====
        int[] d4 = {1, 1, 1, 1};
        int[] p4 = {10, 20, 30, 40};
        System.out.println("TC4 -> " + Arrays.toString(jobScheduling(d4, p4)));
        // Expected: [1, 40]

        // ===== Test Case 5 =====
        int[] d5 = {1, 2, 3, 4};
        int[] p5 = {10, 20, 30, 40};
        System.out.println("TC5 -> " + Arrays.toString(jobScheduling(d5, p5)));
        // Expected: [4, 100]

        // ===== Test Case 6 =====
        int[] d6 = {5, 5, 5};
        int[] p6 = {10, 20, 30};
        System.out.println("TC6 -> " + Arrays.toString(jobScheduling(d6, p6)));
        // Expected: [3, 60]

        // ===== Test Case 7 =====
        int[] d7 = {1, 2, 3};
        int[] p7 = {0, 0, 10};
        System.out.println("TC7 -> " + Arrays.toString(jobScheduling(d7, p7)));
        // Expected: [3, 10]

        // ===== Test Case 8 =====
        int[] d8 = {1, 2, 10};
        int[] p8 = {5, 10, 100};
        System.out.println("TC8 -> " + Arrays.toString(jobScheduling(d8, p8)));
        // Expected: [3, 115]

        // ===== Test Case 9 =====
        int[] d9 = {1};
        int[] p9 = {50};
        System.out.println("TC9 -> " + Arrays.toString(jobScheduling(d9, p9)));
        // Expected: [1, 50]
    }

    private static int[] jobScheduling(int[] deadline, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        int n = deadline.length;
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(deadline[i], profit[i]));
        }

        // 1️⃣ Sort by deadline (ascending)
        jobs.sort((a, b) -> a.deadline - b.deadline);

        // 2️⃣ Min-heap for profits
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3️⃣ Process jobs
        for (Job job : jobs) {
            pq.add(job.profit);
            if (pq.size() > job.deadline) {
                pq.poll();
            }
        }


        // 4️⃣ Calculate results
        int totalJobs = pq.size();
        int totalProfit = pq.stream().mapToInt(i -> i).sum();
        return new int[]{totalJobs, totalProfit};

    }
}

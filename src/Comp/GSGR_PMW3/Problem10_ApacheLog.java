package Comp.GSGR_PMW3;

import java.util.*;

public class Problem10_ApacheLog {
    public static void main(String[] args) {
        String[] lines1 = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"
        };
        System.out.println(findTopIpaddress(lines1)); // Output: 10.0.0.1

        String[] lines2 = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234"
        };
        System.out.println(findTopIpaddress(lines2)); // Output: 10.0.0.1,10.0.0.2
    }

    /*public static String findTopIpaddress(String[] lines) {
        // Map to store IP addresses and their access counts
        Map<String, Integer> ipAccessCounts = new HashMap<>();

        // Process each log entry
        for(String line: lines){
            // Extract the IP address (1st field before the first space in the line)
            String ip = line.split(" ")[0];
            // Increment the count for this IP address
            ipAccessCounts.put(ip, ipAccessCounts.getOrDefault(ip, 0) + 1);
        }

        // Find the maximum access count
        int maxCount = Collections.max(ipAccessCounts.values());

        // Collect all IP addresses with the maximum access count
        List<String> topIps = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ipAccessCounts.entrySet()) {
            if (entry.getValue() == maxCount) {
                topIps.add(entry.getKey());
            }
        }
        // Return the IP addresses as a comma-separated string
        return String.join(",", topIps);
    }*/

    public static String findTopIpaddress(String[] lines) {
        Map<String, Integer> map = new HashMap<>();
        for (String line : lines) {
            String ip = line.split(" ")[0];
            map.put(ip, map.getOrDefault(ip, 0) + 1);
        }

        int maxCount = Collections.max(map.values());

        List<String> topIps = new ArrayList<>();
        for (var entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                topIps.add(entry.getKey());
            }
        }

        return String.join(", ", topIps);
    }
}

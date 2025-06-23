package Leetcode.Backtracking;

import CoreJava.OOPS.pillars.inheritance.A;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddresses solution = new RestoreIPAddresses();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        getAllPossibleIpAddresses(0, s, new ArrayList<>(), answer);
        return answer;
    }

    private void getAllPossibleIpAddresses(int index, String s, ArrayList<String> current, List<String> answer) {
        //base case
        if (current.size() == 4) {
            if (s.length() == index) {
                answer.add(String.join(".", current));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if(index+ len>s.length()){
                break;//out of bound
            }
            String ip = s.substring(index, index + len);
            if (isValidIp(ip)) {
                current.add(ip);
                getAllPossibleIpAddresses(index + len, s, current, answer);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValidIp(String ip) {
        //no leading zero
        if (ip.length() > 1 && ip.charAt(0) == '0') {
            return false;
        } else {
            int ipNumber = Integer.parseInt(ip);
            return ipNumber >= 0 && ipNumber <= 255;
        }
    }
}

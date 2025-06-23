package Comp.google;

public class SlidingWindowMaximum {
    /*
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    Means, we need to find the maximum in every window of size 3.

    Step-by-step:
    Initially, deque is empty.

    We will move one by one:

    i = 0, nums[0] = 1
    Deque is empty → Just add index 0.
    Deque: [0]

    i = 1, nums[1] = 3
    3 > nums[deque.back()] → 3 > 1
    So, remove index 0.
    Now deque is empty → Add index 1.
    Deque: [1]

    i = 2, nums[2] = -1
    -1 < nums[deque.back()] → -1 < 3
    So, keep the existing 3.
    Add index 2 at back.
    Deque: [1, 2]

    Now, window size becomes 3 (i = 2, so window is from 0 to 2)
    Maximum is nums[deque.front()] → nums[1] → 3
    Result: [3]

    i = 3, nums[3] = -3
    First, check if deque.front() is out of window.
    (deque.front() = 1, still inside window 1–3, so no remove)
    -3 < nums[deque.back()] → -3 < -1
    So, keep -1.
    Add index 3.
    Deque: [1, 2, 3]

    Window: (1 to 3)
    Maximum is nums[1] = 3
    Result: [3, 3]

    i = 4, nums[4] = 5
    deque.front() = 1, but 1 is out of window 2–4. So remove index 1.
    Now deque: [2, 3]
    5 > nums[deque.back()] → 5 > -3 → remove 3
    5 > nums[deque.back()] → 5 > -1 → remove 2
    Now deque empty → Add 4.
    Deque: [4]

    Window: (2 to 4)
    Maximum is nums[4] = 5
    Result: [3, 3, 5]

    i = 5, nums[5] = 3
    deque.front() = 4, still inside window 3–5 → no remove
    3 < nums[4] → 3 < 5 → keep 5
    Add index 5.
    Deque: [4, 5]

    Window: (3 to 5)
    Maximum is nums[4] = 5
    Result: [3, 3, 5, 5]

    i = 6, nums[6] = 6
    deque.front() = 4, still inside window 4–6 → ok
    6 > nums[5] → remove 5
    6 > nums[4] → remove 4
    Add index 6.
    Deque: [6]

    Window: (4 to 6)
    Maximum is nums[6] = 6
    Result: [3, 3, 5, 5, 6]

     */
    public static void main(String[] args) {

    }
}

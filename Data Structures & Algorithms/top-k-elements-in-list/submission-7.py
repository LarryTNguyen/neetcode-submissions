from queue import PriorityQueue
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        pq = PriorityQueue()
        freq = {}
        for n in nums:
            freq[n] = freq.get(n, 0) + 1
        for num, f in freq.items():
            pq.put((f, num))
            if pq.qsize() > k:
                pq.get()  # evict the least frequent

        # Return
        return [num for _, num in [pq.get() for _ in range(k)]]
        
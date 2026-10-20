class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sCount = {}
        tCount = {}
        for ch in s:
            if ch not in sCount:
                sCount[ch] = 0
            sCount[ch] += 1
        for ch in t:
            if ch not in tCount:
                tCount[ch] = 0
            tCount[ch] += 1
        return sCount == tCount
            

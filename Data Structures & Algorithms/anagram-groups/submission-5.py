class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagramGroup ={}
        for s in strs:
            key = tuple(sorted(s))
            if key not in anagramGroup:
                anagramGroup[key] = []
            anagramGroup[key].append(s)
        return list(anagramGroup.values())
        
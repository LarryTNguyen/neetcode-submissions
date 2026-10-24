class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        posSpeed = []
        stack = []
        for i in range(len(position)):
            posSpeed.append([position[i], speed[i]])
        posSpeed.sort(key=lambda x: x[0], reverse=True)
        for i in range(len(posSpeed)):
            time = (target - posSpeed[i][0])/posSpeed[i][1]
            if len(stack) == 0 or time > stack[-1]:
                stack.append(time)
        return len(stack)
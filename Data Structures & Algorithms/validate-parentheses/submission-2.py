class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch == ')':
                if len(stack) == 0 or stack[-1] != '(':
                    return False
                else:
                    stack.pop()
            elif ch == ']':
                if len(stack) == 0 or stack[-1] != '[':
                    return False
                else:
                    stack.pop()
            elif ch == '}':
                if len(stack) == 0 or stack[-1] != '{':
                    return False
                else:
                    stack.pop()
            else:
                stack.append(ch)
        return len(stack) == 0
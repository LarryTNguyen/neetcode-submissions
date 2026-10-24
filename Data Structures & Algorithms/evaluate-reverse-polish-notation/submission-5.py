class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for tok in tokens:
            match tok:
                case "+":
                    num2 = stack.pop()
                    num1 = stack.pop()
                    stack.append(num1+num2)
                case "*":
                    num2 = stack.pop()
                    num1 = stack.pop()
                    stack.append(num1*num2)
                case "-":
                    num2 = stack.pop()
                    num1 = stack.pop()
                    stack.append(num1-num2)
                case "/":
                    num2 = stack.pop()
                    num1 = stack.pop()
                    stack.append(int (num1/num2))
                case _:
                    stack.append(int(tok))
        return stack.pop()
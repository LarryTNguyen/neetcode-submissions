class MinStack:
    def __init__(self):
        self.regStack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.regStack.append(val)
        if(len(self.minStack) == 0):
            self.minStack.append(val)
            self.minStack.append(val)
        elif self.minStack[-1] < val:
            self.minStack.append(val)
            self.minStack.append(self.minStack[-2])
        else:
            self.minStack.append(self.minStack[-1])
            self.minStack.append(val)
        

    def pop(self) -> None:
        self.regStack.pop()
        self.minStack.pop()
        self.minStack.pop()
        

    def top(self) -> int:
        return self.regStack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]
        

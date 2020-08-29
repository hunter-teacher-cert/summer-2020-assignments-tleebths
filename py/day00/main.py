def factorial(x: int):
    if x<2:
        return 1
    else:
        return x * factorial(x-1)
    
def fibonacci(n: int):
    if n<=1:
        return 0
    elif n==2:
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)
    
def fib(n: int, solved: list):
    length = len(solved)
    
    if n<=length:
        return solved[n-1]
    else:
        solved.append(solved[-1] + solved[-2])
        return fib(n, solved)
    
#print(factorial(5))
print(fib(50,[0,1]))
print(fibonacci(50))

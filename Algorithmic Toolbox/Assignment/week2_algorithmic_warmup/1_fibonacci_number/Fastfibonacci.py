# Uses python3
def calc_fib(n):
    if (n <=1 ):
        return n

    fib1 = 1
    fib2 = 1

    for i in range(n):
        if (i > 1):
            curFib = fib1 + fib2	
            fib1 = fib2
            fib2 = curFib
        
    return fib2
        

n = int(input())
print(calc_fib(n))

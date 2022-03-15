# Uses python3
import sys

def get_fibonacci_huge_naive(n, m):
    if n <= 1:
        return n

    previous = 0
    current  = 1

    for _ in range(n - 1):
        previous, current = current, previous + current

    return current % m

def get_fibonacci_huge_fast(n,m):
    period = get_pisano_period(m)
    j = n % period
    return get_fibonacci_last_digit(j) % m

def get_pisano_period(m):  
    previous = 0
    current = 1
    
    previousMod = 0
    currentMod = 1
    period = 0

    for _ in range(m*m):
        previous,current = current,previous + current 
        previousMod = currentMod,current % m
        period +=1 
        if (previousMod == 0 & currentMod == 1):
            return period
    

def get_fibonacci_last_digit(n):
    if n <= 1:
        return n

    fib1 = 1
    fib2 = 1

    for i in range(n):
        if (i > 1):
            curFib = (fib1 + fib2) % 10 
            fib1 = fib2
            fib2 = curFib
        
    return fib2


if __name__ == '__main__':
    input = sys.stdin.read();
    n, m = map(int, input.split())
    print(get_fibonacci_huge_fast(n, m))

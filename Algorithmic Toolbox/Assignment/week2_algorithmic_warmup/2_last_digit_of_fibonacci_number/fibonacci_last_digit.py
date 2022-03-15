# Uses python3
import sys

def get_fibonacci_last_digit_naive(n):
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
    input = sys.stdin.read()
    n = int(input)
    print(get_fibonacci_last_digit_naive(n))

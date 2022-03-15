# Uses python3
import sys

def fibonacci_partial_sum_naive(from_, to):
    _sum = 0

    current = 0
    _next  = 1

    for i in range(to + 1):
        if i >= from_:
            _sum += current

        current, _next = _next, current + _next

    return _sum % 10

def fibonacci_pratial_sum_fast(from_, to):
    a = fibonacci_sum_fast(to)
    b = fibonacci_sum_fast(from_)
    if a > b:
        c = a - b
    else
        c = a + 10 - b
    return c

def fibonacci_sum_fast(n):
    a = get_fibonacci_last_digit(n-1)
    b = get_fibonacci_last_digit(n-2)

    return  (a + b) % 10

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
    from_, to = map(int, input.split())
    print(fibonacci_partial_sum_naive(from_, to))

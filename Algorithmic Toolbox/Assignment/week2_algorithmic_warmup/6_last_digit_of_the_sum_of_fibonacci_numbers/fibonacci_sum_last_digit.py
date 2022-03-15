# Uses python3
import sys

def fibonacci_sum_naive(n):
    if n <= 1:
        return n

    previous = 0
    current  = 1
    _sum     = 1

    for _ in range(n - 1):
        previous, current = current, (previous + current) % 10
        _sum = (_sum  + current) % 10

    return _sum



if __name__ == '__main__':
    input = sys.stdin.read()
    n = int(input)
    print(fibonacci_sum_naive(n))

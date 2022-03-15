# Uses python3
import sys

def get_change(m):
    #write your code here

    if m == 0:
        return 0
    if m > 10:
        return get_change(m-10) + 1
    elif m > 5:
        return get_change(m-5) + 1
    else:
        return get_change(m-1) + 1


if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))

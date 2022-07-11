import string
from math import log

w = {i: 0 for i in string.ascii_lowercase}
w[' '] = 0
keys = [_ for _ in w.keys()]
n = 0
count_nums = int(input())
nums = input().split()
for i in nums:
    num = int(log(abs(int(i) - n), 2))
    n = int(i)
    print(keys[num], end='')
    w[keys[num]] = (w[keys[num]] + 1) % 2

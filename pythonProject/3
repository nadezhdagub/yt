from math import gcd

def is_prime(a: int):
    for i in range(2, a // 2 + 1):
        if a % i == 0:
            return False
    return True


def razlojenie(a: int):
    raz = []
    k = 2
    while k * k <= a:
        if a % k == 0:
            a = a // k
            raz.append(k)
        else:
            k += 1
    if a > 1:
        raz.append(a)
    return raz


def main():
    ans = []
    count = int(input())
    for i in range(count):
        a, b = map(int, input().split())
        nod1 = gcd(a, b)

        raz_a = razlojenie(a // nod1)
        raz_b = razlojenie(b // nod1)

        if len(raz_a) == 0:
            raz_a.append(1)
        if len(raz_b) == 0:
            raz_b.append(1)

        ans.append(nod1 * max(raz_a[-1], raz_b[-1]))

    for i in ans:
        print(i)

main()

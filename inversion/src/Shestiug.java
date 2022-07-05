def check_per(mas1: list, mas2: list):
        if mas1[0] >= mas2[2] or mas1[1] >= mas2[3] or mas1[2] <= mas2[0] or mas1[3] <= mas2[1]:
        return False
        else:
        return True


        prs = []
        n = int(input())
        counts = [0 for _ in range(n)]
        for i in range(n):
        prs.append(list(map(int, input().split())))

        for i in range(n):
        for j in range(i + 1, n):
        if check_per(prs[i], prs[j]):
        counts[i] += 1
        counts[j] += 1
        print(''.join(str(c) + ' ' for c in counts))
                
                #python

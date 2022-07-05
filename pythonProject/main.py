
prs = []
n = int(input())
counts = []
row = True

for a in input().split(maxsplit=n):
    prs.append(list(map(int, a)))
print(prs)

counts.append(-1)
for i in range(1):
    s = prs[i]
    print(s)
    for j in range(n-1):
      if (s[0]==0 and  s[j]==0):
          counts.append(1)
      elif (s[0]==1 and  s[j]==1):
          counts.append(2)
      else :
          counts.append(-1)
print(counts)
print(''.join(str(c) + ' ' for c in counts))



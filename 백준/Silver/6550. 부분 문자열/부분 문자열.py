import sys
input = sys.stdin.readline

while (True):
    try:
        s, t = input().split()
        s_len, t_len = len(s), len(t)

        idx1, cnt = 0, 0
        for i in range(t_len):
            if idx1 == s_len:
                break
            if s[idx1] == t[i]:
                cnt += 1
                idx1 += 1
        if cnt == s_len:
            print("Yes")
        else:
            print("No")
    except:
        break
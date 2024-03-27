def solution(strings, n):
    answer = []
    strings = sorted(strings, key=lambda x:(x[n], x))
    return strings
# def diff(origin, new):
#     cnt = 0
#     # 뒤에서부터 origin의 길이만큼 비교
#     for i in range(len(origin)):
#         if origin[len(origin)-i-1] != new[len(new)-i-1]:
#             cnt += 1
    
#     # new의 길이가 더 길면 1인 경우에만 다른 비트
#     if len(origin) < len(new):
#         for i in range(len(new)-len(origin)):
#             if new[i] == '1':
#                 cnt += 1
#     return cnt
def f(x):
    if x % 2 == 0: return x+1
    
    # x를 2진수로 변환
    x = f'0{bin(x)[2:]}'
    # 첫 0 나온 idx 기준으로 비트 짜르고 가운에 '10' 넣고 다시 붙이기
    x = f"{x[:x.rindex('0')]}10{x[x.rindex('0') + 2:]}"
    
    return int(x, 2)


def solution(numbers):
    answer = []
    # # for i in range(11, 0, -1):
    # #     print(i)
    # for num in numbers:
    #     next_num = num + 1
    #     while (True):
    #         b = str(format(num, 'b'))
    #         next_b = str(format(next_num, 'b'))
    #         if (diff(b, next_b) <= 2):
    #             answer.append(next_num)
    #             break
    #         else:
    #             next_num += 1
    
    
    
    return [f(num) for num in numbers]
def solution(line):
    answer = []
    starPoints = []
    max_x = max_y = -int(1e15)
    min_x = min_y = int(1e15)

    # 정수 교점 찾기 & 최대,최소 지점 찾기
    for i in range(len(line)):
        for j in range(i+1, len(line)):
            tmp_x, tmp_y = findIntersection(line[i], line[j])
            # 정수인지 판별 & x, y의 최대 최소 구하기
            if tmp_x.is_integer() and tmp_y.is_integer():
                tmp_x, tmp_y = int(tmp_x), int(tmp_y)
                max_x, max_y = max(max_x, tmp_x), max(max_y, tmp_y)
                min_x, min_y = min(min_x, tmp_x), min(min_y, tmp_y)
                starPoints.append([tmp_x, tmp_y])

    i = 0
    # y축은 위에서 아래로 x축은 좌에서 우로 진행
    for y in range(max_y, min_y-1, -1):
        str = ""
        for x in range(min_x, max_x+1):
            if [x, y] in starPoints:
                str += "*"
            else:
                str += "."
        answer.append(str)

    return answer




# 교점이 있으면 교점을 리턴, 없으면(=일치 or 평행) (1.1, 1.1) 리턴 
def findIntersection(point1, point2):
    a, b, e = point1[0], point1[1], point1[2]
    c, d, f = point2[0], point2[1], point2[2]

    tmp = a*d - b*c
    
    if tmp != 0:
        cal_x = (b*f - e*d) / tmp
        cal_y = (e*c - a*f) / tmp
        return (cal_x, cal_y)
        
    else:
        return (1.1, 1.1)
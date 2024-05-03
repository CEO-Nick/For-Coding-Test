def solution(numbers, hand):
    answer = ''
    keypad = dict()
    keypad[1] = (0, 3)
    keypad[2] = (1, 3)
    keypad[3] = (2, 3)
    keypad[4] = (0, 2)
    keypad[5] = (1, 2)
    keypad[6] = (2, 2)
    keypad[7] = (0, 1)
    keypad[8] = (1, 1)
    keypad[9] = (2, 1)
    keypad[0] = (1, 0)
    keypad['*'] = (0, 0)
    keypad['#'] = (2, 0)
    
    left_cur = (0, 0)
    right_cur = (2, 0)
    
    for num in numbers:
        if num in [1, 4, 7]:
            answer += 'L'
            left_cur = keypad[num]
        elif num in [3, 6, 9]:
            answer += 'R'
            right_cur = keypad[num]
        else:
            left_diff = abs(keypad[num][0] - left_cur[0]) + abs(keypad[num][1] - left_cur[1])
            right_diff = abs(keypad[num][0] - right_cur[0]) + abs(keypad[num][1] - right_cur[1])
            
            if left_diff < right_diff:
                answer += 'L'
                left_cur = keypad[num]
            elif right_diff < left_diff:
                answer += 'R'
                right_cur = keypad[num]
            else:
                if hand == 'right':
                    answer += 'R'
                    right_cur = keypad[num]
                else: 
                    answer += 'L'
                    left_cur = keypad[num]
                    
    return answer
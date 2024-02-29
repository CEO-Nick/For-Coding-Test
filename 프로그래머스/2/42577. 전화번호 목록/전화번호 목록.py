def solution(phone_book):
    answer = True
    hash_map = {} 
    for phone in phone_book:
        hash_map[phone] = 1
    
    for phone in phone_book:
        arr = ""
        for ch in phone:
            arr += ch
            if arr in hash_map and arr != phone:
                return False
    return answer
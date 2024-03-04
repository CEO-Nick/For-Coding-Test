def solution(genres, plays):
    answer = []
    genre_dict = {} # 장르별 총 재생 횟수
    genre_play_dict = {} # idx별 (장르, 재생 횟수)
    for i in range(len(genres)):
        if genres[i] not in genre_dict:
            genre_dict[genres[i]] = plays[i]
        else:
            genre_dict[genres[i]] += plays[i]
        
        genre_play_dict[i] = (genres[i], plays[i])

    genre_dict = sorted(genre_dict.items(), key = lambda x:-x[1])
    genre_play_dict = sorted(genre_play_dict.items(), key = lambda x:-(x[1][1]))
    
    for genre in genre_dict:
        cnt = 0
        for music in genre_play_dict:
            if genre[0] == music[1][0]:
                cnt+=1
                answer.append(music[0])
            
            if cnt >= 2:
                break
            
    print(genre_dict)
    print(genre_play_dict)
    
    
    return answer
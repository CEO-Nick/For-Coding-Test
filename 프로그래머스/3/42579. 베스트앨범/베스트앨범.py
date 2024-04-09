def solution(genres, plays):
    answer = []
    # 1. 장르 top 2 선택 (속한 노래가 많이 재생된 순)
    # 2. 같은 장르 내에서 재생 수 top 2
    # 3. 같은 장르, 같은 재생 수, 고유 번호 낮은 노래 먼저
    
    genre_hash = dict()         # 장르당 재생 수
    song_genre = dict() # 노래 고유 번호와 장르 연결
    # 1. top 2 장르 고르기
    for i in range(len(genres)):
        # 장르당 재생 수 구하기
        if genres[i] in genre_hash:
            genre_hash[genres[i]] += plays[i]
        else:
            genre_hash[genres[i]] = plays[i]
            
        # 노래 고유 번호와 (장르, 재생 수) 매핑
        song_genre[i] = (genres[i], plays[i])
        
    genre_hash = sorted(genre_hash.items(), key=lambda x:-x[1])
    song_genre = sorted(song_genre.items(), key=lambda x: -x[1][1])
    
    for genre in genre_hash:
        cnt = 0
        for music in song_genre:
            if genre[0] == music[1][0]:
                cnt += 1
                answer.append(music[0])
                
            if cnt >= 2:
                break

        
    return answer
import java.util.*;
class Solution {
    
    public int solution(String[][] relation) {
        int rowSize = relation.length;
        int colSize = relation[0].length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        // 모든 가능한 컬럼 조합을 비트마스크로 표현 (1 << colSize는 2^colSize)
        // 컬럼 4개면 가능한 컬럼 조합 2^4 - 1 = 15개(컬럼 0개 조합은 제외)
        // i = 5 -> 101(2진수) -> 첫 번째 & 세 번째 컬럼 조합을 의미
        for (int i = 1; i < (1 << colSize); i++) {
            // 유일성 체크
            if (isUnique(relation, i, rowSize, colSize)) {
                // 최소성 체크
                boolean isMinimal = true;
                
                // 이미 찾은 모든 후보키에 대해
                for (int key : candidateKeys) {
                    // key & i == key : key에 있는 모든 비트가 i에도 있는지 체크
                    // (즉, key가 i의 부분집합인지) 
                    // ex) i = 1110(2,3,4번째 컬럼 조합), key = 110(2,3번째 컬럼 조합) -> 110 & 1110 = 0110 
                    if ((key & i) == key) {
                        isMinimal = false;
                        break;
                    }
                }
                
                if (isMinimal) {
                    candidateKeys.add(i);
                }
            }
        }
        
        return candidateKeys.size();
    }
    
    // 유일성 검증 함수
    private boolean isUnique(String[][] relation, int keyBit, int rowSize, int colSize) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < rowSize; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < colSize; j++) {
                // j번째 비트가 1인지 확인 (j번째 컬럼이 선택되었는지)
                // keyBit = 101(5) 라면 -> j = 0, 2일 때 if문 수행
                if ((keyBit & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append('#'); // 구분자 추가
                }
            }
            
            // 이미 같은 값이 있다면 유일성 만족 X
            if (set.contains(sb.toString())) {
                return false;
            }
            
            set.add(sb.toString());
        }
        
        return true;
    }
}
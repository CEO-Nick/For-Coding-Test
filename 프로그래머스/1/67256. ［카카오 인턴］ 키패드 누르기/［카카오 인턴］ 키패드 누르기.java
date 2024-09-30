class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftCur = 10, rightCur = 12;
        
        for (int n : numbers) {
            
            switch (n) {
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    leftCur = n;
                    break;
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    rightCur = n;
                    break;
                default:
                    if (n == 0) n = 11;
                    
                    int x = (n-1) / 3, y = (n-1) % 3;
                    int lx = (leftCur-1) / 3, ly = (leftCur-1) % 3;
                    int rx = (rightCur-1) / 3, ry = (rightCur-1) % 3;
                    int distL = Math.abs(lx-x) + Math.abs(ly - y);
                    int distR = Math.abs(rx-x) + Math.abs(ry - y);
                    
                    char tmp = 'a';
                    if (distL < distR) {
                        tmp = 'L';
                        leftCur = n;
                    } else if (distR < distL) {
                        tmp = 'R';
                        rightCur = n;
                    } else {
                        if (hand.equals("left")) {
                            tmp = 'L';
                            leftCur = n;
                        } else {
                            tmp = 'R';
                            rightCur = n;
                        }
                    }
                    sb.append(tmp);
                    break;
            }
        }
        return sb.toString();
    }
}
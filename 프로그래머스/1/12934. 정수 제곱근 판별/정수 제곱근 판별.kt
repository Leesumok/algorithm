class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var x = n
        var y = (x+1) / 2
        
        while(y<x){
            x = y
            y = (x+n /x)/2
        }
        if(x * x == n){
            answer = (x+1)*(x+1)
        }else{
            answer = -1
        }
        return answer
    }
}
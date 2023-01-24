/*
* 백준 2805 - 나무 자르기
* 유형 : binary search, parametric search
* 시도 : 4 try
* 배운 점 : 이분탐색(탐색,lower_bound, upper_bound)의 코드 작성법을 '통일'할 수 있는 방법을 익힘.
* */

import java.io.StreamTokenizer
fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Long {nextToken(); return nval.toLong()}
    val n = i()
    val m = i()
    val arr = LongArray(n.toInt()){i()}

    var left = 0 //오답 원인 : arr 정렬 후 left를 arr[0]-1로 초기값 설정 => 모든 나무를 다 잘라야 하는 경우 놓침.
    var right = 1_000_000_000

    //left<right
    //반복문 탈출 후엔 left+1>=right
    //따라서 left+1=right
    while(left+1<right){
        var mid = (left+right) ushr 1 //int형 overflow를 해결하기 위한 unsigned shift right, 여기선 long형이라 무관

        var sum = 0L
        for(i in arr) {
            sum += maxOf(i-mid, 0)
        }

        //상한선을 찾아내는 과정(l,m,r index)
        //       l       m       r
        //               l   m   r
        //               l m r
        //                 l r
        //arr = [1,2,2,3,3,3,4,5,6]
        //upper_bound(arr,2) => 3
        //
        if(sum >= m){
            left = mid
        } else {
            right = mid
        }
    }

    println(left)
}
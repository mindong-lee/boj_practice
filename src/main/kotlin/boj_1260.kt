import java.io.StreamTokenizer
import java.util.*

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken(); return nval.toInt();}
    val bw = System.out.bufferedWriter()
    val n = i()
    val m = i()
    val v = i()
    val graph = Array(n+1){BooleanArray(n+1)}
    var visited = BooleanArray(n+1)

    repeat(m){
        val s = i()
        val e = i()
        graph[s][e]=true
        graph[e][s]=true
    }

    val stk = Stack<Int>()
    stk.push(v)
    while(!stk.isEmpty()){
        val start = stk.pop()
        if(visited[start]) continue
        visited[start]=true
        bw.write("$start ")
        for(i in n downTo 1){
            if(graph[start][i] && !visited[i]){
                stk.push(i)
            }
        }
    }
    bw.newLine()

    visited = BooleanArray(n+1)
    val queue:Queue<Int> = LinkedList()
    queue.offer(v)
    visited[v]=true
    while(!queue.isEmpty()){
        val start = queue.poll()
        bw.write("$start ")

        for(i in 1..n){
            if(graph[start][i] && !visited[i]){
                queue.offer(i)
                visited[i]=true
            }
        }
    }
    bw.flush()
}

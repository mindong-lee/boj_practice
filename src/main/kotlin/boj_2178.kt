import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val maze = Array(n){readLine()}
    val visited = Array(n){BooleanArray(m)}
    val cost = Array(n){IntArray(m)}
    val queue: Queue<Info> = LinkedList()

    val x = intArrayOf(-1,1,0,0)
    val y = intArrayOf(0,0,-1,1)

    queue.offer(Info(0,0,1))
    visited[0][0]=true

    while(!queue.isEmpty()){
        val pos = queue.poll()
        cost[pos.i][pos.j]=pos.cost

        for(k in 0 until 4){
            val ni = pos.i+x[k]
            val nj = pos.j+y[k]
            if(ni in 0 until n && nj in 0 until m && !visited[ni][nj] && maze[ni][nj]=='1'){
                queue.offer(Info(ni,nj, pos.cost+1))
                visited[ni][nj]=true
            }
        }
    }

    print(cost[n-1][m-1])
}

data class Info(val i: Int, val j: Int, val cost: Int)
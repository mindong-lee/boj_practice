import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = IntArray(20_000_001)

    readLine()
    var st = StringTokenizer(readLine())

    while(st.hasMoreTokens()){
        arr[st.nextToken().toInt()+10_000_000]++
    }

    readLine()
    st = StringTokenizer(readLine())

    while(st.hasMoreTokens()){
        bw.write("${arr[st.nextToken().toInt()+10_000_000]} ")
    }

    bw.flush()
}
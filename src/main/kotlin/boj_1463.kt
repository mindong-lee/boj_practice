import java.io.*
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val arr = IntArray(n+1){it-1}

    for(i in 1 until n){
        if(i+1<=n) arr[i+1] = minOf(arr[i]+1, arr[i+1])
        if(i*2<=n) arr[i*2] = minOf(arr[i]+1, arr[i*2])
        if(i*3<=n) arr[i*3] = minOf(arr[i]+1, arr[i*3])
    }

    bw.write("${arr[n]}")
    bw.flush()
}
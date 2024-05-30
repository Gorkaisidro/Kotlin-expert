import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val res = flow {
        emit(1)
        delay(200)
        emit(2)
    }.filter {it % 2 == 0}

    launch {
        res.collect {
            println(it)
        }
    }

}
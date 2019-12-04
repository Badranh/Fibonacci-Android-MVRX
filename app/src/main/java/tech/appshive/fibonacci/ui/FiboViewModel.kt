package tech.appshive.fibonacci.ui

import com.airbnb.mvrx.*


data class FiboState(@PersistState val curFibValue : Int =0, @PersistState val curStep:Int=0) : MvRxState


class FiboViewModel(initialState: FiboState) : MvRxViewModel<FiboState>(initialState) {

    fun calculateFibStep(step:Int) = setState { copy(curFibValue = fib(step),curStep =  step) }
    //we can inject it , but the purpose in here is to test the mvrx
    private fun fib(n: Int): Int {
        var a = 0
        var b = 1
        var c: Int
        if (n == 0)
            return a
        for (i in 2..n) {
            c = a + b
            a = b
            b = c
        }
        return b
    }
}

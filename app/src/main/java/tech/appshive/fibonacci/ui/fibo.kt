package tech.appshive.fibonacci.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.*
import kotlinx.android.synthetic.main.fibo_fragment.*

import tech.appshive.fibonacci.R

class fibo : BaseMvRxFragment() {
    override fun invalidate() = withState(viewModel) { state ->
        tvFibValue.text = state.curFibValue.toString()
        edtFibStep.setText(state.curStep.toString())
    }

    private val viewModel: FiboViewModel by activityViewModel(FiboViewModel::class)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fibo_fragment,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCalcFib.setOnClickListener{
            viewModel.calculateFibStep(edtFibStep.text.toString().toInt())
        }

    }



}

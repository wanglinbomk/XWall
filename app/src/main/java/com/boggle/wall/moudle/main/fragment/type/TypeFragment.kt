package com.boggle.wall.moudle.main.fragment.type

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boggle.wall.R

class TypeFragment : Fragment() {

    companion object {
        fun newInstance() = TypeFragment()
    }

    private lateinit var viewModel: TypeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.type_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TypeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
package com.example.continentsrecyclereview

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.continentsrecyclereview.databinding.FragmentContinentsBinding


class ContinentsFragment : Fragment(),OnClick {

    private lateinit var adapter: ContinentsAdapter
    private val binding by lazy {
        FragmentContinentsBinding.inflate(layoutInflater)
    }
    private val list = arrayListOf(
        Continent("https://i.pinimg.com/564x/77/f4/f2/77f4f2c2fbbd6dce0cfe34bf951ee801.jpg", "AS"),
        Continent("https://i.pinimg.com/564x/ad/a7/02/ada702c26799e66c002ed85ab76fdd0e.jpg", "SA"),
        Continent("https://i.pinimg.com/236x/f5/de/7a/f5de7a28e2a71d0ad7f7c8171fc2ee55.jpg", "AF"),
        Continent("https://i.pinimg.com/236x/c6/ba/5d/c6ba5d5299b693dcde58f527da437d7c.jpg", "EU")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addData()
    }

    private fun addData() {
        adapter = ContinentsAdapter(list,this@ContinentsFragment)
        binding.rvContinent.adapter = adapter
    }

    override fun onClick(model: Continent) {
        val bundle = Bundle()
        bundle.putSerializable("key", model)
        val intent = Intent(requireContext(), CountryFragment::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
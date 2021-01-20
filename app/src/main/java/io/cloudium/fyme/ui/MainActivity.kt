package io.cloudium.fyme.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import io.cloudium.fyme.databinding.ActivityMainBinding
import io.cloudium.fyme.ui.viewmodels.ContactsViewModel
import io.cloudium.fyme.utils.Resource
import io.cloudium.fyme.utils.Resource.Status.SUCCESS


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ContactsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.contacts.observe(this, Observer {
            when (it.status) {
                SUCCESS -> {
                    if (it.data?.isEmpty() == true) {
                        return@Observer
                    }
                    binding.tvText.setText(it.data?.get(0)?.name)
                    Log.i("--->>", "--" + it.message)
                    binding.progress.visibility = View.GONE
                }
                Resource.Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                }
                Resource.Status.LOADING ->
                    binding.progress.visibility = View.VISIBLE
            }
        })
    }
}
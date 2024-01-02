package com.example.warehousemobile.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.domain.entity.Document
import com.example.domain.entity.TypeOfDocument
import com.example.domain.entity.Warehouse
import com.example.warehousemobile.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLog"
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            mainViewModel.createDocumentWithAll(
                Document(0, "NewDocument", "01112RRR", "", "11.30.2022"),
                Warehouse(0, "KeyOFWarehouse", 0, ""),
                TypeOfDocument(0, "KeyOfDocumentType", 0, "desc")
            )
        }

        lifecycleScope.launch {
            mainViewModel.documentListResponse.collect {
                Log.d(TAG, "onCreate: $it")
            }
        }

//        lifecycleScope.launch {
//            delay(5000)
//            mainViewModel.getDocument()
//
//        }

    }
}
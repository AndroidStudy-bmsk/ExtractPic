package org.bmsk.extractpic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.bmsk.extractpic.databinding.ActivityMainBinding
import org.bmsk.mvc.MvcActivity
import org.bmsk.mvp.MvpActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }

    }

    fun openMvc() {
        startActivity(Intent(this, MvcActivity::class.java))
    }

    fun openMvp() {
        startActivity(Intent(this, MvpActivity::class.java))
    }

    fun openMvvm() {

    }

    fun openMvi() {

    }
}
package th.ac.kku.cis.mobileapp.PlayerList

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import th.ac.kku.cis.mobileapp.PlayerList.databinding.ActivityUserBinding


class UserActivity : AppCompatActivity() {

private  lateinit var  binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("imageId",R.drawable.mano0)


        binding.scodeProfile.text = name
        binding.phoneProfile.text = phone
        binding.profieImage.setImageResource(imageId)
}

}

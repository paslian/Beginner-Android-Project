package com.example.proyek_android_pemula_pasliansahatrafael

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val hero = intent.getParcelableExtra<Character>("HERO_EXTRA")

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val imgSkin1: ImageView = findViewById(R.id.img_skin_1)
        val imgSkin2: ImageView = findViewById(R.id.img_skin_2)
        val imgSkin3: ImageView = findViewById(R.id.img_skin_3)
        val tvHeroName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val tvRelease: TextView = findViewById(R.id.tv_release)
        val tvSpecialist: TextView = findViewById(R.id.tv_specialist)
        val tvLane: TextView = findViewById(R.id.tv_lane)
        val tvSpell: TextView = findViewById(R.id.tv_spell)
        val tvPrice: TextView = findViewById(R.id.tv_price)
        val tvRole: TextView = findViewById(R.id.tv_role)
        val imgItemRecommendation: ImageView = findViewById(R.id.img_item_recomendation)

        Glide.with(this).load(hero?.photo).into(imgPhoto)
        Glide.with(this).load(hero?.imgSkin1).into(imgSkin1)
        Glide.with(this).load(hero?.imgSkin2).into(imgSkin2)
        Glide.with(this).load(hero?.imgSkin3).into(imgSkin3)
        tvHeroName.text = hero?.name
        tvDescription.text = hero?.description
        tvRelease.text = hero?.releaseDate
        tvSpecialist.text = hero?.specialist
        tvLane.text = hero?.lane
        tvSpell.text = hero?.spell
        tvPrice.text = hero?.price
        tvRole.text = hero?.role
        Glide.with(this).load(hero?.imgItemRecommendation).into(imgItemRecommendation)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareContent()
                true
            }

            android.R.id.home -> {
                onBackPressed()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareContent() {
        val imgItemRecommendation: ImageView = findViewById(R.id.img_item_recomendation)
        val itemRecommendation = (imgItemRecommendation.drawable as BitmapDrawable).bitmap

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Shared Item Recommendation")
        shareIntent.putExtra(Intent.EXTRA_STREAM, getBitmapUri(itemRecommendation))
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    private fun getBitmapUri(bitmap: Bitmap): Uri? {
        val bitmapPath = MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Image Description", null)
        return Uri.parse(bitmapPath)
    }
}
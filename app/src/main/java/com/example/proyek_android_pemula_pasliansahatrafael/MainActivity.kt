package com.example.proyek_android_pemula_pasliansahatrafael

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }
    private fun getListHeroes(): ArrayList<Character> {
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataLane = resources.getStringArray(R.array.data_lane)
        val dataSpell = resources.getStringArray(R.array.data_spell_recommendation)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataRelease = resources.getStringArray(R.array.data_release)
        val dataSpecialist = resources.getStringArray(R.array.data_specialist)
        val imgSkin1 = resources.getStringArray(R.array.img_skin_1)
        val imgSkin2 = resources.getStringArray(R.array.img_skin_2)
        val imgSkin3 = resources.getStringArray(R.array.img_skin_3)
        val itemRecommendation = resources.getStringArray(R.array.data_item_recommendation)

        val listHero = ArrayList<Character>()
        for (i in dataName.indices) {
            val hero = Character(dataPhoto[i], dataName[i], dataRole[i], dataDescription[i], dataLane[i],dataSpell[i],dataPrice[i],dataRelease[i],dataSpecialist[i],imgSkin1[i],imgSkin2[i],imgSkin3[i],itemRecommendation[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
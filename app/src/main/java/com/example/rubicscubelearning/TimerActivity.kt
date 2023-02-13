package com.example.rubicscubelearning

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.rubicscubelearning.databinding.ActivityTimerBinding
import java.util.*

class TimerActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTimerBinding
    lateinit var pref:SharedPreferences
    var numberOfAssembly = 0
    lateinit var movements:MutableList<String>
    var chronometerWorking = false
    lateinit var tvUpSide: MutableList<TextView>
    lateinit var tvFrontSide: MutableList<TextView>
    lateinit var tvDownSide: MutableList<TextView>
    lateinit var tvRightSide: MutableList<TextView>
    lateinit var tvBackSide: MutableList<TextView>
    lateinit var tvLeftSide: MutableList<TextView>
    lateinit var tvSides: MutableList<MutableList<TextView>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("ASSEMBLIES", MODE_PRIVATE)
        numberOfAssembly = pref.getInt("numberOfAssembly",1)
        var widthBtNewScramble = binding.CLActivity.width/100
        Glide.with(this)
            .load(R.drawable.new_scramble)
            .override(widthBtNewScramble,widthBtNewScramble)
            .into(binding.btNewScramble)

        tvUpSide = mutableListOf(binding.upSide0,binding.upSide1,binding.upSide2,binding.upSide3,binding.upSide4,binding.upSide5,binding.upSide6,binding.upSide7,binding.upSide8)
        tvFrontSide = mutableListOf(binding.frontSide0,binding.frontSide1,binding.frontSide2,binding.frontSide3,binding.frontSide4,binding.frontSide5,binding.frontSide6,binding.frontSide7,binding.frontSide8)
        tvDownSide = mutableListOf(binding.downSide0,binding.downSide1,binding.downSide2,binding.downSide3,binding.downSide4,binding.downSide5,binding.downSide6,binding.downSide7,binding.downSide8)
        tvRightSide = mutableListOf(binding.rightSide0,binding.rightSide1,binding.rightSide2,binding.rightSide3,binding.rightSide4,binding.rightSide5,binding.rightSide6,binding.rightSide7,binding.rightSide8)
        tvBackSide = mutableListOf(binding.backSide0,binding.backSide1,binding.backSide2,binding.backSide3,binding.backSide4,binding.backSide5,binding.backSide6,binding.backSide7,binding.backSide8)
        tvLeftSide = mutableListOf(binding.leftSide0,binding.leftSide1,binding.leftSide2,binding.leftSide3,binding.leftSide4,binding.leftSide5,binding.leftSide6,binding.leftSide7,binding.leftSide8)
        tvSides = mutableListOf(tvUpSide,tvFrontSide,tvDownSide,tvRightSide,tvBackSide,tvLeftSide)

        newScramble()
        reduceSizeBlocks()

    }

    fun tvChangeSize(view: View){
        if(tvSides[0][0].layoutParams.width == resources.getDimension(R.dimen.blocks_size).toInt()){
            increaseSizeBlocks()
        }
        else{
            reduceSizeBlocks()
        }
    }

    fun reduceSizeBlocks(){
        var i = 0
        var j = 0
        var param = tvFrontSide[4].layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0,resources.getDimension(R.dimen.margin_small_block).toInt(),0,0)
        tvFrontSide[4].layoutParams = param

        while (i<6){
            while (j<9){
                tvSides[i][j].layoutParams.width = resources.getDimension(R.dimen.blocks_size).toInt()
                tvSides[i][j].layoutParams.height = resources.getDimension(R.dimen.blocks_size).toInt()
                tvSides[i][j].requestLayout()
                j++
            }
            i++
            j = 0
        }
        binding.tvChronometer.visibility = View.VISIBLE
    }

    fun increaseSizeBlocks(){
        var i = 0
        var j = 0
        var param = tvFrontSide[4].layoutParams as ViewGroup.MarginLayoutParams
        var marginRight = binding.tvChronometer.width.toDouble()/6
        Log.d("myLog","${binding.tvChronometer.width}")
        Log.d("myLog","$marginRight")
        Log.d("myLog","${marginRight.toInt()}")
        param.setMargins(0,0,marginRight.toInt(),0)
        tvFrontSide[4].layoutParams = param
        while (i<6){
            while (j<9){
                tvSides[i][j].layoutParams.width = resources.getDimension(R.dimen.blocks_size_large).toInt()
                tvSides[i][j].layoutParams.height = resources.getDimension(R.dimen.blocks_size_large).toInt()
                tvSides[i][j].requestLayout()
                j++
            }
            i++
            j = 0
        }
        binding.tvChronometer.visibility = View.GONE
    }

    fun chronometerOnClick(view: View){
        val chronometer = binding.tvChronometer
        var i = 0
        var j = 0
        if(!chronometerWorking) {
            countUpTimer.start()
            chronometerWorking = true
            chronometer.textSize = 100f
            binding.tvScramble.visibility = View.GONE
            binding.btNewScramble.visibility = View.GONE
            while (i<6){
                while (j<9){
                    tvSides[i][j].visibility = View.GONE
                    j++
                }
                i++
                j = 0
            }
        }
        else{
            countUpTimer.cancel()
            saveAssembly()
            chronometerWorking = false
            chronometer.textSize = 80f
            newScramble()

            binding.tvScramble.visibility = View.VISIBLE
            binding.btNewScramble.visibility = View.VISIBLE

            while (i<6){
                while (j<9){
                    tvSides[i][j].visibility = View.VISIBLE
                    j++
                }
                i++
                j = 0
            }
        }
    }

    fun btNewScrambleOnClick(view: View){
        newScramble()
        binding.tvChronometer.text ="0.00"
    }

    fun newScramble(){
        movements = createMovements()
        var tvText = movements.joinToString(separator=" ")
        binding.tvScramble.text = tvText
        drawCube()
    }
    private fun createMovements(): MutableList<String>{
        val rnd = (18..20).random()
        val movements = mutableListOf<String>()
        var rndList: Int
        var lastList = -1
        val movementsLists = listOf(
            listOf("R","R'","R2"),
            listOf("L","L'","L2"),
            listOf("U","U'","U2"),
            listOf("D","D'","D2"),
            listOf("F","F'","F2"),
            listOf("B","B'","B2")
        )
        var i = 0
        while (i < rnd ){
            rndList = (0..5).random()
            if(rndList != lastList){
                movements.add(movementsLists[rndList].random())
                lastList = rndList
                i++
            }
            else i--
        }
        return movements
    }

    fun drawCube(){
        val cube = Cube("WhiteGreen")
        cube.disassembly(movements)
        val white_border = R.drawable.white_border
        val green_border = R.drawable.green_border
        val yellow_border = R.drawable.yellow_border
        val red_border = R.drawable.red_border
        val blue_border = R.drawable.blue_border
        val orange_border = R.drawable.orange_border

        var i = 0
        var j = 0

        while(i<6){
            while(j<9){
                when (cube.sides[i][j]){
                    "up" -> tvSides[i][j].setBackgroundResource(white_border)
                    "front" -> tvSides[i][j].setBackgroundResource(green_border)
                    "down" -> tvSides[i][j].setBackgroundResource(yellow_border)
                    "right" -> tvSides[i][j].setBackgroundResource(red_border)
                    "back" -> tvSides[i][j].setBackgroundResource(blue_border)
                    "left" -> tvSides[i][j].setBackgroundResource(orange_border)
                }
                j++
            }
            i++
            j = 0
        }
    }
    fun saveAssembly(){
        val editor = pref.edit()
        val time = binding.tvChronometer.text.toString()
        editor.putString("assembly$numberOfAssembly",time)
        numberOfAssembly++
        editor.putInt("numberOfAssembly",numberOfAssembly)
        editor.apply()
    }
    val countUpTimer = object: CountUpTimer(600000000, 1) {

        override fun onCount(count: Int) {
            if (count < 100) {
                binding.tvChronometer.text = "0.${count}"
            } else if (count < 6000) {
                if ((count % 100).toString().length == 1) {
                    binding.tvChronometer.text = "${count / 100}.0${count % 100}"
                } else {
                    binding.tvChronometer.text = "${count / 100}.${count % 100}"
                }
            } else {
                if ((count / 100 - 60 * (count / 100 / 60)).toString().length == 1) {
                    if ((count % 100).toString().length == 1) {
                        binding.tvChronometer.text =
                            "${count / 100 / 60}:0${count / 100 - 60 * (count / 100 / 60)}.0${count % 100}"
                    } else {
                        binding.tvChronometer.text =
                            "${count / 100 / 60}:0${count / 100 - 60 * (count / 100 / 60)}.${count % 100}"
                    }
                } else {
                    if ((count % 100).toString().length == 1) {
                        binding.tvChronometer.text =
                            "${count / 100 / 60}:${count / 100 - 60 * (count / 100 / 60)}.0${count % 100}"
                    } else {
                        binding.tvChronometer.text =
                            "${count / 100 / 60}:${count / 100 - 60 * (count / 100 / 60)}.${count % 100}"
                    }
                }
            }
        }
        override fun onFinish() {

        }
    }
}

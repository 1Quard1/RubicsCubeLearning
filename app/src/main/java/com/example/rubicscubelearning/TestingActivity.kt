package com.example.rubicscubelearning

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import com.example.rubicscubelearning.databinding.ActivityTestingBinding

class TestingActivity : AppCompatActivity() {
    lateinit var binding : ActivityTestingBinding
    lateinit var questions: SharedPreferences
    lateinit var answers: SharedPreferences
    var questionNumber = 1
    var numberOfRightAnswers = 0
    var numberOfAnswers = 12
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        questions = getSharedPreferences("QUESTIONSTEST", MODE_PRIVATE)
        answers = getSharedPreferences("ANSWERSTEST", MODE_PRIVATE)
        addTasks()
        setQuestion()
    }

    fun addTasks(){
        var editor = questions.edit()
        editor.putString("question1","Что больше: сумма всех цифр или их произведение?")
        editor.putString("question2","В отеле 4 этажа. Чем выше этаж, тем больше людей там живет. На какой этаж чаще ездит лифт?")
        editor.putString("question3","Телефон вместе с чехлом стоит 110 рублей. Телефон дороже чехла на 100 рублей. Сколько стоит чехол?")
        editor.putString("question4","Аня налила полную чашку чаю и выпила половину. Затем долила чашку доверху молоком. И снова выпила половину. Еще раз долила доверху молоком и выпила все до конца. Чего больше выпила Аня: чаю или молока?")
        editor.putString("question5","Каков шанс того, что на двух кубиках сразу выпадет дубль из шестёрок?")
        editor.putString("question6","Вы переходите по мосту через реку, которая течет справа налево. Все встречные машины едут на север. В каком направлении течет река?")
        editor.putString("question7","В старом доме 9 окон. Если помыть 4 грязных окна, то чистых станет в 2 раза больше, чем грязных. Сколько чистых окон было изначально?")
        editor.putString("question8","Если 1+1=10, то сколько будет 1+10?")
        editor.putString("question9","Сторож Сергей забыл морозным зимним вечером на улице бутылку с водой. Утром на улице было -10 градусов, а вода не замерзла. «Это .... вода», - сделал правильный вывод Сергей. Какое слово должно быть на месте пропуска?")
        editor.putString("question10","Продолжите числовой ряд: 11, 24, 39, 56")
        editor.putString("question11","В междугороднем автобусе 54 пассажирских места. Каждый второй пассажир сдал 1 сумку в багаж. Сколько сумок в багаже, если каждое третье место в автобусе пустое?")
        editor.putString("question12","У Григория было 2 веревки. Первую он разрезал на две части, а вторую - на 5 частей. Из них две части отдал Георгию, одну часть Егору. Сколько разрезов сделал Георгий?")

        editor.apply()
        editor = answers.edit()
        editor.putString("answer11","Сумма")
        editor.putString("answer12","Произведение")
        editor.putString("answer13","Ни что")
        editor.putString("answer14","Не знаю")
        editor.putString("answer1R","Сумма")

        editor.putString("answer21","1 этаж")
        editor.putString("answer22","2 этаж")
        editor.putString("answer23","3 этаж")
        editor.putString("answer24","4 этаж")
        editor.putString("answer2R","1 этаж")

        editor.putString("answer31","5")
        editor.putString("answer32","10")
        editor.putString("answer33","15")
        editor.putString("answer34","20")
        editor.putString("answer3R","5")

        editor.putString("answer41","Молока")
        editor.putString("answer42","Чаю")
        editor.putString("answer43","Одинаково")
        editor.putString("answer44","Не знаю")
        editor.putString("answer4R","Одинаково")

        editor.putString("answer51","1 из 12")
        editor.putString("answer52","1 из 24")
        editor.putString("answer53","1 из 36")
        editor.putString("answer54","1 из 72")
        editor.putString("answer5R","1 из 36")

        editor.putString("answer61","Север")
        editor.putString("answer62","Юг")
        editor.putString("answer63","Запад")
        editor.putString("answer64","Восток")
        editor.putString("answer6R","Восток")

        editor.putString("answer71","4")
        editor.putString("answer72","2")
        editor.putString("answer73","3")
        editor.putString("answer74","6")
        editor.putString("answer7R","2")

        editor.putString("answer81","101")
        editor.putString("answer82","110")
        editor.putString("answer83","11")
        editor.putString("answer84","100")
        editor.putString("answer8R","11")

        editor.putString("answer91","Святая")
        editor.putString("answer92","Газированная")
        editor.putString("answer93","Сладкая")
        editor.putString("answer94","Дистиллированная")
        editor.putString("answer9R","Дистиллированная")

        editor.putString("answer101","68")
        editor.putString("answer102","71")
        editor.putString("answer103","75")
        editor.putString("answer104","83")
        editor.putString("answer10R","75")

        editor.putString("answer111","18")
        editor.putString("answer112","27")
        editor.putString("answer113","36")
        editor.putString("answer114","54")
        editor.putString("answer11R","18")

        editor.putString("answer121","5")
        editor.putString("answer122","7")
        editor.putString("answer123","2")
        editor.putString("answer124","0")
        editor.putString("answer12R","0")

        editor.apply()
    }
    fun setQuestion(){
        binding.tvTaskText.text = questions.getString("question$questionNumber","")
        binding.btAnswer1.text = answers.getString("answer${questionNumber}1","")
        binding.btAnswer2.text = answers.getString("answer${questionNumber}2","")
        binding.btAnswer3.text = answers.getString("answer${questionNumber}3","")
        binding.btAnswer4.text = answers.getString("answer${questionNumber}4","")
        binding.btAnswer1.setBackgroundResource(R.color.red)
        binding.btAnswer2.setBackgroundResource(R.color.red)
        binding.btAnswer3.setBackgroundResource(R.color.red)
        binding.btAnswer4.setBackgroundResource(R.color.red)

    }
    fun checkingAnswer(answerNumber:Int){
        binding.btAnswer1.isClickable = false
        binding.btAnswer2.isClickable = false
        binding.btAnswer3.isClickable = false
        binding.btAnswer4.isClickable = false

        val rightAnswer = answers.getString("answer${questionNumber}R","")
        var answer = ""
        when (answerNumber){
            1 -> answer = binding.btAnswer1.text.toString()
            2 -> answer = binding.btAnswer2.text.toString()
            3 -> answer = binding.btAnswer3.text.toString()
            4 -> answer = binding.btAnswer4.text.toString()
        }
        Log.d("myLog","answer - $answer")
        Log.d("myLog","rightAnswer - $rightAnswer")

        if (answer == rightAnswer){
            numberOfRightAnswers++
            when (answerNumber){
                1 -> binding.btAnswer1.setBackgroundResource(R.color.green)
                2 -> binding.btAnswer2.setBackgroundResource(R.color.green)
                3 -> binding.btAnswer3.setBackgroundResource(R.color.green)
                4 -> binding.btAnswer4.setBackgroundResource(R.color.green)
            }
        }
        else{
            when (answerNumber){
                1 -> binding.btAnswer1.setBackgroundResource(R.color.dark_red)
                2 -> binding.btAnswer2.setBackgroundResource(R.color.dark_red)
                3 -> binding.btAnswer3.setBackgroundResource(R.color.dark_red)
                4 -> binding.btAnswer4.setBackgroundResource(R.color.dark_red)
            }
        }
        val timer = object : CountDownTimer(300,300){
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                binding.btAnswer1.isClickable = true
                binding.btAnswer2.isClickable = true
                binding.btAnswer3.isClickable = true
                binding.btAnswer4.isClickable = true
                nextQuestion()
            }
        }
        timer.start()
    }
    fun nextQuestion(){
        if (questionNumber < numberOfAnswers) {
            questionNumber++
            setQuestion()
        }else{
            setTestingResult()
        }
    }
    fun setTestingResult(){
        binding.tvTaskText.text = "Вы решили $numberOfRightAnswers задач из $numberOfAnswers"
        binding.btAnswer1.text = ""
        binding.btAnswer2.text = ""
        binding.btAnswer3.text = ""
        binding.btAnswer4.text = ""
        binding.btAnswer1.setBackgroundResource(R.color.red)
        binding.btAnswer2.setBackgroundResource(R.color.red)
        binding.btAnswer3.setBackgroundResource(R.color.red)
        binding.btAnswer4.setBackgroundResource(R.color.red)

    }
    fun btAnswer1OnClick(view: View){
        checkingAnswer(1)
    }
    fun btAnswer2OnClick(view: View){
        checkingAnswer(2)
    }
    fun btAnswer3OnClick(view: View){
        checkingAnswer(3)
    }
    fun btAnswer4OnClick(view: View){
        checkingAnswer(4)
    }
    fun btHomeOnClick(view: View){
        val i = Intent(applicationContext, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.putExtra("EXIT", true)
        startActivity(i)
        finish()
    }

}
package com.example.rubicscubelearning

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import com.example.rubicscubelearning.databinding.ActivityLogicTasksBinding

class LogicTasksActivity : AppCompatActivity() {
    lateinit var binding :ActivityLogicTasksBinding
    lateinit var questions: SharedPreferences
    lateinit var answers: SharedPreferences
    var questionNumber = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogicTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        questions = getSharedPreferences("QUESTIONS", MODE_PRIVATE)
        answers = getSharedPreferences("ANSWERS", MODE_PRIVATE)
        addTasks()
        setQuestion()
    }

    fun addTasks(){
        var editor = questions.edit()
        editor.putString("question1","Допустим, вы летите из Москвы во Владивосток, а затем обратно, при полном безветрии. Затем вы совершаете точно такой же перелёт, но на этот раз на протяжении всего перелёта дует постоянный западный ветер: в одну сторону попутный, в обратную - лобовой. Как изменится суммарное время перелёта туда-обратно?")
        editor.putString("question2","У вас есть 50 мотоциклов с полным баком, которого хватает на 100 км езды.\nВопрос: используя все мотоциклы, какое максимальное расстояние вы сможете проехать? Все мотоциклы в начале пути находятся условно в одной точке.")
        editor.putString("question3","1,5 белки за 1,5 минуты поедают 1,5 жёлудя.\nВопрос: сколько желудей за 9 минут съедят 9 белок?")
        editor.putString("question4","Есть треугольник с равными углами. На углах стоят по одному муравью. В какой-то момент муравьи начинают идти в другой угол вдоль стороны треугольника. В какой именно — определяется случайно.\nВопрос: каков шанс того, что ни один муравей не столкнётся с другим муравьём?")
        editor.putString("question5","В книге N страниц, пронумерованных как обычно от 1 до N. Если сложить количество цифр, содержащихся в каждом номере страницы, будет 1095. \nВопрос: Сколько страниц в книге?")
        editor.putString("question6","У скольких целых чисел, лежащих в диапазоне от 1 до 1000, есть цифра 3?")
        editor.apply()
        editor = answers.edit()
        editor.putString("answer11","Уменьшится")
        editor.putString("answer12","Увеличится")
        editor.putString("answer13","Не изменится")
        editor.putString("answer14","Не знаю")
        editor.putString("answer1R","Увеличится")

        editor.putString("answer21","350 км")
        editor.putString("answer22","250 км")
        editor.putString("answer23","200 км")
        editor.putString("answer24","400 км")
        editor.putString("answer2R","350 км")

        editor.putString("answer31","26")
        editor.putString("answer32","56")
        editor.putString("answer33","54")
        editor.putString("answer34","68")
        editor.putString("answer3R","54")

        editor.putString("answer41","100%")
        editor.putString("answer42","50%")
        editor.putString("answer43","33%")
        editor.putString("answer44","25%")
        editor.putString("answer4R","25%")

        editor.putString("answer51","410")
        editor.putString("answer52","401")
        editor.putString("answer53","502")
        editor.putString("answer54","510")
        editor.putString("answer5R","401")

        editor.putString("answer61","273")
        editor.putString("answer62","270")
        editor.putString("answer63","272")
        editor.putString("answer64","271")
        editor.putString("answer6R","271")

        editor.apply()
    }
    fun setQuestion(){
        binding.tvTaskText.text = questions.getString("question$questionNumber","Новые задачи будут добавлены в будущем")
        binding.btAnswer1.text = answers.getString("answer${questionNumber}1","Спасибо")
        binding.btAnswer2.text = answers.getString("answer${questionNumber}2","За")
        binding.btAnswer3.text = answers.getString("answer${questionNumber}3","Решения")
        binding.btAnswer4.text = answers.getString("answer${questionNumber}4","!")
        binding.btAnswer1.setBackgroundResource(R.color.red)
        binding.btAnswer2.setBackgroundResource(R.color.red)
        binding.btAnswer3.setBackgroundResource(R.color.red)
        binding.btAnswer4.setBackgroundResource(R.color.red)

    }
    fun checkingAnswer(answerNumber:Int){
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
                nextQuestion()
            }
        }
        timer.start()
    }
    fun nextQuestion(){
        questionNumber++
        setQuestion()
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
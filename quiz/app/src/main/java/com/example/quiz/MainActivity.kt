package com.example.quiz

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
class MainActivity : AppCompatActivity() {

    private lateinit var controller: QuizController

    private lateinit var questionNumberText: TextView
    private lateinit var questionText: TextView
    private lateinit var answerInput: EditText
    private lateinit var resultText: TextView
    private lateinit var checkButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Controller
        controller = QuizController()

        // View取得
        questionNumberText = findViewById(R.id.textQuestionNumber)
        questionText = findViewById(R.id.textQuestion)
        answerInput = findViewById(R.id.editAnswer)
        resultText = findViewById(R.id.textResult)
        checkButton = findViewById(R.id.buttonCheck)
        nextButton = findViewById(R.id.buttonNext)

        // 初期表示
        updateView()

        // 判定
        checkButton.setOnClickListener {

            val input = answerInput.text.toString()

            if (input.isBlank()) {
                resultText.text = "入力してください"
                return@setOnClickListener
            }

            // 判定
            resultText.text = controller.judge(input)

            // ★ 最終問題なら自動遷移
            if (controller.isLastQuestion()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SCORE", controller.getScore())
                startActivity(intent)
            }
        }

        // 次へ
        nextButton.setOnClickListener {
            if (controller.nextQuestion()) {
                updateView()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SCORE", controller.getScore())
                startActivity(intent)
            }
        }
    }

    // 画面更新まとめ
    private fun updateView() {
        questionText.text = controller.getQuestion()
        questionNumberText.text = "第${controller.getQuestionNumber()}問"
        answerInput.text.clear()
        resultText.text = ""
    }
}
package com.example.quiz

data class Quiz(
    val question: String,
    val answer: String
)

class QuizController {

    private val quizList = listOf(
        Quiz("膃肭臍", "オットセイ"),
        Quiz("海月", "クラゲ"),
        Quiz("海豹", "アザラシ"),
        Quiz("海星", "ヒトデ"),
        Quiz("海胆", "ウニ"),
        Quiz("河豚", "フグ"),
        Quiz("飛蝗", "バッタ"),
        Quiz("蜻蛉", "トンボ"),
        Quiz("蟷螂", "カマキリ"),
        Quiz("蚯蚓", "ミミズ"),
        Quiz("木耳", "キクラゲ"),
        Quiz("土竜", "モグラ"),
        Quiz("山羊", "ヤギ"),
        Quiz("鯱", "シャチ"),
        Quiz("翻車魚", "マンボウ")
    )

    private var currentIndex = 0

    // 問題取得
    fun getQuestion(): String {
        return quizList[currentIndex].question
    }

    // 問番号
    fun getQuestionNumber(): Int {
        return currentIndex + 1
    }

    // 判定（boolean）
    private fun checkAnswer(input: String): Boolean {
        return input == quizList[currentIndex].answer
    }

    // 判定結果（表示用）
    fun getResultText(input: String): String {
        return if (checkAnswer(input)) {
            "○"
        } else {
            "×"
        }
    }

    // 次の問題へ
    fun nextQuestion(): Boolean {
        return if (currentIndex < quizList.size - 1) {
            currentIndex++
            true
        } else {
            false
        }
    }
}
package com.waleed.mvpexample.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.waleed.mvpexample.R
import com.waleed.mvpexample.model.Person
import com.waleed.mvpexample.presenter.CalcAgePresenter
import com.waleed.mvpexample.presenter.ICalcAgePresenter

class MainActivity : AppCompatActivity(), CalcAgePresenter.IMyView {


    private lateinit var editTextTextYear: EditText
    private lateinit var getAgeButton: Button
    private lateinit var textViewAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // خلى بالك
        // المتغير ده بيكون نوعه من الinterface
        //انما باعمل الobject من نوع الpresenter بتاعه
        val iCalcAgePresenter: ICalcAgePresenter = CalcAgePresenter(this)

        editTextTextYear = this.findViewById(R.id.editTextTextYear)
        getAgeButton = this.findViewById(R.id.getAgeButton)
        textViewAge = this.findViewById(R.id.textViewAge)

        getAgeButton.setOnClickListener {

            // بابعت الداتا من الview للpresenter
            iCalcAgePresenter.calcAge(editTextTextYear.text.toString())

        }

    }

    @SuppressLint("SetTextI18n")
    override fun getAgeToView(person: Person) {
        // باستقبل الداتا من ال presenter واعرضها فى الview الخاص بيها
        textViewAge.text = "your age is ${person.age}"
    }
}
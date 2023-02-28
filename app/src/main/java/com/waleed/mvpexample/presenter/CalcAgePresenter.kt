package com.waleed.mvpexample.presenter

import com.waleed.mvpexample.model.Person
import java.util.Calendar

class CalcAgePresenter(private val myView: IMyView) : ICalcAgePresenter {

    override fun calcAge(birthYear: String) {

        val currentYear = Calendar.getInstance().get(Calendar.YEAR)

        val personAge = currentYear - (birthYear.toInt())
        val person = Person(personAge)
        //هنا بابعت الداتا من الpresenter لل view عن طريق ال interface اللى تحت ده
        myView.getAgeToView(person)

    }

    // اقدر اسميه اى اسم لكن خليه اسم واضح ليك
    // ينفع يكون فيه اكتر من function
    interface IMyView {

        fun getAgeToView(person: Person)
    }
}
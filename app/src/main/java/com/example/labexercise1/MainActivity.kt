package com.example.labexercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculation()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clear()
        }



    }

    private fun calculation() {
        val price = findViewById<EditText>(R.id.editTextCarPrice)
        val downPrice = findViewById<EditText>(R.id.editTextDownPayment)
        val period = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val carLoan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

       if(price.text.isBlank() || downPrice.text.isBlank()|| period.text.isBlank() || interestRate.text.isBlank()){
            price.setText(R.string.error_input)
            downPrice.setText(R.string.error_input)
            period.setText(R.string.error_input)
            interestRate.setText(R.string.error_input)
       }else{
           val loanResult =(price.text.toString().toDouble() - downPrice.text.toString().toDouble())
           val interestResult =(loanResult * (interestRate.text.toString().toDouble() / 100 )* period.text.toString().toDouble())
           val paymentResult =((loanResult + interestResult)/period.text.toString().toDouble()/ 12)





           carLoan.setText(carLoan.text.toString().plus("RM").plus(loanResult.toString()))
           interest.setText(interest.text.toString().plus("RM").plus(interestResult.toString()))
           monthlyRepay.setText(monthlyRepay.text.toString().plus("RM").plus(paymentResult.toString()))
       }





    }
    private fun clear() {

        val price = findViewById<EditText>(R.id.editTextCarPrice)
        val downPrice = findViewById<EditText>(R.id.editTextDownPayment)
        val period = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val carLoan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        price.setText("")
        downPrice.setText("")
        period.setText("")
        interestRate.setText("")
        carLoan.setText(R.string.loan)
        interest.setText(R.string.interest)
        monthlyRepay.setText(R.string.monthly_repayment)
    }
}

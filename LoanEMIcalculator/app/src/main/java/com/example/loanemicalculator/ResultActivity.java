package com.example.loanemicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textviewAmountValue, textViewMonthValue,textViewInterestValue, textViewEMIValue, textViewTotalPaymentValue;
    private Button buttonPrevious;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textviewAmountValue = (TextView) findViewById(R.id.textViewAmountValue);
        textViewMonthValue = (TextView) findViewById(R.id.textViewMonthValue);
        textViewInterestValue = (TextView) findViewById(R.id.textViewInterestValue);
        textViewEMIValue = (TextView) findViewById(R.id.textViewEMIValue);
        textViewTotalPaymentValue = (TextView) findViewById(R.id.textViewTotalPaymentValue);
        buttonPrevious=(Button)findViewById(R.id.buttonPrevious);

        LoanCalculations loanobj = (LoanCalculations) getIntent().getSerializableExtra("loanobj");
        textviewAmountValue.setText(""+loanobj.getAmt());
        textViewMonthValue.setText(""+loanobj.getMonths());
        textViewInterestValue.setText(""+loanobj.getInterest());
        textViewEMIValue.setText(""+loanobj.getEmi());
        textViewTotalPaymentValue.setText(""+loanobj.getTotalpayment());

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
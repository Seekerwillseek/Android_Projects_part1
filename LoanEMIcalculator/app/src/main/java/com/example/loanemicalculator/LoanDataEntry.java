package com.example.loanemicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class LoanDataEntry<CharSequences> extends AppCompatActivity {

    private Spinner spinnerloantype;
    private Button buttonProcess, buttonClear, buttonExit;
    SpinnerAdapter Adapter;
    EditText editTextAmount, editTextDuration, editTextProcessingFee, editTextOtherCharges,editTextInterestRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_data_entry);

        spinnerloantype = (Spinner)findViewById(R.id.spinnerloantype);
        EditText editTextAmount=(EditText)findViewById(R.id.editTextAmount);
        EditText editTextDuration=(EditText)findViewById(R.id.editTextDuration);
        EditText editTextProcessingFee=(EditText)findViewById(R.id.editTextProcessingFee);
        EditText editTextOtherCharges=(EditText)findViewById(R.id.editTextOtherCharges);
        EditText editTextInterestRate=(EditText)findViewById(R.id.editTextInterestRate);
        buttonProcess = (Button)findViewById(R.id.buttonProcess);
        buttonClear = (Button)findViewById(R.id.buttonClear);
        buttonExit = (Button)findViewById(R.id.buttonExit);


        ArrayAdapter<CharSequences> adapter = (ArrayAdapter<CharSequences>) ArrayAdapter.createFromResource(this, R.array.loantypes , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerloantype.setAdapter(adapter);

        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amt = 0.00;
                try {

                    amt = Double.parseDouble(editTextAmount.getText().toString());
                } catch (Exception ex) {
                }
                int months = 0;
                try {
                    months = Integer.parseInt(editTextDuration.getText().toString());
                } catch (Exception ex) {
                }
                int type = 1;
                try {

                    type = spinnerloantype.getSelectedItemPosition();
                } catch (Exception ex) {}
                double rate=0.00;
                try{
                    rate=Double.parseDouble(editTextInterestRate.getText().toString());
                }catch(Exception ex){}

                double proc_fee=0.00;
                try{
                    proc_fee=Double.parseDouble(editTextProcessingFee.getText().toString());
                }catch(Exception ex){}

                double other_fee=0.00;
                try{
                    other_fee=Double.parseDouble(editTextOtherCharges.getText().toString());
                }catch(Exception ex){}

                LoanCalculations loanobj = new LoanCalculations(amt,months,type,rate,proc_fee,other_fee);
                Intent third = new Intent(LoanDataEntry.this,ResultActivity.class);
                third.putExtra("loanobj", loanobj);
                startActivity(third);

             }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerloantype.setSelection(0);
                editTextAmount.setText("0.00");
                editTextDuration.setText("0.00");
                editTextInterestRate.setText("0.00");
                editTextProcessingFee.setText("0.00");
                editTextOtherCharges.setText("0.00");
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
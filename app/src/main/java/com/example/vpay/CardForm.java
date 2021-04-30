package com.example.vpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;


public class CardForm extends AppCompatActivity {
    TextInputLayout card_no, expiry_month, expiry_year, cvv_no, amount, customer_name, mobile_no;
    Button create_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_form);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        card_no = (TextInputLayout) findViewById(R.id.card_no);
        expiry_month = (TextInputLayout) findViewById(R.id.expiry_month);
        expiry_year = (TextInputLayout) findViewById(R.id.expiry_year);
        cvv_no = (TextInputLayout) findViewById(R.id.cvv_no);
        amount = (TextInputLayout) findViewById(R.id.amount);
        customer_name = (TextInputLayout) findViewById(R.id.customer_name);
        mobile_no = (TextInputLayout) findViewById(R.id.mobile_no);

        create_card = (Button) findViewById(R.id.create_card);

        create_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert(  card_no.getEditText().getText().toString(),
                        expiry_month.getEditText().getText().toString(),
                        expiry_year.getEditText().getText().toString(),
                        cvv_no.getEditText().getText().toString(),
                        amount.getEditText().getText().toString(),
                        customer_name.getEditText().getText().toString(),
                        mobile_no.getEditText().getText().toString());
            }
        });

    }

    private void processinsert(String card, String month, String year, String cvv, String amount1, String name, String mobile)
    {
        String res = new dbmanager(this).addrecord(card, month, year, cvv, amount1, name, mobile);

        card_no.getEditText().setText("");
        expiry_month.getEditText().setText("");
        expiry_year.getEditText().setText("");
        cvv_no.getEditText().setText("");
        amount.getEditText().setText("");
        customer_name.getEditText().setText("");
        mobile_no.getEditText().setText("");

        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }
}
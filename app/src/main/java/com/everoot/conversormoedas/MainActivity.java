package com.everoot.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textDollar = (TextView) findViewById(R.id.text_dollar);
        this.mViewHolder.editValue = (EditText) findViewById(R.id.edit_value);
        this.mViewHolder.textEuro = (TextView) findViewById(R.id.text_euro);
        this.mViewHolder.btnCalculate = (Button) findViewById(R.id.btn_calculate);

        this.mViewHolder.btnCalculate.setOnClickListener(this);

        this.clearTexts();

    }

    private void clearTexts() {
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textDollar.setText("");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_calculate){
            Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
            this.mViewHolder.textDollar.setText(String.format("%.2f", value * 3.2));
            this.mViewHolder.textEuro.setText(String.format("%.2f", value * 4.3));
        }
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button btnCalculate;
    }

}

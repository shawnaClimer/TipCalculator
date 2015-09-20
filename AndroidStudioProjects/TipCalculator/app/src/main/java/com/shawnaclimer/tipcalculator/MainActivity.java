package com.shawnaclimer.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editBill;
    private Button btn10;
    private Button btn20;
    private Button btn25;
    private Button btn30;
    private TextView tipDoll;
    private TextView billTotal;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editBill = (EditText) findViewById(R.id.editBill);
        btn10 = (Button) findViewById(R.id.btn10);
        btn20 = (Button) findViewById(R.id.btn20);
        btn25 = (Button) findViewById(R.id.btn25);
        btn30 = (Button) findViewById(R.id.btn30);
        tipDoll = (TextView) findViewById(R.id.tip);
        billTotal = (TextView) findViewById(R.id.total);
        message = (TextView) findViewById(R.id.message);

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bill = Double.parseDouble(editBill.getText().toString());
                double tip = bill * .10;
                double total = bill + tip;
                tipDoll.setText(new DecimalFormat("#.##").format(tip));
                billTotal.setText(new DecimalFormat("#.##").format(total));
                message.setText(R.string.service_10);

            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bill = Double.parseDouble(editBill.getText().toString());
                double tip = bill * .20;
                if(tip<5.00) {
                    tip = 5.00;
                    Toast.makeText(MainActivity.this, "Minimum tip $5.00", Toast.LENGTH_LONG).show();
                }
                double total = bill + tip;
                tipDoll.setText(new DecimalFormat("#.##").format(tip));
                billTotal.setText(new DecimalFormat("#.##").format(total));
                message.setText(R.string.service_20);

            }
        });
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bill = Double.parseDouble(editBill.getText().toString());
                double tip = bill * .25;
                if(tip<5.00) {
                    tip = 5.00;
                    Toast.makeText(MainActivity.this, "Minimum tip $5.00", Toast.LENGTH_LONG).show();
                }
                double total = bill + tip;
                tipDoll.setText(new DecimalFormat("#.##").format(tip));
                billTotal.setText(new DecimalFormat("#.##").format(total));
                message.setText(R.string.service_25);

            }
        });
        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bill = Double.parseDouble(editBill.getText().toString());
                double tip = bill * .30;
                if(tip<5.00) {
                    tip = 5.00;
                    Toast.makeText(MainActivity.this, R.string.minimum_tip, Toast.LENGTH_LONG).show();
                }
                double total = bill + tip;
                tipDoll.setText(new DecimalFormat("#.##").format(tip));
                billTotal.setText(new DecimalFormat("#.##").format(total));
                message.setText(R.string.service_30);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

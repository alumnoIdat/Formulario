package com.example.chango.formulario;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.chango.formulario.R.id.checkbox;
import static com.example.chango.formulario.R.id.ratingBar;
import static com.example.chango.formulario.R.id.toggleButton;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button2) protected Button send;
    @BindView(R.id.editText) protected EditText edittext;
    @BindView(R.id.textView4) protected TextView etiqueta1;
    @BindView(R.id.checkBox) protected CheckBox checkbox;
    @BindView(R.id.toggleButton) protected ToggleButton togglebutton;
    @BindView(R.id.radioButton) protected RadioButton radio_red;
    @BindView(R.id.radioButton2) protected RadioButton radio_blue;
    @BindView(R.id.ratingBar) protected RatingBar ratingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        ButterKnife.bind(this);
        etiqueta1.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Presionaste por laaaargo tiempo edittext4", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        ratingbar.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int eid = event.getAction();
                switch (eid) {
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(getApplicationContext(), "Estas moviendouna estrella", Toast.LENGTH_LONG).show();
                        break;
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(getApplicationContext(), "Presionaste una estrella", Toast.LENGTH_LONG).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(getApplicationContext(), "Soltaste una estrella", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
    }

    @OnClick(R.id.button)
    public void onClick(View v) {
        finish();
    }

    public void sendClick(View v) {
// Perform action on clicks
        String allText = new String("campo:" + edittext.getText());
        allText = allText + ":checkbox:";
        if (checkbox.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }

        allText = allText + ":toggle:";
        if (togglebutton.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }

        allText = allText + "radios:rojo:";
        String redtext = "";
        if (radio_red.isChecked()) {
            redtext = "pulsado:";
        } else {
            redtext = "no pulsado:";
        }

        allText = allText + redtext;
        allText = allText + "azul";
        String bluetext = "";
        if (radio_blue.isChecked()) {
            bluetext = "pulsado:";
        } else {
            bluetext = "no pulsado:";
        }

        allText = allText + bluetext;
        allText = allText + "rating:";
        float f = ratingbar.getRating();
        allText = allText + Float.toString(f) + ":";
        Log.d("app",allText);
        Toast.makeText(getApplicationContext(), allText, Toast.LENGTH_LONG).show();
    }

    public void checkBoxClick(View view){
        String text = "";
        if (checkbox.isChecked()) {
            text = "Selected";
            send.setEnabled(true);
            Toast.makeText(getApplicationContext(),"Ya puedes Salvar", Toast.LENGTH_LONG).show();
        } else {
            send.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Hasta que no marques la casilla no podrás salvar",Toast.LENGTH_LONG).show();
            text = "Not selected";
        }
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void radioClick(View view){
        Toast toast;
        if (radio_blue.isChecked()) {
            toast = Toast.makeText(getApplicationContext(), "AZUL", Toast.LENGTH_SHORT);
            toast.getView().setBackgroundColor(Color.BLUE);
            toast.show();
        } else if(radio_red.isChecked()){
            toast = Toast.makeText(getApplicationContext(), "ROJO", Toast.LENGTH_SHORT);
            toast.getView().setBackgroundColor(Color.RED);
            toast.show();
        }
    }

    public void toggleClick(View view){
        Toast.makeText(getApplicationContext(), togglebutton.getText(), Toast.LENGTH_LONG).show();
    }

}

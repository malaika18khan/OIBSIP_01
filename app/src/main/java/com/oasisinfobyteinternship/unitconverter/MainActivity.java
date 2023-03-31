package com.oasisinfobyteinternship.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner unit_sp_first, unit_sp_sec;
    String[] units = { "meter", "mile", "yard", "foot", "inch"};
    double input_val, result_val;
    EditText first_et, second_et;
    double miles = 1609;
    double yard = 1.094;
    double foot = 3.281;
    double inch = 39.37;
    double mile_to_yard = 1760;
    double mile_to_foot = 5280;
    double mile_to_inch = 63360;
    double yard_to_foot = 3;
    double yard_to_inch = 36;
    double foot_to_inch = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit_sp_first = findViewById(R.id.first_spinner);
        unit_sp_sec = findViewById(R.id.second_spinner);
        first_et = findViewById(R.id.input_value_et);
        second_et = findViewById(R.id.result_value_et);

        unit_sp_first.setOnItemSelectedListener(this);
        unit_sp_sec.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the units list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, units);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        unit_sp_first.setAdapter(aa);
        unit_sp_sec.setAdapter(aa);

        result_val = Integer.parseInt(second_et.getText().toString());

            first_et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    if(first_et.getText().toString().equals("")){
                        second_et.setText("");
                    }

                    else if (unit_sp_first.getSelectedItem().toString() == "meter") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            meterToMiles(first_et, second_et);
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            meterToYard();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            meterToFoot();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            meterToInch();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            sameUnit(first_et, second_et);
                        }
                    }

                    else if (unit_sp_first.getSelectedItem().toString() == "mile") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            sameUnit(first_et, second_et);
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            mileToYard();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            mileToFoot();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            mileToInch();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            mileToMeter(first_et, second_et);
                        }
                    }
                    else if (unit_sp_first.getSelectedItem().toString() == "yard") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            yardToMile();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            sameUnit(first_et, second_et);
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            yardToFoot();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            yardToInch();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            yardToMeter();
                        }
                    }
                    else if (unit_sp_first.getSelectedItem().toString() == "foot") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            footToMile();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            footToYard();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            sameUnit(first_et, second_et);
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            footToInch();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            footToMeter();
                        }
                    }
                    else if (unit_sp_first.getSelectedItem().toString() == "inch") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            inchToMile();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            inchToYard();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            inchToFoot();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            sameUnit(first_et, second_et);
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            inchToMeter();
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

            second_et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                    if(second_et.getText().toString().equals("")){
//                        first_et.setText("");
//                    }
//
//                    else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
//                        if (unit_sp_first.getSelectedItem().toString() == "mile") {
//                            meterToMiles(second_et,first_et);
//                        } else if (unit_sp_first.getSelectedItem().toString() == "yard") {
//                            meterToYard();
//                        } else if (unit_sp_first.getSelectedItem().toString() == "foot") {
//                            meterToFoot();
//                        } else if (unit_sp_first.getSelectedItem().toString() == "inch") {
//                            meterToInch();
//                        } else if (unit_sp_first.getSelectedItem().toString() == "meter") {
//                            sameUnit(second_et, first_et);
//                        }
//                    }
//
//                    else if (unit_sp_sec.getSelectedItem().toString() == "mile") {
//                        if (unit_sp_first.getSelectedItem().toString() == "mile") {
//                            sameUnit(second_et, first_et);
//                        } else if (unit_sp_first.getSelectedItem().toString() == "yard") {
//                            mileToYard();
//                        } else if (unit_sp_first.getSelectedItem().toString() == "foot") {
//                            mileToFoot();
//                        } else if (unit_sp_first.getSelectedItem().toString() == "inch") {
//                            mileToInch();
//                        } else if (unit_sp_first.getSelectedItem().toString() == "meter") {
//                            mileToMeter(second_et, first_et);
//                        }
                    //}
//                    else if (unit_sp_first.getSelectedItem().toString() == "yard") {
//                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
//                            yardToMile();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
//                            sameUnit(first_et, second_et);
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
//                            yardToFoot();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
//                            yardToInch();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
//                            yardToMeter();
//                        }
//                    }
//                    else if (unit_sp_first.getSelectedItem().toString() == "foot") {
//                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
//                            footToMile();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
//                            footToYard();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
//                            sameUnit(first_et, second_et);
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
//                            footToInch();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
//                            footToMeter();
//                        }
//                    }
//                    else if (unit_sp_first.getSelectedItem().toString() == "inch") {
//                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
//                            inchToMile();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
//                            inchToYard();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
//                            inchToFoot();
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
//                            sameUnit(first_et, second_et);
//                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
//                            inchToMeter();
////                        }
//                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (unit_sp_first.getSelectedItem().toString() == "meter") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                meterToMiles(first_et,second_et);
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                meterToYard();
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                meterToFoot();
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                meterToInch();
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                sameUnit(first_et, second_et);
            }
        }

        else if (unit_sp_first.getSelectedItem().toString() == "mile") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                sameUnit(first_et, second_et);
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                mileToYard();
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                mileToFoot();
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                mileToInch();
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                mileToMeter(first_et, second_et);
            }
        }
        else if (unit_sp_first.getSelectedItem().toString() == "yard") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                yardToMile();
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                sameUnit(first_et, second_et);
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                yardToFoot();
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                yardToInch();
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                yardToMeter();

            }
        }
        else if (unit_sp_first.getSelectedItem().toString() == "foot") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                footToMile();
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                footToYard();
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                sameUnit(first_et, second_et);
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                footToInch();
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                footToMeter();
            }
        }
        else if (unit_sp_first.getSelectedItem().toString() == "inch") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                inchToMile();
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                inchToYard();
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                inchToFoot();
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                sameUnit(first_et,second_et);
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                inchToMeter();
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void sameUnit(EditText focus_et, EditText result_et){
        result_val = Integer.parseInt(focus_et.getText().toString());
        result_et.setText(String.valueOf(result_val));
    }

    public void meterToMiles(EditText focus_et, EditText result_et){
        result_val = Integer.parseInt(focus_et.getText().toString()) / miles;
        result_et.setText(String.valueOf(result_val));
    }

    public void meterToYard(){
        result_val = Integer.parseInt(first_et.getText().toString()) * yard;
        second_et.setText(String.valueOf(result_val));
    }

    public void meterToFoot(){
        result_val = Integer.parseInt(first_et.getText().toString()) * foot;
        second_et.setText(String.valueOf(result_val));
    }

    public void meterToInch(){
        result_val = Integer.parseInt(first_et.getText().toString()) * inch;
        second_et.setText(String.valueOf(result_val));
    }

    public void mileToMeter(EditText focus_et, EditText result_et){
        result_val = Integer.parseInt(focus_et.getText().toString()) * miles;
        result_et.setText(String.valueOf(result_val));
    }

    public void mileToYard(){
        result_val = Integer.parseInt(first_et.getText().toString()) * mile_to_yard;
        second_et.setText(String.valueOf(result_val));
    }

    public void mileToFoot(){
        result_val = Integer.parseInt(first_et.getText().toString()) * mile_to_foot;
        second_et.setText(String.valueOf(result_val));
    }

    public void mileToInch(){
        result_val = Integer.parseInt(first_et.getText().toString()) * mile_to_inch;
        second_et.setText(String.valueOf(result_val));
    }

    public void yardToMile(){
        result_val = Integer.parseInt(first_et.getText().toString()) / mile_to_yard;
        second_et.setText(String.valueOf(result_val));
    }

    public void yardToFoot(){
        result_val = Integer.parseInt(first_et.getText().toString()) * yard_to_foot;
        second_et.setText(String.valueOf(result_val));
    }

    public void yardToInch(){
        result_val = Integer.parseInt(first_et.getText().toString()) * yard_to_inch;
        second_et.setText(String.valueOf(result_val));
    }

    public void yardToMeter(){
        result_val = Integer.parseInt(first_et.getText().toString()) / yard;
        second_et.setText(String.valueOf(result_val));
    }

    public void footToMile(){
        result_val = Integer.parseInt(first_et.getText().toString()) / mile_to_foot;
        second_et.setText(String.valueOf(result_val));
    }

    public void footToYard(){
        result_val = Integer.parseInt(first_et.getText().toString()) / yard_to_foot;
        second_et.setText(String.valueOf(result_val));
    }

    public void footToInch(){
        result_val = Integer.parseInt(first_et.getText().toString()) * foot_to_inch;
        second_et.setText(String.valueOf(result_val));
    }

    public void footToMeter(){
        result_val = Integer.parseInt(first_et.getText().toString()) / foot;
        second_et.setText(String.valueOf(result_val));
    }

    public void inchToMile(){
        result_val = Integer.parseInt(first_et.getText().toString()) / mile_to_inch;
        second_et.setText(String.valueOf(result_val));
    }

    public void inchToYard(){
        result_val = Integer.parseInt(first_et.getText().toString()) / yard_to_inch;
        second_et.setText(String.valueOf(result_val));
    }

    public void inchToFoot(){
        result_val = Integer.parseInt(first_et.getText().toString()) / foot_to_inch;
        second_et.setText(String.valueOf(result_val));
    }

    public void inchToMeter(){
        result_val = Integer.parseInt(first_et.getText().toString()) / inch;
        second_et.setText(String.valueOf(result_val));
    }

}
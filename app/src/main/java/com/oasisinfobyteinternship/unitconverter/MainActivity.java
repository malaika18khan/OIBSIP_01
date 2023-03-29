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
    EditText in_val, res_val;
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
        in_val = findViewById(R.id.input_value_et);
        res_val = findViewById(R.id.result_value_et);

        unit_sp_first.setOnItemSelectedListener(this);
        unit_sp_sec.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the units list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, units);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        unit_sp_first.setAdapter(aa);
        unit_sp_sec.setAdapter(aa);

        result_val = Integer.parseInt(res_val.getText().toString());

            in_val.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    if(in_val.getText().toString().equals("")){
                        res_val.setText("");
                    }

                    else if (unit_sp_first.getSelectedItem().toString() == "meter") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            meterToMiles();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            meterToYard();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            meterToFoot();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            meterToInch();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            sameUnit();
                        }
                    }

                    else if (unit_sp_first.getSelectedItem().toString() == "mile") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            sameUnit();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            mileToYard();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            mileToFoot();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            mileToInch();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            mileToMeter();
                        }
                    }
                    else if (unit_sp_first.getSelectedItem().toString() == "yard") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            yardToMile();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            sameUnit();
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
                            sameUnit();
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
                            sameUnit();
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            inchToMeter();
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

            res_val.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

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
                meterToMiles();
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                meterToYard();
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                meterToFoot();
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                meterToInch();
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                sameUnit();
            }
        }

        else if (unit_sp_first.getSelectedItem().toString() == "mile") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                sameUnit();
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                mileToYard();
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                mileToFoot();
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                mileToInch();
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                mileToMeter();
            }
        }
        else if (unit_sp_first.getSelectedItem().toString() == "yard") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                yardToMile();
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                sameUnit();
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
                sameUnit();
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
                sameUnit();
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                inchToMeter();
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void sameUnit(){
        result_val = Integer.parseInt(in_val.getText().toString());
        res_val.setText(String.valueOf(result_val));
    }

    public void meterToMiles(){
        result_val = Integer.parseInt(in_val.getText().toString()) / miles;
        res_val.setText(String.valueOf(result_val));
    }

    public void meterToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) * yard;
        res_val.setText(String.valueOf(result_val));
    }

    public void meterToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) * foot;
        res_val.setText(String.valueOf(result_val));
    }

    public void meterToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * inch;
        res_val.setText(String.valueOf(result_val));
    }

    public void mileToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) * miles;
        res_val.setText(String.valueOf(result_val));
    }

    public void mileToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) * mile_to_yard;
        res_val.setText(String.valueOf(result_val));
    }

    public void mileToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) * mile_to_foot;
        res_val.setText(String.valueOf(result_val));
    }

    public void mileToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * mile_to_inch;
        res_val.setText(String.valueOf(result_val));
    }

    public void yardToMile(){
        result_val = Integer.parseInt(in_val.getText().toString()) / mile_to_yard;
        res_val.setText(String.valueOf(result_val));
    }

    public void yardToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) * yard_to_foot;
        res_val.setText(String.valueOf(result_val));
    }

    public void yardToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * yard_to_inch;
        res_val.setText(String.valueOf(result_val));
    }

    public void yardToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) / yard;
        res_val.setText(String.valueOf(result_val));
    }

    public void footToMile(){
        result_val = Integer.parseInt(in_val.getText().toString()) / mile_to_foot;
        res_val.setText(String.valueOf(result_val));
    }

    public void footToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) / yard_to_foot;
        res_val.setText(String.valueOf(result_val));
    }

    public void footToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * foot_to_inch;
        res_val.setText(String.valueOf(result_val));
    }

    public void footToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) / foot;
        res_val.setText(String.valueOf(result_val));
    }

    public void inchToMile(){
        result_val = Integer.parseInt(in_val.getText().toString()) / mile_to_inch;
        res_val.setText(String.valueOf(result_val));
    }

    public void inchToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) / yard_to_inch;
        res_val.setText(String.valueOf(result_val));
    }

    public void inchToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) / foot_to_inch;
        res_val.setText(String.valueOf(result_val));
    }

    public void inchToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) / inch;
        res_val.setText(String.valueOf(result_val));
    }

}
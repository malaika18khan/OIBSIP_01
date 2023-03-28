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

        //input_val = Integer.parseInt(in_val.getText().toString());

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
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            meterToYard();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            meterToFoot();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            meterToInch();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            sameUnit();
                            res_val.setText(String.valueOf(result_val));
                        }
                    }

                    else if (unit_sp_first.getSelectedItem().toString() == "mile") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            sameUnit();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            mileToYard();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            mileToFoot();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            mileToInch();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            mileToMeter();
                            res_val.setText(String.valueOf(result_val));
                        }
                    }
                    else if (unit_sp_first.getSelectedItem().toString() == "yard") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            yardToMile();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            sameUnit();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            yardToFoot();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            yardToInch();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            yardToMeter();
                            res_val.setText(String.valueOf(result_val));
                        }
                    }
                    else if (unit_sp_first.getSelectedItem().toString() == "foot") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            footToMile();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            footToYard();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            sameUnit();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            footToInch();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            footToMeter();
                            res_val.setText(String.valueOf(result_val));
                        }
                    }
                    else if (unit_sp_first.getSelectedItem().toString() == "inch") {
                        if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                            inchToMile();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                            inchToYard();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                            inchToFoot();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                            sameUnit();
                            res_val.setText(String.valueOf(result_val));
                        } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                            inchToMeter();
                            res_val.setText(String.valueOf(result_val));
                        }
                    }
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
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                meterToYard();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                meterToFoot();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                meterToInch();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                sameUnit();
                res_val.setText(String.valueOf(result_val));
            }
        }

        else if (unit_sp_first.getSelectedItem().toString() == "mile") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                sameUnit();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                mileToYard();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                mileToFoot();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                mileToInch();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                mileToMeter();
                res_val.setText(String.valueOf(result_val));
            }
        }
        else if (unit_sp_first.getSelectedItem().toString() == "yard") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                yardToMile();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                sameUnit();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                yardToFoot();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                yardToInch();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                yardToMeter();
                res_val.setText(String.valueOf(result_val));
            }
        }
        else if (unit_sp_first.getSelectedItem().toString() == "foot") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                footToMile();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                footToYard();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                sameUnit();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                footToInch();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                footToMeter();
                res_val.setText(String.valueOf(result_val));
            }
        }
        else if (unit_sp_first.getSelectedItem().toString() == "inch") {
            if (unit_sp_sec.getSelectedItem().toString() == "mile") {
                inchToMile();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "yard") {
                inchToYard();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "foot") {
                inchToFoot();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "inch") {
                sameUnit();
                res_val.setText(String.valueOf(result_val));
            } else if (unit_sp_sec.getSelectedItem().toString() == "meter") {
                inchToMeter();
                res_val.setText(String.valueOf(result_val));
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void sameUnit(){
        result_val = Integer.parseInt(in_val.getText().toString());
    }

    public void meterToMiles(){
        result_val = Integer.parseInt(in_val.getText().toString()) / miles;
    }

    public void meterToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) * yard;
    }

    public void meterToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) * foot;
    }

    public void meterToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * inch;
    }

    public void mileToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) * miles;
    }

    public void mileToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) * mile_to_yard;
    }

    public void mileToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) * mile_to_foot;
    }

    public void mileToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * mile_to_inch;
    }

    public void yardToMile(){
        result_val = Integer.parseInt(in_val.getText().toString()) / mile_to_yard;
    }

    public void yardToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) * yard_to_foot;
    }

    public void yardToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * yard_to_inch;
    }

    public void yardToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) / yard;
    }

    public void footToMile(){
        result_val = Integer.parseInt(in_val.getText().toString()) / mile_to_foot;
    }

    public void footToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) / yard_to_foot;
    }

    public void footToInch(){
        result_val = Integer.parseInt(in_val.getText().toString()) * foot_to_inch;
    }

    public void footToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) / foot;
    }

    public void inchToMile(){
        result_val = Integer.parseInt(in_val.getText().toString()) / mile_to_inch;
    }

    public void inchToYard(){
        result_val = Integer.parseInt(in_val.getText().toString()) / yard_to_inch;
    }

    public void inchToFoot(){
        result_val = Integer.parseInt(in_val.getText().toString()) / foot_to_inch;
    }

    public void inchToMeter(){
        result_val = Integer.parseInt(in_val.getText().toString()) / inch;
    }

}
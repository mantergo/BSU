package com.example.paul.calculator1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,scomma,splus,sminus,smultiply,sdivide,sequal,sclear,sclearall;
    EditText et;
    double val1,val2;
    boolean add,sub,div,mul;

    public String removeLastChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length()-1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=(Button) findViewById(R.id.n1);
        n2=(Button) findViewById(R.id.n2);
        n3=(Button) findViewById(R.id.n3);
        n4=(Button) findViewById(R.id.n4);
        n5=(Button) findViewById(R.id.n5);
        n6=(Button) findViewById(R.id.n6);
        n7=(Button) findViewById(R.id.n7);
        n8=(Button) findViewById(R.id.n8);
        n9=(Button) findViewById(R.id.n9);
        n0=(Button) findViewById(R.id.n0);
        scomma=(Button) findViewById(R.id.scomma);
        splus=(Button) findViewById(R.id.splus);
        sminus=(Button) findViewById(R.id.sminus);
        smultiply=(Button) findViewById(R.id.smultiply);
        sdivide=(Button) findViewById(R.id.sdivide);
        sequal=(Button) findViewById(R.id.sequal);
        sclear=(Button) findViewById(R.id.sclear);
        sclearall=(Button) findViewById(R.id.sclearall);
        et=(EditText) findViewById(R.id.editText1);

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"1");
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"2");
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"3");
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"4");
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"5");
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"6");
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"7");
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"8");
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"9");
            }
        });

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"0");
            }
        });
        scomma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + ".");
            }
        });

        splus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "+");
            }
        });

        sminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "-");
            }
        });

        sdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "÷");
            }
        });
        smultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText() + "x");
            }
        });
        sclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(removeLastChar(et.toString()));
            }
        });

        System.out.print(removeLastChar(et.toString()));

        sclearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
            }
        });


        splus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(et.getText() + "");
                add = true;
                et.setText(null);
            }
        });
        sminus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                val1 = Double.parseDouble(et.getText() + "");
                sub = true;
                et.setText(null);
            }
        });
        sdivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                val1=Double.parseDouble(et.getText() + "");
                div=true;
                et.setText(null);
            }
        });
        smultiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                val1=Double.parseDouble(et.getText()+"");
                mul=true;
                et.setText(null);
            }
        });



        sequal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                val2=Double.parseDouble(et.getText()+"");
                if (add==true)
                    {
                        if (val1+val2==1383)
                        {
                            et.setText("");
                        }
                        else {
                            et.setText(val1 + val2 + "");
                            add = false;
                        }
                    }

                if (sub==true)
                {
                    if(val1-val2==1383)
                    {
                        et.setText("");
                    }
                    else
                    {
                        et.setText(val1 - val2 + "");
                        sub = false;
                    }
                }
                if (mul==true) {


                        et.setText(val1 * val2 + "");
                        mul = false;

                }
                if (div==true) {
                    et.setText(val1/val2+"");
                    div=false;
                }
            }

        });




    }
}

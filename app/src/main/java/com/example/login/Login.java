package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login, pass;
    Intent i;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    //METODO
    public void fazLogin(View v){
        String log,senha;
        login = findViewById(R.id.loginctxlogin);
        log = login.getText().toString();
        pass = findViewById(R.id.loginctxpass);
        senha = pass.getText().toString();
            if(log.isEmpty() || senha.isEmpty()){
                Toast.makeText(this, "Preencha os campos do login", Toast.LENGTH_SHORT).show();
            }
            else{
                //FAZER VALIDAÇÃO NA BASE DE DADOS
            }
        }

    public void fazRegistro(View v){
        i = new Intent(Login.this,Registro.class);
        startActivity(i);
        finish();
    }

}
package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText login, pass, repass,email;
    Intent i;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void fazLogin(View v){

        String log,resenha,mail,senha;
        login = findViewById(R.id.registroctxlogin);
        log = login.getText().toString();
        pass = findViewById(R.id.registroctxpass);
        senha = pass.getText().toString();
        repass = findViewById(R.id.registroctxrepass);
        resenha = repass.getText().toString();
        email = findViewById(R.id.registroctxemail);
        mail = email.getText().toString();
        if(log.isEmpty() || senha.isEmpty()){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();    }
        else if(!senha.equals(resenha)){
            Toast.makeText(this, "Os campos password têm que coincidir", Toast.LENGTH_SHORT).show();
        }else{
            //INSERE NA BASE DE DADOS
            db = new DBHelper(this);
            long res = db.insert(log,mail,senha);
            if(res>0){
                Toast.makeText(this, "Registro inserido com sucesso!!!", Toast.LENGTH_SHORT).show();
                login.setText("");
                email.setText("");
                pass.setText("");
                repass.setText("");
            }else{
                Toast.makeText(this, "Não foi possivel efetuar o registro. Tente mais tarde", Toast.LENGTH_SHORT).show();
            }
        }
    }
        public void fazRegisto(View v){
            i = new Intent(Registro.this, Registro.class);
            startActivity(i);
            finish();
    }
}
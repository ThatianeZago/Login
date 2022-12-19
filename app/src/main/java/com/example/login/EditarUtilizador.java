package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarUtilizador extends AppCompatActivity {

    Intent it;
    int id;
    DBHelper db;
    EditText etlogin, etemail, etpassword, etrepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_utilizador);
        //Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();

        it = getIntent();
        id = it.getExtras().getInt("id");

        etlogin = findViewById(R.id.eregistoctxlogin);
        etemail = findViewById(R.id.eregistoctxemail);
        etpassword = findViewById(R.id.eregistoctxpass);
        etrepass = findViewById(R.id.eregistoctxrepass);

        db = new DBHelper(this);
        String[] valores = new String[3];
        valores = db.editarDados(id);

        etlogin.setText(valores[0]);
        etemail.setText(valores[1]);
        etrepass.setText(valores[2]);
        etrepass.setText(valores[2]);
    }
    public void atualizaDados(View v){
        db = new DBHelper(this);
        String login = etlogin.getText().toString();
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();

        if(db.atualizaDados(id,login,email,password)>0){
            Toast.makeText(this, "Atualizado com sucesso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Não foi possivel as alterações. Tente mais tarde", Toast.LENGTH_SHORT).show();
        }
    }
    public void voltar(View v){
        it = new Intent(EditarUtilizador.this,MostraUtilizadores.class);
        it.putExtra("id",id);
        startActivity(it);
        finish();
    }
}

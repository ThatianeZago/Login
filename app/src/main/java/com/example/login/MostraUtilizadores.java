package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MostraUtilizadores extends AppCompatActivity {
    DBHelper db;
    Intent it;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_utilizadores);
        it = getIntent();
        id = it.getExtras().get("id");
    }

    public void elimina(View v){
        db = new DBHelper(this);
        long res = db.eliminaUtilizador(id);
        if(res>0){
            Toast.makeText(this, "Registro excluido com sucesso", Toast.LENGTH_SHORT).show();
            it = new Intent(MostraUtilizadores.this, Login.class);
            startActivity(it);
            finish();
        }
        else{
            Toast.makeText(this, "Problema ao eleminar utilizador", Toast.LENGTH_SHORT).show();
        }
    }
}
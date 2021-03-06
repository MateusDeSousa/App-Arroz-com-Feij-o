package com.example.arrozcomfeijao.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arrozcomfeijao.Controller.Usuario;
import com.example.arrozcomfeijao.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PrincipalAdmin extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    private DatabaseReference referenciaFirebase;
    private TextView tipoUsuario;
    private Usuario usuario;
    private String tipoUsuarioEmail;

    private LinearLayout linearLayoutAddProdutos;
    private LinearLayout linearLayoutTotalProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_admin);
        autenticacao = FirebaseAuth.getInstance();
        referenciaFirebase = FirebaseDatabase.getInstance().getReference();

        getWindow().setBackgroundDrawable(null);

        linearLayoutAddProdutos = (LinearLayout) findViewById(R.id.linearLayoutAddProdutos);
        linearLayoutTotalProdutos = (LinearLayout) findViewById(R.id.linearLayoutTotalVendas);

        linearLayoutAddProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaCadastroProdutos();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.clear();
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add_usuario){
            abrirTelaCadastroUsuario();
        }else if (id == R.id.action_sair_admin){
            deslogarUsuario();
        }else if (id == R.id.action_ver_cardapio) {
            chamarCardapio();
        }else if (id == R.id.action_ver_meu_perfil) {
            verMeuPerfil();
        }
        return super.onOptionsItemSelected(item);
    }

    private void abrirTelaCadastroUsuario(){
        Intent intent = new Intent(PrincipalAdmin.this, CadastroFuncionario.class);
        startActivity(intent);
    }

    private void chamarCardapio(){
        Intent intent = new Intent(PrincipalAdmin.this, Cardapio.class);
        startActivity(intent);
    }

    private void verMeuPerfil(){
        Intent intent = new Intent(PrincipalAdmin.this, MeuPerfil.class);
        startActivity(intent);
        finish();
    }

    private void deslogarUsuario(){
        autenticacao.signOut();
        Intent intent = new Intent(PrincipalAdmin.this, Login.class);
        startActivity(intent);
        finish();
    }

    private void abrirTelaCadastroProdutos(){
        //Intent intent = new Intent(PrincipalAdmin.this, CadastroFuncionario.class);
        //startActivity(intent);
    }
}

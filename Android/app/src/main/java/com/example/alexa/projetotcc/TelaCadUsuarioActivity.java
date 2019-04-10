package com.example.alexa.projetotcc;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexa.projetotcc.DAO.Aluno;
import com.example.alexa.projetotcc.DAO.AlunoDAO;

public class TelaCadUsuarioActivity extends AppCompatActivity {

    private Button salvar;
    EditText nome;
    EditText sobrenome;
    EditText email;
    EditText senha;
    EditText curso;
    EditText semestre;
    Aluno aluno;
    AlunoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_usuario);

        salvar = (Button) findViewById(R.id.btnSalvar);
        nome = (EditText) findViewById(R.id.editNome);
        sobrenome = (EditText) findViewById(R.id.editSobrenome);
        senha = (EditText) findViewById(R.id.editText3);
        curso = (EditText) findViewById(R.id.editText4);
        semestre = (EditText) findViewById(R.id.editSemestre);
        email = (EditText) findViewById(R.id.editEmail);
        dao = new AlunoDAO(this);
        Intent intent = getIntent();
        if(intent.hasExtra("aluno")){
            aluno = (Aluno) intent.getSerializableExtra("aluno");
            nome.setText(aluno.getNome());
            sobrenome.setText(aluno.getSobreNome());
            email.setText(aluno.getEmail());
            curso.setText(aluno.getCurso());
            semestre.setText(aluno.getSemestre());
            senha.setText(aluno.getSenha());
        }

        /*
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaCadUsuarioActivity.this,TelaInicio.class));

            }
        });*/
    }

    public void salvar(View v){
        if (aluno == null) {
            Aluno aluno = new Aluno();
            aluno.setNome(nome.getText().toString());
            aluno.setSemestre(semestre.getText().toString());
            aluno.setCurso(curso.getText().toString());
            aluno.setSenha(senha.getText().toString());
            aluno.setEmail(email.getText().toString());
            aluno.setSobreNome(sobrenome.getText().toString());
            long codigo = dao.inserir(aluno);
            Toast.makeText(this, "Aluno inserido com ID: " + codigo, Toast.LENGTH_SHORT).show();
        }
        else{
            aluno.setNome(nome.getText().toString());
            aluno.setNome(nome.getText().toString());
            aluno.setSemestre(semestre.getText().toString());
            aluno.setCurso(curso.getText().toString());
            aluno.setSenha(senha.getText().toString());
            aluno.setEmail(email.getText().toString());
            aluno.setSobreNome(sobrenome.getText().toString());
            //dao.atualizar(aluno);
            Toast.makeText(this, "Aluno atualizado ", Toast.LENGTH_SHORT).show();
        }
    }

    public void telaListar(View v){
        Intent intent = new Intent(this, ListarAlunosActivity.class);
        startActivity(intent);
    }
}
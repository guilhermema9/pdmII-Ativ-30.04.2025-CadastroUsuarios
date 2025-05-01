package com.example.ativ_30042025_cadastrousuarios;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editTextnome, editTextSenha, editTextConfirmacaoSenha;
    private RadioGroup radioGroupSexo;
    private CheckBox checkBoxEstudante, checkBoxEstagiario, checkBoxProfissional;
    private ToggleButton toggleButtonDoador;
    private Button buttonCadastrar;
    private RecyclerView recyclerView;
    private List<Usuario> usuariosList = new ArrayList<>();
    private String sexo, estudante="", estagiario="", profissional="", doador="Não doador";
    private boolean boolEstudante=false, boolEstagiario=false, boolProfissional=false, boolDoador=false;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextnome = findViewById(R.id.editTextNome);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextConfirmacaoSenha = findViewById(R.id.editTextConfirmacaoSenha);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        checkBoxEstudante = findViewById(R.id.checkboxEstudante);
        checkBoxEstagiario = findViewById(R.id.checkbosEstagiario);
        checkBoxProfissional = findViewById(R.id.checkboxProfissional);
        toggleButtonDoador = findViewById(R.id.toggleButtonDoador);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cadastro de Usuários");

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(usuariosList);
        recyclerView.setAdapter(myAdapter);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( editTextSenha.getText().toString().equals(editTextConfirmacaoSenha.getText().toString())){
                    if (checkBoxEstudante.isChecked()){
                        boolEstudante = true;
                        estudante = "Estudante";
                    }
                    if (checkBoxEstagiario.isChecked()){
                        boolEstagiario = true;
                        estagiario = "Estagiário";
                    }
                    if (checkBoxProfissional.isChecked()){
                        boolProfissional = true;
                        profissional = "Profissional";
                    }
                    if (toggleButtonDoador.isChecked()){
                        boolDoador = true;
                        doador = "Doador";
                    }
                    Usuario usuario = new Usuario(
                            editTextnome.getText().toString(),
                            sexo,
                            boolEstudante,
                            boolEstagiario,
                            boolProfissional,
                            boolDoador);
                    usuariosList.add(usuario);
                    System.out.println(usuario);
                    Log.i("usuario", String.valueOf(usuario));
                    myAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Senha não confere", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                sexo = radioButton.getText().toString();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuLimpar){
            usuariosList.clear();
            myAdapter.notifyDataSetChanged();
        }
        if (item.getItemId() == R.id.menuInverter){
            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            layoutManager.setReverseLayout(true);
            layoutManager.setStackFromEnd(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
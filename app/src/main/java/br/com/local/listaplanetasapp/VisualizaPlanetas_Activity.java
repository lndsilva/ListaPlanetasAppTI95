package br.com.local.listaplanetasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualizaPlanetas_Activity extends AppCompatActivity {

    TextView txtPlanetas;
    ImageView imgPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualiza_planetas_layout);

        txtPlanetas = findViewById(R.id.mtxtPlaneta);
        imgPlanetas = findViewById(R.id.mimgPlaneta);

        //Receber os valores passados pela MainActivity nome do planeta e a imagem do planeta
        Intent intent = getIntent();

        String nomePlaneta = intent.getStringExtra("nomePlanetas");
        int imagemPlaneta = intent.getIntExtra("imgPlanetas", 0);

        txtPlanetas.setText(nomePlaneta);
        imgPlanetas.setImageResource(imagemPlaneta);


    }
}
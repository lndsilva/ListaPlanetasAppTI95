package br.com.local.listaplanetasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //Conteúdo que será inserido na ListView
    String nomePlanetas[] = {"Jupiter", "Lua", "Marte", "Mercurio",
            "Netuno", "Plutão", "Saturno", "Sol", "Terra", "Urano", "Venus"};
    int imgPlanetas[] = {R.drawable.jupiter, R.drawable.lua,
            R.drawable.marte, R.drawable.mercurio, R.drawable.netuno,
            R.drawable.plutao, R.drawable.saturno, R.drawable.sol,
            R.drawable.terra, R.drawable.urano, R.drawable.venus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarando a listView java com o XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o adaptador para instânciar o modelo layout a listView
        CustomAdapter adapter = new CustomAdapter();

        //Neste momento será feita a implementação da lista
        listView.setAdapter(adapter);

        //Implementar o click no item da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              Intent intent = new Intent(getApplicationContext(),VisualizaPlanetas_Activity.class);
              //É necessário utilizar o intent para passar os valores para outra activity
                //Implementar o putExtra

                intent.putExtra("nomePlanetas",nomePlanetas[i]);
                intent.putExtra("imgPlanetas",imgPlanetas[i]);

                startActivity(intent);

            }
        });
    }

    //Criar o objeto ou a classe CustomAdapter extendendo o BaseAdapter
    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imgPlanetas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Método que irá instânciar o modelo
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            TextView txtNomePlanetas;
            ImageView imagemPlanetas;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_planetas_layout,null);

            txtNomePlanetas = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemPlanetas = carregaView.findViewById(R.id.imgListaPlaneta);

            txtNomePlanetas.setText(nomePlanetas[i]);
            imagemPlanetas.setImageResource(imgPlanetas[i]);


            return carregaView;
        }
    }

}
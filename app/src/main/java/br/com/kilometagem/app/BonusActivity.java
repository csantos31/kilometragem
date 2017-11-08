package br.com.kilometagem.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static br.com.kilometagem.app.R.id.lstBonus;

public class BonusActivity extends AppCompatActivity {

    ListView listView;
    public BonusAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        listView = (ListView)findViewById(lstBonus);
        List<Registro> lstRegistros = Registro.listAll(Registro.class);


        List<Registro> lstBonus = new ArrayList<>();

        Float kilometros=0f;

        for (int i = 0;  i < lstRegistros.size(); i++){
            Float bonus;

            Registro item = lstRegistros.get(i);

            kilometros += item.getKilometros();
            if(kilometros <= 4000){
                bonus = kilometros * 1.5f;

            }else {
               bonus = 4000f * 1.5f +( (kilometros - 4000f) * 1.25f);
            }

            Registro r = new Registro();
            r.setMes(item.getMes());
            r.setKilometros(bonus);

            lstBonus.add(r);
        }

        adapter = new BonusAdapter(this, lstBonus);
        listView.setAdapter(adapter);

    }

    public void voltarAoInicio(View view) {
        Intent intent = new Intent(this, VerRegistrosActivity.class);
        startActivity(intent);
        finish();
    }

    public class BonusAdapter extends ArrayAdapter<Registro> {
        public BonusAdapter(Context ctx, List<Registro> itens){
            super(ctx,0,itens);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {

            View v = convertView;

            if(v == null){
                v = LayoutInflater.from(getContext()).inflate(R.layout.bonus_item, null);
            }

            Registro item = getItem(position);

            TextView txtMes= v.findViewById(R.id.txtBonusMes);
            TextView txtBonus = v.findViewById(R.id.txtBonusKm);

            txtMes.setText(item.getMes());
            //txtBonus.setText(Float.toString(kilometros));
            txtBonus.setText("R$ " + item.getKilometros().toString() + " ");

            return v;


        }
    }

}

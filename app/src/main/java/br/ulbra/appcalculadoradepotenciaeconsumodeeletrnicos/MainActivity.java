package br.ulbra.appcalculadoradepotenciaeconsumodeeletrnicos;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    EditText edPotencia, edHoras, edPrecoKwh;
    Button btCalcular;
    TextView txResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPotencia = findViewById(R.id.edtPotencia);
        edHoras = findViewById(R.id.edtHoras);
        edPrecoKwh = findViewById(R.id.edtPrecoKwh);
        btCalcular = findViewById(R.id.btnCalcular);
        txResultado = findViewById(R.id.txtResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularConsumo();
            }
        });
    }


    public void calcularConsumo

() {
        if (edPotencia.getText().toString().isEmpty() || edHoras.getText().toString().isEmpty() || edPrecoKwh.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        double potencia = Double.parseDouble(edPotencia.getText().toString());
        double horas = Double.parseDouble(edHoras.getText().toString());
        double precoKwh = Double.parseDouble(edPrecoKwh.getText().toString());

        double consumoEnergia = (potencia * horas) / 1000; // Consumo em kWh
        double custo = consumoEnergia * precoKwh; // Custo em reais

        txResultado.setText(String.format("Consumo: %.2f kWh\nCusto: R$ %.2f", consumoEnergia, custo));
    }
}

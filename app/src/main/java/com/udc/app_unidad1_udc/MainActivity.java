package com.udc.app_unidad1_udc;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // VARIABLES A USAR PARA EDITAR
    private EditText etSalarioBase, etHorasExtras, etBonificacion;


    //VARIABLE A USAR PARA MOSTRAR RESULTADO
    private TextView tvSalarioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalarioBase = findViewById(R.id.etSalarioBase);
        etHorasExtras = findViewById(R.id.etHorasExtras);
        etBonificacion = findViewById(R.id.etBonificacion);
        tvSalarioTotal = findViewById(R.id.tvSalarioTotal);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSalario();
            }
        });
    }
    //CAPTURAR Y HACER CALCULO DE LOS DATOS INGRESADOS
    private void calcularSalario() {
        double salarioBase = Double.parseDouble(etSalarioBase.getText().toString());
        double horasExtras = Double.parseDouble(etHorasExtras.getText().toString());
        double bonificacion = Double.parseDouble(etBonificacion.getText().toString());

        double valorHoraNormal = salarioBase / 192;
        double valorHorasExtras = horasExtras * valorHoraNormal * 1.25;
        double salarioTotalAntesDescuentos = salarioBase + valorHorasExtras + (salarioBase * bonificacion / 100);

        double descuentoSalud = salarioTotalAntesDescuentos * 0.035;
        double descuentoPension = salarioTotalAntesDescuentos * 0.04;
        double descuentoCajaCompensacion = salarioTotalAntesDescuentos * 0.01;

        double salarioTotal = salarioTotalAntesDescuentos - descuentoSalud - descuentoPension - descuentoCajaCompensacion;

        tvSalarioTotal.setText("Salario Total: $" + String.format("%.2f", salarioTotal));
    }
}

package pandoraabce.com.freeex;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class chatActivity extends AppCompatActivity implements View.OnClickListener{

    //Se definen variables
    ListView listaChat;
    TextView textoMensaje;
    Button btnEnviar;

    //Un array de valores para probar el chat
    String[] valores = new String[]{"","","","","","","","","","","","","","","","","","","",""};




    //Eventos que ocurren cuando se inicia la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //Se relacionan las variables de java con objetos de android
        listaChat = (ListView) findViewById(R.id.listaChat);
        textoMensaje = (TextView) findViewById(R.id.textoMensaje);
        btnEnviar = (Button) findViewById(R.id.botonEnviar);

        //Un listener para el boton
        btnEnviar.setOnClickListener(this);

        //Adapta la lista de valores a la ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores);
        listaChat.setAdapter(adapter);

    }

    //Acciones al presionar los botones
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonEnviar:
                //Se guarda el input en una variable
                String mensaje = textoMensaje.getText().toString();

                //Verifica que el mensaje no este vacio antes de enviarlo
                if (!"".equals(mensaje) ) {

                    int posicionValores = 19;

                    //Cambia la posicion de los elementos del arreglo
                    while (posicionValores > 0) {
                        valores[posicionValores] = valores[posicionValores - 1];
                        posicionValores = posicionValores - 1;
                    }

                    //Asigna el mensaje en la primera posicion del arreglo
                    valores[0] = "Usuario"+": "+mensaje;

                    //Actualiza el objeto de android
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores);
                    listaChat.setAdapter(adapter);
                    textoMensaje.setText("");
                    mensaje = "";
                }

                break;
        }

    }
}

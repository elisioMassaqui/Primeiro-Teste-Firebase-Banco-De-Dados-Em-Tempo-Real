public class MainActivity extends AppCompatActivity {

    // Referência ao nó do banco de dados que contém o texto,primeiro pegamos a instancia do realtime database InfosClasse,depois percorrendo o nó ,Comunicados, até encontrar o filho especifico e pegar nesse caso o Texto Do Menu Centralizado.
    DatabaseReference noComunicados = FirebaseDatabase.getInstance().getReference().child("Comunicados").child("Menu Inicial").child("Texto Do Menu Centralizado");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Adicione um ValueEventListener para ouvir as alterações no nó "noComunicados" em tempo real.
        noComunicados.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Este método será chamado sempre que os dados no nó "Comunicados" forem alterados, e a string vai receber o dados que está no servidor.
                String textoDoMenuCentralizado = dataSnapshot.getValue(String.class);

                // Atualize a interface do usuário com o novoTexto


                // Por exemplo, atualize um TextView aqui.
                TextView meuTextView = findViewById(R.id.helloFirebase); // Substitua com o ID do seu TextView

                //agora coloca a informação do nosso textoDoMenuCentralizado  no TextView da nossa interface.
                meuTextView.setText(textoDoMenuCentralizado);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Lidar com erros, se necessário

            }
        });

    }

}

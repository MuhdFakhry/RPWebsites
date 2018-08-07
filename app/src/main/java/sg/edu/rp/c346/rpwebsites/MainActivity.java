package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvCategory;
    Spinner spnCat;
    TextView tvSub;
    Spinner spnSubCat;
    Button btnGo;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCategory = findViewById(R.id.textViewCategory);
        spnCat = findViewById(R.id.spinner1);
        tvSub = findViewById(R.id.textViewSub);
        spnSubCat = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        alCategory = new ArrayList<>();
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);
        spnSubCat.setAdapter(aaCategory);

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        alCategory.clear();
                        String[] rpWebpages = getResources().getStringArray(R.array.rp_sub);
                        alCategory.addAll(Arrays.asList(rpWebpages));
                        aaCategory.notifyDataSetChanged();
                        break;
                    case 1:
                        alCategory.clear();
                        String[] soiWebpages = getResources().getStringArray(R.array.soi_sub);
                        alCategory.addAll(Arrays.asList(soiWebpages));
                        aaCategory.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spnCat.getSelectedItemPosition();
                int pos2 = spnSubCat.getSelectedItemPosition();

                //Enhancement (option 1)
                String[][] sites = {
                        {
                                "https://www.rp.edu.sg/",
                                "https://www.rp.edu.sg/student-life",
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12",
                        }
                };
                String website = sites[spnCat.getSelectedItemPosition()][spnSubCat.getSelectedItemPosition()];

                Intent intent = new Intent(getBaseContext(), website_activity.class);
                intent.putExtra("webpage", website);
                startActivity(intent);

                //normal problem statement (option 2)
                if (pos == 0 && pos2 == 0) {
                    Intent intentNewAct = new Intent(getBaseContext(),website_activity.class);
                    intentNewAct.putExtra("webpage", "https://www.rp.edu.sg/");
                    startActivity(intentNewAct);
                }

                else if (pos == 0 && pos2 == 1) {
                    Intent intentNewAct = new Intent(getBaseContext(),website_activity.class);
                    intentNewAct.putExtra("webpage", "https://www.rp.edu.sg/student-life");
                    startActivity(intentNewAct);
                }

                else if (pos == 1 && pos2 == 0) {
                    Intent intentNewAct = new Intent(getBaseContext(), website_activity.class);
                    intentNewAct.putExtra("webpage", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                    startActivity(intentNewAct);
                }

                else if (pos == 1 && pos2 == 1) {
                    Intent intentNewAct = new Intent(getBaseContext(), website_activity.class);
                    intentNewAct.putExtra("webpage", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                    startActivity(intentNewAct);
                }
            }
        });

    }
}

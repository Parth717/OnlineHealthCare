package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private String[][] doctor_details1={
            {"Doctor Name : Satish Jadhav","Hospital Address : Panvel","Exp : 5yrs","Mobile No. : 1234567890","500"},
            {"Doctor Name : Ramesh Kulkarni","Hospital Address : Karjat","Exp : 7yrs","Mobile No. : 1234567891","700"},
            {"Doctor Name : Mahesh Pandit","Hospital Address : Thane","Exp : 9yrs","Mobile No. : 1234567892","900"},
            {"Doctor Name : Shivprasad Sharma","Hospital Address : Pen","Exp : 3yrs","Mobile No. : 1234567893","300"},
            {"Doctor Name : Kisan Chaudhary","Hospital Address : Mumbai","Exp : 5yrs","Mobile No. : 1234567894","500"}
    };

    private String[][] doctor_details2={
            {"Doctor Name : Sushil Patil","Hospital Address : Panvel","Exp : 9yrs","Mobile No. : 1234567895","1000"},
            {"Doctor Name : Janhavi More","Hospital Address : Kalyan","Exp : 7yrs","Mobile No. : 1234567896","800"},
            {"Doctor Name : Shree Kadav","Hospital Address : Thane","Exp : 8yrs","Mobile No. : 1234567897","900"},
            {"Doctor Name : Dev Kadam","Hospital Address : Pen","Exp : 3yrs","Mobile No. : 1234567898","500"},
            {"Doctor Name : Sahil Mhatre","Hospital Address : Mumbai","Exp : 5yrs","Mobile No. : 1234567899","700"}
    };

    private String[][] doctor_details3={
            {"Doctor Name : Rahul Patil","Hospital Address : Alibag","Exp : 5yrs","Mobile No. : 1234567880","700"},
            {"Doctor Name : Samir Jadhav","Hospital Address : Karjat","Exp : 4yrs","Mobile No. : 1234567881","500"},
            {"Doctor Name : Shubham Mhatre","Hospital Address : Thane","Exp : 8yrs","Mobile No. : 1234567882","900"},
            {"Doctor Name : Prasad Oak","Hospital Address : Roha","Exp : 6yrs","Mobile No. : 1234567883","800"},
            {"Doctor Name : Mahesh Vagle","Hospital Address : Mumbai","Exp : 5yrs","Mobile No. : 1234567884","600"}
    };

    private String[][] doctor_details4={
            {"Doctor Name : ABC","Hospital Address : Panvel","Exp : 5yrs","Mobile No. : 1234567885","500"},
            {"Doctor Name : DEF","Hospital Address : Karjat","Exp : 7yrs","Mobile No. : 1234567886","700"},
            {"Doctor Name : GHI","Hospital Address : Thane","Exp : 9yrs","Mobile No. : 1234567887","900"},
            {"Doctor Name : JKL","Hospital Address : Pen","Exp : 3yrs","Mobile No. : 1234567888","300"},
            {"Doctor Name : MNO","Hospital Address : Mumbai","Exp : 5yrs","Mobile No. : 1234567889","500"}
    };

    private String[][] doctor_details5={
            {"Doctor Name : PQR","Hospital Address : Panvel","Exp : 5yrs","Mobile No. : 1234567870","1500"},
            {"Doctor Name : STU","Hospital Address : Karjat","Exp : 7yrs","Mobile No. : 1234567871","1700"},
            {"Doctor Name : XYZ","Hospital Address : Thane","Exp : 9yrs","Mobile No. : 1234567872","1900"},
            {"Doctor Name : AEI","Hospital Address : Pen","Exp : 3yrs","Mobile No. : 1234567873","1300"},
            {"Doctor Name : OU","Hospital Address : Mumbai","Exp : 5yrs","Mobile No. : 1234567874","1500"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewHA_title);
        btn=findViewById(R.id.buttonADback);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst=findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
                finish();

            }
        });

    }
}
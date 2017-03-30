package ListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.actionmode.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapter extends AppCompatActivity {
    private String[] names = new String[]
            {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageIds = new int[]
            {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
                    R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, Object>> listItems;
        listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("Name", names[i]);
            listItems.add(listItem);
        }
        android.widget.SimpleAdapter simpleAdapter = new android.widget.SimpleAdapter(this, listItems, R.layout.simple_list,
                new String[]{"Name", "header"},
                new int[]{R.id.Name, R.id.header});
        ListView list = (ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(ListView.SimpleAdapter.this, names[position], Toast.LENGTH_SHORT);

            }
        });
    }
}


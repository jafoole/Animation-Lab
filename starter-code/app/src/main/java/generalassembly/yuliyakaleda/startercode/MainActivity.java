package generalassembly.yuliyakaleda.startercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  ArrayList<String> mArrayList;
  ArrayAdapter<String> mAdapter;
  ListView mListView;

  String errorMessage = "Nothing Added :)";



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: set up all the view and event listeners.
    Button addButton = (Button)findViewById(R.id.addButton);
    final EditText editText = (EditText)findViewById(R.id.editText);

    mListView = (ListView)findViewById(R.id.listView);

    final TextView textViewRotate = (TextView)findViewById(R.id.textViewRotate);

    mArrayList = new ArrayList<String>();

    mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mArrayList);
    mListView.setAdapter(mAdapter);

    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (editText.getText().toString().isEmpty()) {
          editText.setError(errorMessage);
        } else {
          textViewRotate.setText(editText.getText());

          Animation textAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);
          textViewRotate.startAnimation(textAnimation);

          String input = textViewRotate.getText().toString();
          mArrayList.add(input);
          editText.setText(" ");
        }


      }
    });

    mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        String itemSelected = parent.getItemAtPosition(position).toString();
        mAdapter.remove(itemSelected);

        return false;
      }
    });

  }
//
//  @Override
//  public void onClick(View v) {
//    // TODO: 1. get the text from the input field
//    //       2. animate it in the center of the screen
//    //       3. add it to the list wish
//    //       4. clear the input field
//  }
}

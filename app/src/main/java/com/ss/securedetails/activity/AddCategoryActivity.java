package com.ss.securedetails.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.ss.securedetails.R;
import com.ss.securedetails.modal.ItemCategory;
import com.ss.securedetails.utils.MyLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCategoryActivity extends AppCompatActivity {

    private String TAG = AddCategoryActivity.class.getSimpleName();
    private Context context = AddCategoryActivity.this;
    private Toolbar toolbar;
    private AutoCompleteTextView tv_category_name;
    private EditText et_category_description;
    private Button btn_add_category;
    private String str_name, str_description;
    private DatabaseReference mDatabase;
    private ProgressDialog progressDialog;
    private List<String> categoryNameList;
    private List<ItemCategory> categoryList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.add_category);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_category_description = findViewById(R.id.et_category_description);
        tv_category_name = findViewById(R.id.tv_category_name);
        btn_add_category = findViewById(R.id.btn_add_category);

        categoryList = new ArrayList<>();
        categoryNameList = new ArrayList<>();

        progressDialog = new ProgressDialog(context);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        db = FirebaseFirestore.getInstance();

        btn_add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_description = et_category_description.getText().toString();
                str_name = tv_category_name.getText().toString();

                if (str_name.trim().length() == 0) {
                    Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show();
                } else if (str_description.trim().length() == 0) {
                    Toast.makeText(context, "Please enter description of category", Toast.LENGTH_SHORT).show();
                } else {
                    postOnServer();
                }
            }
        });
        getCategory();
    }

    private void postOnServer() {
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        String key = mDatabase.child("Category").push().getKey();
        ItemCategory itemProductCategory = new ItemCategory(key, str_name, str_description, "true", "true");
        Map<String, Object> postValues = itemProductCategory.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("Category/" + str_name, postValues);
        mDatabase.updateChildren(childUpdates).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                progressDialog.dismiss();
                resetViews();
                Toast.makeText(context, "Category added successful", Toast.LENGTH_SHORT).show();
                getCategory();
            }
        });

    }

    private void setSpinnerAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, categoryNameList);
        tv_category_name.setAdapter(adapter);
    }

    private void getCategory() {
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        mDatabase.child("Category").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        progressDialog.dismiss();
                        categoryNameList = new ArrayList<>();
                        categoryList = new ArrayList<>();
                        MyLog.e(TAG, " Category response is as follow " + dataSnapshot.getValue() + " and key name " + dataSnapshot.getKey());
                        for (DataSnapshot data_values : dataSnapshot.getChildren()) {
                            MyLog.e(TAG, "Category Name as " + data_values.getKey());
                            ItemCategory itemProductCategory = data_values.getValue(ItemCategory.class);
                            MyLog.e(TAG, " Modal class category name as " + itemProductCategory.getCatg_name());
                            categoryNameList.add(itemProductCategory.getCatg_name());
                            categoryList.add(itemProductCategory);
                        }
                        MyLog.e(TAG, " Category list size as " + categoryNameList);
                        setSpinnerAdapter();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                        MyLog.e(TAG, "getUser:onCancelled" + databaseError.toException());
                    }
                });

    }


    private void resetViews() {
        et_category_description.setText("");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
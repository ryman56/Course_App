package com.example.courseapp.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseapp.Adapter.CoursesAdapter;
import com.example.courseapp.Domain.CoursesDomain;
import com.example.courseapp.R;

import java.util.ArrayList;

public class CoursesListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterCourseList;
    private RecyclerView recyclerViewCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_courses_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initRecyclerView();
    }
    private void initRecyclerView(){
        ArrayList<CoursesDomain> items =new ArrayList<>();
        items.add(new CoursesDomain("Advanced Certification Program in AI",169,"ic_1"));
        items.add(new CoursesDomain("Google Cloud Platform Architecture",69,"ic_2"));
        items.add(new CoursesDomain("Fundamentals of Java Programming",150,"ic_3"));
        items.add(new CoursesDomain("Introduction to UI Design History",79,"ic_4"));
        items.add(new CoursesDomain("PG Program in Big Data Engineering",40,"ic_5"));

        recyclerViewCourse=findViewById(R.id.view);
        recyclerViewCourse.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterCourseList = new CoursesAdapter(items);
        recyclerViewCourse.setAdapter(adapterCourseList);
    }
}
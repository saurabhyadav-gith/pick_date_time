package saurabh.digipodium.pick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button dateButton, timeButton;
    TextView dateTextView, timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            dateButton = findViewById(R.id.dateButton);
            timeButton = findViewById(R.id.timeButton);
            dateTextView = findViewById(R.id.dateTextView);
            timeTextView = findViewById(R.id.dateTextView);

            dateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleDateButton();
                }
            });
            timeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleTimeButton();
                }
            });

        }

        private void handleDateButton() {
            Calendar calendar = Calendar.getInstance();
            int YEAR = calendar.get(Calendar.YEAR);
            int MONTH = calendar.get(Calendar.MONTH);
            int DATE = calendar.get(Calendar.DATE);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.YEAR, year);
                    calendar1.set(Calendar.MONTH, month);
                    calendar1.set(Calendar.DATE, date);
                    String dateText = DateFormat.format("EEEE, MMM d, yyyy", calendar1).toString();

                    dateTextView.setText(dateText);
                }
            }, YEAR, MONTH, DATE);

            datePickerDialog.show();




        }

        private void handleTimeButton() {
            Calendar calendar = Calendar.getInstance();
            int HOUR = calendar.get(Calendar.HOUR);
            int MINUTE = calendar.get(Calendar.MINUTE);
            boolean is24HourFormat = DateFormat.is24HourFormat(this);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
//                    Log.i(TAG, "onTimeSet: " + hour + minute);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.set(Calendar.HOUR, hour);
                    calendar1.set(Calendar.MINUTE, minute);
                    String dateText = DateFormat.format("h:mm a", calendar1).toString();
                    timeTextView.setText(dateText);
                }
            }, HOUR, MINUTE, is24HourFormat);

            timePickerDialog.show();

        }
}
package com.example.project;


public class Time{
    public static final int HOURS_IN_A_DAY = 24;
    public static final int MINUTES_IN_AN_HOUR = 60;
    public static final int SECONDS_IN_A_MINUTE = 60;
    public static final int SECONDS_IN_AN_HOUR = SECONDS_IN_A_MINUTE * MINUTES_IN_AN_HOUR;
    public static final int SECONDS_IN_A_DAY = SECONDS_IN_AN_HOUR * HOURS_IN_A_DAY;
   
    
    
    //PRIVATE INSTANCE VARIABLES HERE
    private int hour;
    private int minute;
    private int second;

    //CONSTRUCTOR HERE 
    //constructor should take in 3 parameters (int hour, int minute, int seconds)
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //GETTERS 
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String info(){
       String secondString = String.format("%02d", second);
       String minuteString = String.format("%02d", minute);
       String hourString = String.format("%02d", hour);
       return hourString + ":" + minuteString + ":" + secondString;
       
    }


    public void tick(){
        second++;
        if (second >= SECONDS_IN_A_MINUTE) {
            second = 00;
            minute++;
            if (minute >= MINUTES_IN_AN_HOUR) {
                minute = 00;
                hour++;
                if (hour >= HOURS_IN_A_DAY) {
                    hour = 00;
                }
            }
        }
    }


    public void add(Time time2){
        int totalSeconds = this.second + time2.getSecond();
        int totalMinutes = this.minute + time2.getMinute() + (totalSeconds / SECONDS_IN_A_MINUTE);
        int totalHours = this.hour + time2.getHour() + (totalMinutes / MINUTES_IN_AN_HOUR);

        this.hour = totalHours % HOURS_IN_A_DAY;
        this.minute = totalMinutes % MINUTES_IN_AN_HOUR;
        this.second = totalSeconds % SECONDS_IN_A_MINUTE;
    }
    }



package com.luv2code.cruddemo.rest;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

        public StudentErrorResponse(int status,String message,long timeStamp){
            this.status = status;
            this.message = message;
            this.timeStamp = timeStamp;
        }


        public int getStatus(){
            return status;
        }
        public String getMessage(){
            return message;
        }
        public long getTimeStamp(){
            return timeStamp;
        }
        public int setStatus(int status){
            return this.status = status;
        }
        public String setMessage(String message){
            return this.message = message;
        }
        public long setTimeStamp(long timeStamp){
            return this.timeStamp = timeStamp;
        }        


        
    }


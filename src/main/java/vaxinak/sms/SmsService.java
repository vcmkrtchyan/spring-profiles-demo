package vaxinak.sms;

public interface SmsService {
    void sendSms(String phoneNumber, String content);
}

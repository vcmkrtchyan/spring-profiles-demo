package vaxinak.sms;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MockSmsService implements SmsService {

    @Override
    public void sendSms(String phoneNumber, String content) {
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("content = " + content);
    }

}

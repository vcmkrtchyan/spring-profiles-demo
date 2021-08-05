package vaxinak.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class TwilioSmsService implements SmsService {

    private static final String ACCOUNT_SID = "AC693743e9474ce6ad74ba0a6af6660118";
    private static final String AUTH_TOKEN = "dc7e4b12e5b6074c03d0c652e6df868b";

    @Override
    public void sendSms(String phoneNumber, String content) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+374" + phoneNumber),
                new com.twilio.type.PhoneNumber("+14049948056"),
                content
        ).create();

        message.getSid();
    }

}

package vaxinak;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vaxinak.sms.SmsService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VerifyPhoneNumberController {

    private final SmsService smsService;
    private final Map<String, String> verificationCodes = new HashMap<>();

    public VerifyPhoneNumberController(SmsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/sms/send")
    public ResponseEntity<?> sendSms(@RequestParam String phoneNumber) {
        String code = String.valueOf((int) (Math.random() * 10000));
        verificationCodes.put(phoneNumber, code);
        smsService.sendSms(phoneNumber, code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/phone/verify")
    public ResponseEntity<?> verify(@RequestParam String phoneNumber, String code) {
        if (code.equals(verificationCodes.get(phoneNumber))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

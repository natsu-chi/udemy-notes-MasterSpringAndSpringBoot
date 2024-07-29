package com.chi.demo03.web02;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mixpanel {

    @Autowired
    private MixpanelApiConfiguration config;

    public Mixpanel() {}

    public void sendData() throws Exception {
        JSONObject props = new JSONObject();
        props.put("$name", "Jane Doe");
        props.put("$email", "jane.doe@example.com");
        props.put("plan", "Premium");
        JSONObject update = config.messageBuilder.set("USER_ID", props);
        
        // Send the update to mixpanel
        config.mixpanel.sendMessage(update);
    }
}

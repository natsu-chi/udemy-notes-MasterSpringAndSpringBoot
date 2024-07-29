package com.chi.demo03.web02;

import org.springframework.context.annotation.Configuration;

//Import Mixpanel API
import com.mixpanel.mixpanelapi.MessageBuilder;
import com.mixpanel.mixpanelapi.MixpanelAPI;

@Configuration
public class MixpanelApiConfiguration {
    // Set up an instance of MixpanelAPI 
    MixpanelAPI mixpanel = new MixpanelAPI();
    
    MessageBuilder messageBuilder = new MessageBuilder("051aa3a013bab7daf12ce4bd7ffb2ce1");
}

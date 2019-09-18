package framework.mail;

import framework.utils.PropertyManager;

import java.util.Properties;

class PropertiesForMail {
    static Properties getProps() {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.host", PropertyManager.getConfigProperty("host"));
        properties.put("mail.port", "995");
        properties.put("mail.starttls.enable", "true");
        return properties;
    }
}

package config;

import net.thucydides.core.annotations.Steps;

public class Environment {
    @Steps
    public static String newPolicyId;

    public static String getPetStoreServiceUrl() {
        return GradlePropertyManager.INSTANCE.getProperty("petStoreServiceUrl");
    }
    public static String getPetID() {
        return GradlePropertyManager.INSTANCE.getProperty("petID");
    }
    public static String addNewPetJsonFilePath() {
        return GradlePropertyManager.INSTANCE.getProperty("addNewPetJsonFilePath");
    }

    public static String addNewPetXmlFilePath() {
        return GradlePropertyManager.INSTANCE.getProperty("addNewPetXmlFilePath");
    }

    public static String updatePetNameJsonFilePath() {
        return GradlePropertyManager.INSTANCE.getProperty("updatePetNameJsonFilePath");
    }

    public static String updatePetStatusJsonFilePath() {
        return GradlePropertyManager.INSTANCE.getProperty("updatePetStatusJsonFilePath");
    }

}

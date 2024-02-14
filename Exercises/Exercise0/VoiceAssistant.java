//region imports
import java.time.Duration;
//endregion
public class VoiceAssistant {

    //region properties
    private String volumeLevel;
    private String wakeCommand;
    private boolean isActivated;
    private String voiceGender;
    private Duration responseSpeed;
    private String languageSupport;
    private String voiceRecognition;
    private String connectivity;
    private String voiceAssistantId;
    //endregion

    //region constructor
    public VoiceAssistant(String objName) {
        assignValues();
        this.voiceAssistantId = "VoiceAssistant_" + objName;
        System.out.println("Voice Assistant instance created: " + this.voiceAssistantId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.volumeLevel = "High";
        this.wakeCommand = "Hey Siri";
        this.isActivated = true;
        this.voiceGender = "Female";
        this.responseSpeed = Duration.ofSeconds(5);
        this.languageSupport = "English";
        this.voiceRecognition = "Clear";
        this.connectivity = "Home Devices";
    }

    public void activate() {
        this.isActivated = true;
        System.out.println("Activating " + this.voiceAssistantId);
    }

    public void deactivate() {
        this.isActivated = false;
        System.out.println("Deactivating " + this.voiceAssistantId);
    }

    public void performTask(String task) {
        System.out.println("Performing task: " + task + " with " + this.voiceAssistantId);
    }

    public void setReminder(String reminder) {
        System.out.println("Setting a reminder on " + this.voiceAssistantId + ": " + reminder);
    }

    public void answerQuestion(String question) {
        System.out.println("Answering question: " + question + " with " + this.voiceAssistantId);
    }
    //endregion

    //region nested class AssistantSettings
    public class AssistantSettings {
        //region properties
        private boolean autoUpdate;
        private String preferredLanguage;
        //endregion

        //region constructor
        public AssistantSettings() {
            this.autoUpdate = true;
            this.preferredLanguage = "English";
            System.out.println("AssistantSettings instance created for VoiceAssistant nested class.");
        }
        //endregion

        //region methods
        public void displaySettings() {
            System.out.println("Settings for " + voiceAssistantId + ":");
            System.out.println("Auto Update: " + (this.autoUpdate ? "Enabled" : "Disabled"));
            System.out.println("Preferred Language: " + this.preferredLanguage);
        }
        //endregion
    }
    //endregion

    //region nested class AssistantTasks
    public class AssistantTasks {
        //region properties
        private int pendingTasks;
        //endregion

        //region constructor
        public AssistantTasks() {
            this.pendingTasks = 0;
            System.out.println("AssistantTasks instance created for VoiceAssistant nested class");
        }
        //endregion

        //region methods
        public void addTask(String task) {
            this.pendingTasks++;
            System.out.println("Task added for " + voiceAssistantId + ": " + task);
        }

        public void completeTask() {
            if (this.pendingTasks > 0) {
                this.pendingTasks--;
                System.out.println("Task completed for " + voiceAssistantId);
            } else {
                System.out.println("No tasks to complete for " + voiceAssistantId);
            }
        }
        //endregion
    }
    //endregion
}
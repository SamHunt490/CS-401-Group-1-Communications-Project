import java.io.Serializable;

// This class has the typical default constructors, getters, and setters in order
// to set and send the values of type, status, and text to other classes that call it.
public class Message implements Serializable {
    protected String type;
    protected String status;
    protected String text;

    public Message() {
        this.type = "Client";
        this.status = "Successful";
        this.text = "Filler text";
    }

    public Message(String type, String status, String text) {
        this.type = type;
        this.status = status;
        this.text = text;
    }

    private void setType(String type) {
    	this.type = type;
    }

    public void setStatus(String status) {
    	this.status = status;
    }

    public void setText(String text) {
    	this.text = text;
    }

    public String getType() {
    	return type;
    }

    public String getStatus() {
    	return status; 
    } 
    
    public String getText() {
    	return text;
    }

}
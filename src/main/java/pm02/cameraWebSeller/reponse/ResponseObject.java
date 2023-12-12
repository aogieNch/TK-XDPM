package pm02.cameraWebSeller.reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject {
    private String status, message;
    private Object data;

    public ResponseObject(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}

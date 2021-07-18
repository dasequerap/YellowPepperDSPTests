package views;

import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import models.UserModel;
import org.json.simple.JSONObject;

public class UserView extends BaseView{

    public UserView(String _webServiceURI) throws IOException {
        RestAssured.baseURI = _webServiceURI;
        this.setRequest(RestAssured.given());
        this.getRequest().basePath("user");
        this.getRequest().log().everything().when();
    }

    public ValidatableResponse getUserByUsername(String userId) {
        return this.getRequest().get( "{userId}", userId).then().log().everything();
    }

    public ValidatableResponse createUser(UserModel newUser){
        JSONObject postParams = new JSONObject();

        this.getRequest().header("Content-Type", "application/json");
        postParams.put("id", newUser.getId());
        postParams.put("username", newUser.getUserName());
        postParams.put("firstName", newUser.getFirstName());
        postParams.put("lastName", newUser.getLastName());
        postParams.put("email", newUser.getEmail());
        postParams.put("password", newUser.getPassword());
        postParams.put("phone", newUser.getPhone());
        postParams.put("userStatus", newUser.getUserStatus());

        return this.getRequest().body(postParams.toJSONString()).post().then().log().everything();
    }
}

package views;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import models.UserModel;

public class UserView extends BaseView{

    public UserView(String _webServiceURI) {
        super(_webServiceURI, "user");
    }

    public ValidatableResponse getUserByUsername(String userName) {
        return this.getRequest().get( "{userName}", userName).then().log().everything();
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

        return this.getRequest().body(postParams.toString()).post().then().log().everything();
    }

    public ValidatableResponse login(UserModel userToLogIn){
        return this.getRequest()
                .queryParam("username", userToLogIn.getUserName())
                .queryParam("password", userToLogIn.getPassword())
                .get("/login").then().log().everything();
    }

    public ValidatableResponse logout(){
        return this.getRequest().get("/logout").then().log().everything();
    }

}

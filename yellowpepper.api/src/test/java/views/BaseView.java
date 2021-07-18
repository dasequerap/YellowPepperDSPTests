package views;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseView {

    ValidatableResponse _apiResponse;
    String _URI;
    private String _resource;
    private RequestSpecification _request;

    BaseView() { }

    private String getResource() { return this._resource; }

    RequestSpecification getRequest(){ return this._request; }

    void setResource(String resource) { this._resource = resource; }

    void setRequest(RequestSpecification request){ this._request = request; }

    public ValidatableResponse post() {
        String _bodyRequest = "";
        return _request.body(_bodyRequest).post(this.getResource()).then().log().all();
    }

}

package views;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseView {

    private String _resource;
    private RequestSpecification _request;

    BaseView(String _webServiceURI, String basePath) {
        RestAssured.baseURI = _webServiceURI;
        this.setRequest(RestAssured.given());
        this.getRequest().basePath(basePath);
        this.getRequest().log().everything().when();
    }

    RequestSpecification getRequest(){ return this._request; }

    void setRequest(RequestSpecification request){ this._request = request; }


}

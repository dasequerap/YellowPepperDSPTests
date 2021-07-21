package views;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

import models.PetModel;

public class PetView extends BaseView{

    public PetView(String _webServiceURI) {
        super(_webServiceURI, "pet");
    }

    public ValidatableResponse getPetById(int petId){
        return this.getRequest().get( "{petId}", petId).then().log().everything();
    }

    public ValidatableResponse getPetsByStatus(String status){
        return this.getRequest()
                .queryParam("status", status).get( "/findByStatus").then().log().everything();
    }

    public ValidatableResponse createPet(PetModel pet){
        return this.getRequest().body(setJsonBodyParamsForPet(pet).toString()).post().then().log().everything();

    }

    public ValidatableResponse updatePet(PetModel pet){
        return this.getRequest().body(setJsonBodyParamsForPet(pet).toString()).put().then().log().everything();
    }

    private JSONObject setJsonBodyParamsForPet(PetModel pet){
        JSONObject bodyParams = new JSONObject();

        bodyParams.put("id", pet.getId());
        bodyParams.put("category", pet.getCategory());
        bodyParams.put("name", pet.getName());
        bodyParams.put("photoUrls", pet.getPhotoUrls());
        bodyParams.put("tags", pet.getTags());
        bodyParams.put("status", pet.getStatus());
        this.getRequest().header("Content-Type", "application/json");

        return bodyParams;
    }

}
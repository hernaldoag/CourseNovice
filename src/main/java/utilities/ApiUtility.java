package utilities;

import java.io.IOException;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
public class ApiUtility {
    public ApiUtility(){}


    public ClientResponse post (String url, String requestBody ){
        //String token
        try{
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestBody);
            // .header("Authorization", appKey)
            //invocationBuilder.header("Authorization", "Bearer "+"Api Key");
            return response;
        }catch (Exception e){

            e.printStackTrace();
        }

        return null;
    }

    public ClientResponse post (String url, String requestBody, String token){
        //String token
        try{
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, requestBody);
            // .header("Authorization", appKey)
            //invocationBuilder.header("Authorization", "Bearer "+"Api Key");
            return response;
        }catch (Exception e){

            e.printStackTrace();
        }

        return null;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public <T> T deserialization(String json, Class<T> clazz){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] responseMessages(String request){
        String strResult = request.replace("[","");
        strResult = strResult.replace("]","");
        strResult = strResult.replace("\"","");
        return strResult.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    }
}

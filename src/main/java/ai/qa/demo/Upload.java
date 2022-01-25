package ai.qa.demo;
import java.io.*;

import io.restassured.filter.session.SessionFilter;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.io.IOUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Upload {
    public static void main(String[] args)  {

        System.out.println("HI all");
        System.out.println(System.getProperty("readId"));
        System.out.println(System.getProperty("Env"));
        System.out.println("Test");
        RestAssured.baseURI="http://0.0.0.0:1144";
        //upload file
//        String filepath="D:/166c8a8e-e27a-4a46-92c1-7ffd547c6a6c_document-1_split-2.pdf";
//        Response result=given().multiPart(new File(filepath)).header("Content-Type","multipart/form-data").when().post("uploadfile").then().log().all().extract().response();
//
//
//
//        //get file
//        String downloadFilePath="D:/PythonCodes/PageSplitter/image (7).png";
//        String filenametoSave = downloadFilePath.substring(downloadFilePath.lastIndexOf('/') + 1);
//        byte[] file =given().header("Content-Type","application/json").body("{\n" +
//                "    \"path\":\""+downloadFilePath+"\"\n" +
//                "}").when().post("getfile").then().extract().asByteArray();
//
//        FileOutputStream fos;
//        try {
//            fos = new FileOutputStream(filenametoSave);
//            fos.write(file);
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String readId=System.getProperty("readId");
        System.out.println(readId);

        //read_data
        String read=given().header("Content-Type","application/json").queryParam("id",readId).when().get("read").then().extract().response().asString();
        System.out.println(read);

        //readall
        String  readall=given().header("Content-Type","application/json").when().get("readall").then().extract().response().asString();
        System.out.println(readall);

        //write_data
        String writeId=System.getProperty("writeId");
        String writeName=System.getProperty("writeName");
        System.out.println(writeId);
        System.out.println(writeId);
        String write=given().header("Content-Type","application/json").body("{\n" +
                "    \"id\":\""+writeId+"\",\n" +
                "    \"name\":\""+writeName+"\"\n" +
                "}").when().post("write").then().extract().response().asString();
        System.out.println(write);


        //update
        String update=given().header("Content-Type","application/json").body("{\n" +
                "    \"id\":\"5\",\n" +
                "    \"name\":\"raj\"\n" +
                "}").when().put("update").then().extract().response().asString();
        System.out.println(update);



        //delete
        ValidatableResponse delete=given().header("Content-Type","application/json").body("{\n" +
                "    \"id\":\"7\"\n" +
                "   \n" +
                "}").when().delete("delete").then().assertThat().statusCode(200).header("server","Werkzeug/2.0.1 Python/3.8.3");
        System.out.println(delete);





        //cookie
//        SessionFilter sessionFilter=new SessionFilter();
//        RestAssured.baseURI="https://gateway-stage-idc.infrrdapis.com/";
//        String loginResource="authentication/v1/login";
//        String uploadResource="upload/v2/user-model/558e6bc0-b1ae-4a96-8f02-b0d24f387856";
//        String filetobeUploaded="D:\\166c8a8e-e27a-4a46-92c1-7ffd547c6a6c_document-1_split-2.pdf";
//        String login=given().filter(sessionFilter).header("Content-Type","application/json").body("{\n" +
//                "    \"password\": \"Raj@2604\",\n" +
//                "        \"userName\": \"rajesh+admin@infrrd.ai\"\n" +
//                "}").when().post(loginResource).then().extract().response().asString();
//        System.out.println(login);
//
//        String upload=given().filter(sessionFilter).header("Content-Type","multipart/form-data").multiPart(new File(filetobeUploaded)).when().post(uploadResource).then().extract().response().asString();
//        System.out.println(upload);

    }

}



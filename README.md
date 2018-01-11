1.To run the project: 


        _Change Postgres db credentials in AppConfig

        _In Command Prompt: mvn jetty:run -Dorg.eclipse.jetty.annotations.maxWait=120         (If Session Timeout ) 
        
                            OR mvn jetty:run  
                       
                      

2. PostMan Syntax:

WITH SECURITY:

    POST ACCESS TOKEN: localhost:8080/oauth/token?grant_type=password&username=admin&password=admin    ( Authroization Type: Basic Auth )

  CRUD PART:

           GET : localhost:8080/applicants/?access_token=4ffe7891-acc0-42b9-a3d5-31634f48f3c0   ( replace applicants and access_token with correct ones )

           POST (ADD) : localhost:8080/applicants/?access_token=4ffe7891-acc0-42b9-a3d5-31634f48f3c0    ( replace applicants and access_token with correct ones )
           
           Click On Body Tab, choose Raw - JSON (application/json) - Authorization - Type: No Auth. 
           
           Syntax to Insert Data (Replace with correct ones):
                        {
        "name": "aaaaaaaa",
        "address": "hloe",
        "dob": "08/08",
        "gender": "coolest",
        "applications": [
            {
                "date": "08/08",
                "visatype": "F1",
                "singleEntry": false
            }
        ]
    }
           PUT (EDIT) : localhost:8080/applicants/1/?access_token=4ffe7891-acc0-42b9-a3d5-31634f48f3c0    ( replace applicants and access_token with correct ones )
           
           Click On Body Tab, choose Raw - JSON (application/json) - Authorization - Type: No Auth. 
           
           Syntax to Insert Data (Replace with correct ones) ( MAKE SURE THAT YOU HAVE CORRECT ID FOR BOTH APPLICANT AND APPLICATION )
                        {
                            "id":1,
                            "address": "123 To Hien Thanh",
                            "dob": "16/04",
                            "gender": "Male",
                            "name": "Tung",

                            "applications":[
                             {
                              "id":1,
                              "date": "16/04",
                              "visatype": "F1",
                              "isSingleEntry": true
                             }

                             ]
                           }
           
           
3. COMMON ERRORS:

       401 : error with method used in Postman. Check if use correct method in PostMan( Post for access token, get for view, post for add, put for update)
       
       404 : error with request mapping (check controller)

       415 : error with data type (when POST), check postman if the data entered is in order with correct data type with correct PostMan syntax

       500: hibernate error ( check model, service, controller)

       503: Server Not Started, check if mvn jetty:run works or have error on command prompt 




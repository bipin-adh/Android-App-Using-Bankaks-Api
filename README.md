## Android-App-Using-Bankaks-Api
This project is an application for the coding assessment provided by Bankaks .

## Problem Statement:

A user on the Bankaks mobile platform wants to make a bill payment for a given
particular country. As there are multiple countries, the inputs for each
of them will always be different. The solution is provided by the Backend team with all the necessary inputs in an API endpoint and then render the screen
dynamically. 

The flow for dynamic screen rendering is as follows:

In the first screen, the user will pick a service from a dropdown list. For this
assessment, we will have dummy options: Option 1, Option 2 and Option 3. Once
the option is selected and user proceeds, the API endpoint will be hit with an input
parameter called type and its value will be 1, 2, or 3, one for each of the options
correspondingly. 

The API response will have the contents and details of the dynamic screen to be
rendered after proceeding. This screen will be a form with a title, some inputs and a
proceed button. The inputs fields will have their UI Element Type, the placeholders
and the validation rules. The user will only be able to proceed, if all the validations
specified in the API response are satisfactory. If not, the user should be prompted
with an understandable error message.

## Package Hierarchy :

<img src="screenshot_package.png" width="400" height="600">     <img src="screenshot_res.png" width="400" height="600"> 

## Classes :

Following are some of important classes used in the project:

1. MainActivity --> Contains the home screen with dropdown menu and proceed button.
2. FormActivity --> Contains the layout which will inflate the form dynamically on reponse to the api reponse json data.
3. ApiResponseModel --> Contains the POJO/model class for the call made by Retrofit.
4. ApiClient --> Contains code required for Retrofit instance
5. ApiInterface --> Contains request type of Retrofit REST API call. (i.e. @GET )
6. RemoteDataProvider --> Handles the onResponse() and onFailed() methods of Retrofit API call.
7. Constants --> Provides constant values required through out the app.
8. FormContentProvider --> Provides the programmatically generated dynamic User Interface for different screens.

## Screenshots :

<img src="screenshot_home.png" width="300" height="600">   <img src="screenshot_dropdown.png" width="300" height="600">

<img src="screenshot_electricity_bill.png" width="300" height="600">   <img src="screenshot_water_bill.png" width="300" height="600">

## Libraries Used :

1. Retrofit
2. Constraint Layout

## Dependencies : 

* implementation 'com.google.code.gson:gson:2.8.5'
* implementation 'com.squareup.retrofit2:retrofit:2.5.0'
* implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
* implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    
 

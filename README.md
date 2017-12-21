# NY Times reader application

The application is using the NY Times Most Popular Articles API to show the most popular articles in the last 7 days.
Click on an article to read more or swipe down the list to refresh it.

![Application](showcase.gif)

## Run the app
To run the app simply generate an .apk by navigating to the root folder of the application in your terminal and use the command:
`./gradlew assembleIntegrationRelease`

Then install the generated apk on your device:
`adb install app/build/outputs/apk/integration/release/app-integration-release.apk`

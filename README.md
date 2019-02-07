# APPIUM 

This project is aimed at running mobile test cases in parallel with selenium grid

## Sctruture:
The project is divided into _Packages_ and _Files_, such as:
- Factory: It is aimed to setting the appium capabilites.
- Properties: To access properties files.
- Screen: Contains all page objects screen.
- Test: Contains all test cases.
- Apps: Contains the APK file that was generated through `./gradlew :app:assemble`
- androidNativeSuite.xml: It is the runner, so it allows to pass parameters regarding the device configuration.

## Running the tests

Firstly, access root folder of project via command line we have to set up the selenium grid in order to run the test suite in parallel. Let's do the following steps:

##### Start hub:
`java -jar selenium-server-standalone-3.14.0.jar -role hub`

##### Start FIRST node:
`appium --address 127.0.0.1 -bp 5523 --port 4754 --nodeconfig caps/android1-cap.json` 


##### Start SECOND node:

`appium --address 127.0.0.1 -bp 5525 --port 4756 --nodeconfig caps/android2-cap.json` 

##### Get UDID from Android devices:
Create a virtual device and/or connect a real device on computer. Following that, type `adb devices` on terminal.
Lastly, open the `androidNativeSuite.xml` file and replace the `udid` values in the parameter tag in xml file. 

##### How to run the test suite:
Run the file `androidNativeSuite.xml` that is in the root of project using TestNG.
After running, TestNG generates test report that is in the `test-output` file, access the file `index.html`. Open this file with a browser.

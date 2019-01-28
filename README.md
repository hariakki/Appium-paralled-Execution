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

Firstly, we have to set up the selenium grid in order to run the test suite in parallel. Let's do the following steps:

##### Create hub:
`java -jar /Users/.../selenium-server-standalone-3.141.59.jar -role hub`

##### Create FIRST node:
`appium --address 127.0.0.1 -bp 5523 --port 4754 --nodeconfig /Users/.../android1-cap.json` 

- android1-cap.json

```
{
    "capabilities": [{
        "browserName": "Android",
        "maxInstances": 1,
        "platform": "ANDROID",
        "deviceName": "emulator-5554",
        "newCommandTimeout": "30",
        "deviceReadyTimeout": 5
    }],
    "configuration": {
        "cleanUpCycle": 2000,
        "timeout": 10800,
        "url": "http://127.0.0.1:4754/wd/hub",
        "host": "127.0.0.1",
        "port": 4754,
        "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
        "maxSession": 1,
        "register": true,
        "registerCycle": 5000,
        "hubPort": 4444,
        "hubHost": "127.0.0.1",
        "session-override": true
    }
}
```

##### Create SECOND node:

`appium --address 127.0.0.1 -bp 5525 --port 4756 --nodeconfig /Users/.../android2-cap.json` 

- android2-cap.json

```
{
    "capabilities": [{
        "browserName": "Android",
        "maxInstances": 1,
        "platform": "ANDROID",
        "deviceName": "emulator-5556",
        "newCommandTimeout": "30",
        "deviceReadyTimeout": 5
    }],
    "configuration": {
        "cleanUpCycle": 2000,
        "timeout": 10800,
        "url": "http://127.0.0.1:4756/wd/hub",
        "host": "127.0.0.1",
        "port": 4756,
        "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
        "maxSession": 1,
        "register": true,
        "registerCycle": 5000,
        "hubPort": 4444,
        "hubHost": "127.0.0.1",
        "session-override": true
    }
}
```

##### Get UDID from Android devices:
Create a virtual device and/or connect a real device on computer. Following that, type `adb devices` on terminal.
Lastly, open the `androidNativeSuite.xml` file and replace the `udid` values in the parameter tag in xml file. 

##### How to run the test suite:
Run the file `androidNativeSuite.xml` that is in the root of project using TestNG.
After running, TestNG generates test report that is in the `test-output` file, access the file `index.html`. Open this file with a browser.

# Build it bigger - Udacity Android Nanodegree, project 4 
A joke telling app with multiple flavours and modules. The paid flavour uses banner and interstitial ads.

This app consist of four modules, a Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves the jokes, an Android Library containing an activity for displaying jokes,
and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

- Java library for supplying jokes
- Android library with an activity that displays jokes passed to it as intent extras.
- A Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
- Contains connected tests to verify that the async task is indeed loading jokes.
- Contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
- App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
- The free app variant displays interstitial ads between the main activity and the joke-displaying activity.
- The app displays a loading indicator while the joke is being fetched from the server.
- The root build.gradle file contains a task that will start up the GCE development server, run all Android tests, then shutdown the development server.

# Requirements
The app was developed with Android Studio and targets the Android Lollipop 5.1 (API 22) platform.

# Dependencies
Enumerated in the app's build.gradle, we require:

- [Android 5.1] (http://developer.android.com/about/versions/lollipop.html)
- [Android support libraries] (http://developer.android.com/tools/support-library/features.html)
- [Android play services] (https://developers.google.com/android/)

# Building and Running
Import the BuidItBigger folder into Android Studio as an existing project and select `Run > Run app`.

# ApexZBoard

ApexZBoard is an offline-first Android input method for English and Sinhala/Singlish typing, using a light-blue and white visual identity.

## Current implementation

This repository contains a real Android `InputMethodService`, Android activation flow, English QWERTY input, Sinhala phonetic mode, offline transliteration, input-method metadata, unit tests, and a GitHub Actions APK build.

The current release is an MVP foundation. Clipboard history, emoji search, calculator, stylish Unicode tools, Wijesekara layout, swipe typing, voice input, themes, and advanced settings are not yet implemented and are intentionally not represented as complete.

## Build

Requires JDK 17, Android SDK platform 35, and Gradle 8.9+ (the GitHub workflow uses the hosted `gradle` command). Run:

```bash
gradle testDebugUnitTest assembleDebug
```

The debug APK is written to `app/build/outputs/apk/debug/app-debug.apk`.

## Install and activate

Install the debug APK on an Android device, open ApexZBoard, choose **Enable Keyboard**, authorize it in Android settings, then choose **Select Keyboard** and select ApexZBoard. Android requires these user actions; the app does not silently enable or select itself.

## Privacy and permissions

The app declares only the protected `BIND_INPUT_METHOD` service permission. It does not request internet, contacts, storage, notification, accessibility, or microphone permissions. Basic typing and transliteration run locally. Password and sensitive data handling should be expanded and tested before a production release.

## CI

`.github/workflows/android-build.yml` runs unit tests and builds a real debug APK on manual dispatch or version tags. Tag builds also attach the APK to a GitHub Release.

## License

No license has been selected yet.

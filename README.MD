# README #

### SWIFT BANK CODE INDONESIA ###

### HOW TO CONTRIBUTE ###

    - star and fork this repo
    - Check and correct my code
    - update list Bank in /res/raw/bank.json

### HOW TO USE ###

   ## Gradle dependency :

   ```groovy
    dependencies {
       ...
       implementation 'com.github.kartubi:Android-Library-Swift-Bank-Indonesia:1.1'
    }
   ```

   ## Add it in your root build.gradle at the end of repositories :

    ```groovy
      allprojects {
      		repositories {
      			...
      			maven { url 'https://jitpack.io' }
      		}
      	}
    ```
    Opsional for hiding toolbar add to your manifest main apps:

    ```xml
     <activity
                android:name="com.pandalisme.swiftbankindonesia2.Banklist"
                android:theme="@style/Theme.AppCompat.Light.NoActionBar" />
    ```

   Call Bank list :
    ```java
     Intent i = new Intent(getApplicationContext(), Banklist.class);
            startActivityForResult(i, REQUEST_CODE_BANK);
    ```

    set Result in your Activity :

    ```java
     public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_CODE_BANK) {
                if (resultCode == RESULT_OK) {
                    Log.d("TAG", data.getStringExtra("name"));
                    Log.d("TAG", data.getStringExtra("code"));

                    setData(data.getStringExtra("name"), data.getStringExtra("code"));
                }
            }
        }
    ```

### WHO USE THIS LIBRARY ###
 - sampletext

contact me for attach : https://web.facebook.com/obih.145

# License

```
   Copyright (C) 2018 AHMAD KARTUBI

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License

```


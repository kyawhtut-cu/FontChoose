
# Font Chooser  
  
Application အတွက် မြန်မာ Language နှင့် English Language ရွေးချယ်ပြီး Unicode နှင့် Zawgyi အတွက် အလွယ်တကူအသုံးပြုရန်ဖြစ်ပါသည်။  
  
Font Converter အတွက်ကိုတော့ [Rabbit Converter](https://github.com/Rabbit-Converter/Rabbit-Java) ကို အသုံးပြုပြီး Convert လုပ်ပေးထားပါသည်။  
  
မြန်မာစာအတွက်ကို values-my Folder ထဲမှ strings.xml ထဲတွင်ရေးသားပြီး အင်္ဂလိပ်စာအတွက်ကို values Folder ထဲမှ strings.xml ထဲတွင်ရေးသားလို့ရပါသည်။  
  
Resource ထဲရှိ မြန်မာစာများကို အော်တို Convert ဖြစ်ဖို့အတွက်ဆိုရင် [MMTextView](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMTextView.kt) ကို အသုံးပြုပေးရပါမည်။  
  
Library မှ Support ပေးထားသည့် Component များကိုအောက်တွင်ကြည့်နိုင်ပါသည်။  
  
Support Components  
--------------  
  
| Component Name |  
|--|  
| [MMTextView](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMTextView.kt)  |  
| [MMButton](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMButton.kt)  |  
| [MMMaterialButton](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMMaterialButton.kt)  |  
| [MMEditText](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMEditText.kt)  |  
| [MMTextInputEditText](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMTextInputEditText.kt)  |  
| [MMTextInputLayout](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMTextInputLayout.kt)  |  
| [MMToolbar](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMToolbar.kt)  |  
| [MMNavigationView](https://github.com/kyawhtut-cu/FontChoose/blob/master/fontchooserlib/src/main/java/com/kyawhtut/fontchooserlib/component/MMNavigationView.kt)  |  
  
How to add to your project  
--------------  
  
1. Add jitpack.io to your root build.gradle file:  
  
     ```groovy  
       allprojects {  
         repositories {  
           ...  
           maven { url 'https://jitpack.io' }  
         }  
       }  
  
2. Add library to your app build.gradle file then sync  
  
   Release version - [![Download](https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/download.svg?sanitize=true)](https://github.com/kyawhtut-cu/FontChoose/releases/)  
  
   ```groovy  
   dependencies {  
      ...  
      implementation 'com.github.kyawhtut-cu:FontChoose:<version-release>'  
   }  
   ```  
  
Usage  
--------------  
  
    /* *  
       *  
       * FontChoose initialized in Activity onCreate().  
       * logo is your Application Logo (Drawable Res value)  
       * finish to finish activity automatically after user press back action without choose any choose. (Boolean value)  
       *  
       * */  
       FontChoose.init(activity, logo, finish)  
       setContentView()  
  
       /* *  
       *  
       * Change language and font from any activity  
       * logo is option. If you don't add logo, logo will initialize with first logo.  
       *  
       * */  
       FontChoose.change(activity, logo)  
  
       /* *  
       *  
       * To change resources.  
       * This is need to add any activity to change language.  
       * If you don't add this code in your activity, language will not change.  
       *  
       * */  
       override fun attachBaseContext(newBase: Context?) {  
            super.attachBaseContext(FontChoose.updateBaseContextLocale(newBase))  
        }  
  
  
Method  
--------------  
  
    If you know your font Unicode or Zawgyi, you can use 'FontChoose.isUnicode() or FontChoose.isZawgyi()' this method.  
  
    FontChoose.isUnicode()  
  
    FontChoose.isZawgyi()  
  
Extension  
--------------  
  
    String.toZawgyi()  
  
    String.toUni()  
  
    String.toDisplay(isUnicode) //this is automatically convert unicode or zawgyi and use in display.  
  
    String.toServer(isUnicode) //this is automatically convert unicode and use in to transfer data to server or something  
  
  
Screenshoot  
--------  
  <img alt="English Unicdoe Choose" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/en-uni-choose.png" width="250"/> <img alt="English Unicdoe" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/en-uni.png" width="250"/>
  
   <img alt="English Zawgyi Choose" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/en-zawgyi-choose.png" width="250"/> <img alt="English Zawgyi" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/en-zawgyi.png" width="250"/>
   
   <img alt="Myanmar Unicdoe Choose" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/mm-uni-choose.png" width="250"/> <img alt="Myanmar Unicdoe" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/mm-uni.png" width="250"/>
   
   <img alt="Myanmar Zawgyi Choose" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/mm-zawgyi-choose.png" width="250"/> <img alt="Myanmar Zawgyi" src="https://raw.githubusercontent.com/kyawhtut-cu/FontChoose/master/screenshoot/mm-zawgyi.png" width="250"/>
  
Credits  
--------  
  
Rabbit Converter Java: Rabbit Converter [https://github.com/Rabbit-Converter/Rabbit-Java](https://github.com/Rabbit-Converter/Rabbit-Java)  
  
License  
--------  
  
    Copyright 2019 kyawhtut-cu  
  
    Licensed under the Apache License, Version 2.0 (the "License");  
    you may not use this file except in compliance with the License.  
    You may obtain a copy of the License at  
  
       http://www.apache.org/licenses/LICENSE-2.0  
  
    Unless required by applicable law or agreed to in writing, software  
    distributed under the License is distributed on an "AS IS" BASIS,  
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
    See the License for the specific language governing permissions and  
    limitations under the License.

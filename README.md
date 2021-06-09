# Fetch-Exercise

## Hello Fetch Rewarding Evaluating team.

### 1. there is one main activity that holds fragment navigation with just one fragment

### 2.in the network package 
      there are two files one to as model and the other one
      used to connect to network and fetch the data using retrofit and moshi
      for pasring Json 

### 3.in the hiring list package there are 3 files
    a hiring adapter for recycler view where i used list adpater
    b hiring list fragment for binding and view model observer
    c hiring list view model where i used coroutine and sort the list
  
### depedinceis used are as follow

    // Navigation
    implementation "android.arch.navigation:navigation-fragment-ktx:$version_navigation"
    implementation "android.arch.navigation:navigation-ui-ktx:$version_navigation"

    // Retrofit for networking
    implementation "com.squareup.retrofit2:retrofit:$version_retrofit"
    implementation "com.squareup.retrofit2:converter-moshi:$version_retrofit"
    implementation "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$version_retrofit_coroutines_adapter"

    // Moshi for parsing the JSON format
    implementation "com.squareup.moshi:moshi:$version_moshi"
    implementation "com.squareup.moshi:moshi-kotlin:$version_moshi"

    // ViewModel and LiveData (arch components)
    implementation "androidx.lifecycle:lifecycle-extensions:$version_lifecycle_extensions"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"

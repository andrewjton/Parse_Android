package com.parse.starter;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseUser;

import java.util.List;

import audio.Phrase;

public class ParseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize Crash Reporting.
    ParseCrashReporting.enable(this);

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    //Parse.initialize(this);
    Parse.initialize(this, "kJawWr0883JUddCTgipaPphexvb3tPUY3Cq9E5uE", "cQCuAIKEwrYWmu4wvdYjwbbMFnBruLSupV7GQnh6");


    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);


    String name = "hi";
    String ObjectID = "hi";
    String author = "hi";

    List<Phrase> phrases = Phrase.queryPhrases();

    for (int i = 0; i < phrases.size(); i++){
      Log.d("score", "index: " + i +  "|  title: " + phrases.get(i).getTitle());
    }

  }
}

package audio;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew Ton on 7/17/15.
 */
public class Phrase {

    private String title;
    private String ObjectID;
    private String author;
    private static List<Phrase> phrases;

    public Phrase(String title, String ObjectID, String author){
        this.title = title;
        this.ObjectID = ObjectID;
        this.author = author;
    }

    //gets all the phrases from Parse
    public static List<Phrase> queryPhrases(){

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Phrases");
        query.whereEqualTo("Type", "Sound");


        query.findInBackground(new FindCallback<ParseObject>() {
             public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < scoreList.size(); i++){
                        ParseObject data  = scoreList.get(i);
                        Log.d("score", "Retrieved " + data.getString("Title") + "index: "  + i ) ;
                        Phrase phrase = new Phrase(data.getString("Title"), data.getString("ObjectID"), data.getString("author"));
                        phrases.add(phrase);
                    }



                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

        return phrases;
    }

    public String getTitle(){
        return title;
    }

    //downloads a specific phrase
    //public AudioFile downloadPhrase(String name){

//    }
}

package com.example.musicapp.UtilsPackage;

import com.example.musicapp.ModelsPackage.PlaylistModel;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class FirebaseManager {

    private FirebaseFirestore firestore;

    public void initFirestore() {
        firestore = FirebaseFirestore.getInstance();
    }

    public Task<QuerySnapshot> firestoreGetData(String language, String where, String with, String mood, String why) {
        return firestore.collection("songs")
                .whereEqualTo("language", language)
                .whereEqualTo("where", where)
                .whereEqualTo("with", with)
                .whereEqualTo("mood", mood)
                .whereEqualTo("why", why)
                .get();
    }

    public Task<DocumentReference> firestoreAddData(String language, String where, String with, String mood,
                                                    String why, String urlPlaylist) {
        PlaylistModel playlistModel = new PlaylistModel(language, where, with, mood, why, urlPlaylist);

        return firestore.collection("songs")
                .add(playlistModel);
    }

}

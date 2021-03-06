package com.example.troli.appagendamento.DAO;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by troli on 02/05/2018.
 */
@Database(entities = {Compromisso.class}, version =10 )
public abstract class AppDatabase extends RoomDatabase {

    public abstract CompromissoDAO compromissoDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if(INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "appCompromisso")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
            //INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "p2db").fallbackToDestructiveMigration().build();
            //INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "p2db").build();
        return INSTANCE;
    }
}

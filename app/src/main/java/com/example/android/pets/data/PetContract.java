package com.example.android.pets.data;

import android.net.Uri;
import android.provider.BaseColumns;

import java.net.URI;
import java.security.Provider;

/**
 * API Contract for the Pets app.
 */
public final class PetContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     * Used to help identify the Content Provider which we’d setup in the AndroidManifest tag.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     * To make this a usable URI, we use the parse method which takes in a URI string and returns a Uri.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * This constants store the path for each of the tables which will be appended to the base content URI.
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_PETS = "pets";

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class PetEntry implements BaseColumns {

        /**
         * The content URI to access the pet data in the provider.
         * Inside each of the Entry classes in the contract, we create a full URI for the class
         * as a constant called CONTENT_URI. The Uri.withAppendedPath() method appends the BASE_CONTENT_URI
         * (which contains the scheme and the content authority) to the path segment.
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        /** Name of database table for pets */
        public final static String TABLE_NAME = "pets";

        // Unique ID number for the pet (only for use in the database table).
        // Type: INTEGER
        public final static String _ID = BaseColumns._ID;
        // Name of the pet.
        // Type: TEXT
        public final static String COLUMN_PET_NAME ="name";
        // Breed of the pet.
        // Type: TEXT
        public final static String COLUMN_PET_BREED = "breed";
        // Gender of the pet.
        // The only possible values are {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE}, or {@link #GENDER_FEMALE}.
        // Type: INTEGER
        public final static String COLUMN_PET_GENDER = "gender";
        // Weight of the pet.
        // Type: INTEGER
        public final static String COLUMN_PET_WEIGHT = "weight";

        // Possible values for the gender of the pet.
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
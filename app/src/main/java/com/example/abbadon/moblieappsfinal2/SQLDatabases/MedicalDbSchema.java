package com.example.abbadon.moblieappsfinal2.SQLDatabases;

/**
 * Created by Abbadon on 12/12/2016.
 */

public class MedicalDbSchema {
    public static abstract class MedicalTable {
        public static final String NAME = "medical";
        public static final class Cols {
            public static final String TITLE = "title";
            public static final String DAY = "day";
            public static final String MONTH = "month";
            public static final String TIME = "time";
            public static final String PROFESSION = "profession";
            public static final String DESCRIPTION = "description";
        }
    }
}
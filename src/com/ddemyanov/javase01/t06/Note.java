package com.ddemyanov.javase01.t06;

import java.util.Arrays;

/**
 * Note class with <b>counter</b> and internal array <b>records</b>.
 * @author Дмитрий
 * @version 0.0.1
 */
public class Note {

    /**
     * Contains note records
     */
    private NoteRecord[] records;
    /**
     * Records counter. Increase every time when record added.
     */
    private int counter;


    /**
     * Constructor
     */
    public Note() {
        this.records = new NoteRecord[0];
        this.counter = 0;
    }

    /**
     * Adds new record
     * @param rec note record, which have to be added to the Note
     */
    public void addRecord(NoteRecord rec) {

        if (counter == records.length) {
            this.records = enlargeArraySize(this.records);
        }

        for (int i = 0; i < records.length; i++) {
            if (null == records[i]) {
                records[i] = rec;
                counter++;
                break;
            }
        }
    }

    /**
     * Delets selected record from Note
     * @param record note record, which have to be deleted from the Note
     */
    public void deleteRecord(Note record) {
        for (int i = 0; i < records.length; i++) {
            if ( record.equals(records[i]) ) {
                records[i] = null;
                break;
            }
        }
    }


    /**
     * Shows all records, which note contains
     */
    public void showAllRecords() {
        for ( NoteRecord r : records )
            if ( null != r ) System.out.println(r);
    }

    private NoteRecord[] getRecords() {
        return Arrays.copyOf(records, records.length);
    }

    public void setRecords(NoteRecord[] records) {
        this.records = Arrays.copyOf(records, records.length);
    }

    private NoteRecord[] enlargeArraySize(NoteRecord[] array) {
        return Arrays.copyOf(array, array.length + 10);
    }
}
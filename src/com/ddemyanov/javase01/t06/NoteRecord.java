package com.ddemyanov.javase01.t06;

/**
        * NoteRecord class with <b>header</b> and <b>body</b> parameters
        * @author Дмитрий
        * @version 0.0.1
 */
class NoteRecord {
    /**
     * Header field
     */
    private String header;

    /**
     * Body field
     */
    private String body;

    /**
     * Cconstructor
     * @param header contains header String
     * @param body contains body string
     */
    public NoteRecord( String header, String body) {
        this.header = header;
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteRecord that = (NoteRecord) o;

        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        return body != null ? body.equals(that.body) : that.body == null;
    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NoteRecord{" +
                "header='" + header + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
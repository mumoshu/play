package play.mvc;

public class Encoding {
    private static ThreadLocal<Encoding> current = new ThreadLocal<Encoding>();

    private static Encoding defaultEncoding = utf8();

    private String javaEncoding;
    private String httpEncoding;

    public Encoding(String javaEncoding, String httpEncoding) {
        this.javaEncoding = javaEncoding;
        this.httpEncoding = httpEncoding;
    }

    public String getJavaEncoding() {
        return javaEncoding;
    }

    public String getHttpEncoding() {
        return httpEncoding;
    }

    public static Encoding getCurrentEncoding() {
        if (current.get() == null) {
            current.set(defaultEncoding);
        }
        return current.get();
    }

    public static void setCurrentEncoding(Encoding encoding) {
        current.set(encoding);
    }

    public static Encoding sjis() {
        return new Encoding("sjis", "Shift_JIS");
    }

    public static Encoding utf8() {
        return new Encoding("utf-8", "utf-8");
    }

    public static void setDefaultEncoding(Encoding encoding) {
        defaultEncoding = encoding;
    }

    public static Encoding getDefaultEncoding() {
        return defaultEncoding;
    }
}

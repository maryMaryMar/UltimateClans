package me.ulrich.clans.library.enumconfig.library.error;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/error/MarkedYAMLException.class */
public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = -9119388488683035101L;
    private final String context;
    private final Mark contextMark;
    private final String problem;
    private final Mark problemMark;
    private final String note;

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3) {
        this(str, mark, str2, mark2, str3, null);
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, String str3, Throwable th) {
        super(str + "; " + str2 + "; " + mark2, th);
        this.context = str;
        this.contextMark = mark;
        this.problem = str2;
        this.problemMark = mark2;
        this.note = str3;
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2) {
        this(str, mark, str2, mark2, null, null);
    }

    protected MarkedYAMLException(String str, Mark mark, String str2, Mark mark2, Throwable th) {
        this(str, mark, str2, mark2, null, th);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.context != null) {
            sb.append(this.context);
            sb.append("\n");
        }
        if (this.contextMark != null && (this.problem == null || this.problemMark == null || this.contextMark.getName().equals(this.problemMark.getName()) || this.contextMark.getLine() != this.problemMark.getLine() || this.contextMark.getColumn() != this.problemMark.getColumn())) {
            sb.append(this.contextMark);
            sb.append("\n");
        }
        if (this.problem != null) {
            sb.append(this.problem);
            sb.append("\n");
        }
        if (this.problemMark != null) {
            sb.append(this.problemMark);
            sb.append("\n");
        }
        if (this.note != null) {
            sb.append(this.note);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getContext() {
        return this.context;
    }

    public Mark getContextMark() {
        return this.contextMark;
    }

    public String getProblem() {
        return this.problem;
    }

    public Mark getProblemMark() {
        return this.problemMark;
    }
}

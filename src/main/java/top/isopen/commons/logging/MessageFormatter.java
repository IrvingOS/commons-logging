package top.isopen.commons.logging;

import java.util.HashSet;
import java.util.Set;

/**
 * @author TimeChaser
 * @since 28/7/2022 下午5:59
 */
public final class MessageFormatter {

    private static final String DELIMITER = "{}";
    private static final char DELIMITER_START = '{';
    private static final char DELIMITER_STOP = '}';
    private static final char ESCAPED_CHAR = '\\';

    public static FormattedTuple format(String pattern, Object[] argsArray) {
        Throwable throwableCandidate = getThrowableCandidate(argsArray);
        Object[] args = argsArray;
        if (throwableCandidate != null) {
            args = trimmedCopy(argsArray);
        }
        return format(pattern, args, throwableCandidate);
    }

    public static FormattedTuple format(String pattern, Object[] args, Throwable throwable) {
        if (pattern == null) {
            return new FormattedTuple(null, args, throwable);
        }
        if (args == null) {
            return new FormattedTuple(pattern);
        }
        int i = 0;
        int j = 0;
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < args.length; k++) {
            j = pattern.indexOf(DELIMITER, i);
            if (j == -1) {
                if (i == 0) {
                    return new FormattedTuple(pattern, args, throwable);
                } else {
                    builder.append(pattern, i, pattern.length());
                    return new FormattedTuple(builder.toString(), args, throwable);
                }
            } else {
                if (isEscapedDelimiter(pattern, j)) {
                    if (!isDoubleEscaped(pattern, j)) {
                        k--;
                        builder.append(pattern, i, j - 1);
                        builder.append(DELIMITER_START);
                        i = j + 1;
                    } else {
                        builder.append(pattern, i, j - 1);
                        deepAppendParameter(builder, args[k], new HashSet<>());
                        i = j + 2;
                    }
                } else {
                    builder.append(pattern, i, j);
                    deepAppendParameter(builder, args[k], new HashSet<>());
                    i = j + 2;
                }
            }
        }
        builder.append(pattern, i, pattern.length());
        return new FormattedTuple(builder.toString(), args, throwable);
    }

    public static String formatToString(String pattern, Object object) {
        return formatToString(pattern, new Object[]{object});
    }

    public static String formatToString(String pattern, Object... objects) {
        return format(pattern, objects, null).getMessage();
    }

    public static Throwable getThrowableCandidate(Object[] argsArray) {
        if (argsArray == null || argsArray.length == 0) {
            return null;
        }
        Object object = argsArray[argsArray.length - 1];
        if (object instanceof Throwable) {
            return (Throwable) object;
        }
        return null;
    }

    private static void booleanArrayAppend(StringBuilder builder, boolean[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    private static void byteArrayAppend(StringBuilder builder, byte[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    private static void charArrayAppend(StringBuilder builder, char[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    private static void deepAppendParameter(StringBuilder builder, Object param, Set<Object[]> seenSet) {
        if (param == null) {
            builder.append("null");
            return;
        }
        if (!param.getClass().isArray()) {
            safeObjectAppend(builder, param);
        } else {
            if (param instanceof byte[]) {
                byteArrayAppend(builder, (byte[]) param);
            } else if (param instanceof boolean[]) {
                booleanArrayAppend(builder, (boolean[]) param);
            } else if (param instanceof char[]) {
                charArrayAppend(builder, (char[]) param);
            } else if (param instanceof short[]) {
                shortArrayAppend(builder, (short[]) param);
            } else if (param instanceof int[]) {
                intArrayAppend(builder, (int[]) param);
            } else if (param instanceof long[]) {
                longArrayAppend(builder, (long[]) param);
            } else if (param instanceof float[]) {
                floatArrayAppend(builder, (float[]) param);
            } else if (param instanceof double[]) {
                doubleArrayAppend(builder, (double[]) param);
            } else {
                objectArrayAppend(builder, ((Object[]) param), seenSet);
            }
        }
    }

    private static void doubleArrayAppend(StringBuilder builder, double[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    private static void floatArrayAppend(StringBuilder builder, float[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    private static void intArrayAppend(StringBuilder builder, int[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    /**
     * 检查分隔符之前是否是双重转义符
     *
     * @param pattern             模式串
     * @param delimiterStartIndex { 的索引
     * @return boolean
     */
    private static boolean isDoubleEscaped(String pattern, int delimiterStartIndex) {
        return delimiterStartIndex >= 2 && pattern.charAt(delimiterStartIndex - 2) == ESCAPED_CHAR;
    }

    /**
     * 检查分隔符之前是否是转义符
     *
     * @param pattern             模式串
     * @param delimiterStartIndex { 的索引
     * @return boolean
     */
    private static boolean isEscapedDelimiter(String pattern, int delimiterStartIndex) {
        if (delimiterStartIndex == 0) {
            return false;
        }
        return pattern.charAt(delimiterStartIndex - 1) == ESCAPED_CHAR;
    }

    private static void longArrayAppend(StringBuilder builder, long[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    /**
     * 对象数组的拼接
     * <p>
     * 使用 Set 来判断是为了防止在对象数组中出现对自身本体的引用而导致死循环
     *
     * @param builder StringBuilder
     * @param param   Object[]
     * @param seenSet Set<Object[]>
     */
    private static void objectArrayAppend(StringBuilder builder, Object[] param, Set<Object[]> seenSet) {
        builder.append('[');
        if (!seenSet.contains(param)) {
            seenSet.add(param);
            final int length = param.length;
            for (int i = 0; i < length; i++) {
                deepAppendParameter(builder, param[i], seenSet);
                if (i != length - 1) {
                    builder.append(',').append(' ');
                }
            }
            seenSet.remove(param);
        } else {
            builder.append("...");
        }
        builder.append(']');
    }

    private static void safeObjectAppend(StringBuilder builder, Object param) {
        try {
            builder.append(param.toString());
        } catch (Throwable throwable) {
            builder.append("[FAILED toString()]");
        }
    }

    private static void shortArrayAppend(StringBuilder builder, short[] param) {
        builder.append('[');
        final int length = param.length;
        for (int i = 0; i < length; i++) {
            builder.append(param[i]);
            if (i != length - 1) {
                builder.append(',').append(' ');
            }
        }
        builder.append(']');
    }

    private static Object[] trimmedCopy(Object[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalStateException("nonsensical empty or null argument array");
        }
        Object[] trimmed = new Object[array.length - 1];
        if (trimmed.length > 0) {
            System.arraycopy(array, 0, trimmed, 0, trimmed.length);
        }
        return trimmed;
    }

}

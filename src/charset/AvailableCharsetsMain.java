package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;

public class AvailableCharsetsMain {

    public static void main(String[] args) {
        // 이용 가능한 모든 Charset 자바 + OS
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        for (String s : stringCharsetSortedMap.keySet()) {
            System.out.println("charsetName = " + s);
        }

        System.out.println("======");
        // 문자로 조회
        Charset cSet1 = Charset.forName("MS949");
        System.out.println("문자 혹은 지정 별칭 조회 = " + cSet1);

        // UTF-8 조회
        Charset utf8Charset = StandardCharsets.UTF_8;
        System.out.println("utf8Charset = " + utf8Charset);

        // 시스템의 기본 charset 조회
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("시스템의 기본 Charset 조회 = " + defaultCharset);

    }
}
